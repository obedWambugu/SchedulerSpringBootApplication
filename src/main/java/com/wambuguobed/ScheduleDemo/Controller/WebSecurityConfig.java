package com.wambuguobed.ScheduleDemo.Controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    @Bean
    TeacherDetailsService teacherDetailsService() {
        return new TeacherDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(teacherDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authenticationProvider(authenticationProvider());

        http.authorizeHttpRequests(auth ->
                        auth.requestMatchers("/teacher/check_schedule").authenticated()
                                .anyRequest().permitAll()
                        
                )
                .formLogin(login ->
                        login.usernameParameter("userName")
                                .defaultSuccessUrl("/teacher/check_schedule")
                                .permitAll()
                )
                .logout(logout -> logout.logoutSuccessUrl("/").permitAll()
                );

        return http.build();
    }
}