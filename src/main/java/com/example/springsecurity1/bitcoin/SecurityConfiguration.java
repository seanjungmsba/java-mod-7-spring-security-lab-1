package com.example.springsecurity1.bitcoin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // we could require the "admin" authority for both the /status and /hello URLs with the following configure() method
        // NOTE: antMatchers can be chained and should be ordered from most specific to least specific,
//        http.authorizeRequests()
//                .antMatchers("/status")
//                .hasAuthority("admin")
//                .antMatchers("/hello")
//                .hasAuthority("admin");

        http.authorizeRequests()
                .anyRequest()
                // instead of asking any request to have the permitAll() method apply to it,
                // we are saying that any request actually needs to be authenticated() in order to proceed
                .authenticated()
                // The and() after the call to authenticated() allows us to chain
                // together all the calls we need in order to configure our Spring Security,
                .and()
                // The next instruction we give to Spring Security is to enable formLogin() as the authentication method.
                .formLogin()
                .and() // add to the chain
                .httpBasic()
                .and()
                .logout(); // request a logout form
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // We create a user details service that can manage all the users we will add to it "in memory"
        // this means these users will not be saved to file or in a database anywhere, and will cease to exist when the application is stopped.
        // This would not work for a production-level application,
        // but it is a good way to demonstrate the mechanism of UserDetailsService without having to worry about persistence or service integration.
        InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();

        // we have given our user1 the "read" authority
        UserDetails user1 = User.withUsername("user")
                .password(passwordEncoder().encode("1234"))
                .authorities("read")
                .build();
        userDetailService.createUser(user1);

        // we have given our adminUser1 the "admin" authority.
//        UserDetails adminUser1 = User.withUsername("admin")
//                .password(passwordEncoder().encode("test"))
//                .authorities("admin")
//                .build();
//        userDetailService.createUser(adminUser1);

        return userDetailService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
