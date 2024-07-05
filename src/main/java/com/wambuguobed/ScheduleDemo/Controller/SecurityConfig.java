package com.wambuguobed.ScheduleDemo.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    TeacherDetailsService teacherDetailsService() {
//        return new TeacherDetailsService();
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//
//        return new BCryptPasswordEncoder();
//    }
//    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
//            new User(
//                    "sbgaks@gmail.com",
//                    "password",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE ADMIN"))
//            ),
//            new User(
//                    "obed@gmail.com",
//                    "password",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE USER"))
//            )
//    );
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(teacherDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.authenticationProvider(authenticationProvider());
        http
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().permitAll())
                //.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
//                .authorizeHttpRequests((authorize) -> authorize
//                        .anyRequest().authenticated()
//                )
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }



//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder().encode("userPass"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withUsername("user")
//                .password(passwordEncoder().encode("userPass"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//                return APPLICATION_USERS
//                        .stream()
//                        .filter(user -> user.getUsername().equals(email))
//                        .findFirst()
//                        .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
//            }
//        };
//    }
}
