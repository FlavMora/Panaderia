package com.Panaderia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired; // Import Autowired

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("juan")
                .password("{noop}123")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        UserDetails sales = User.builder()
                .username("rebeca")
                .password("{noop}456")
                .roles("VENDEDOR", "USER")
                .build();
        UserDetails user = User.builder()
                .username("pedro")
                .password("{noop}789")
                .roles("USER")
                .build();
        UserDetails eruiz30353 = User.builder()
                .username("eruiz30353")
                .password("{noop}30353")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, sales, admin, eruiz30353);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/",
                                "/css/**",
                                "/images/**",
                                "/index",
                                "/js/**",
                                "/logout",
                                "/pasteles/listado",
                                "/postres/listado",
                                "/reposterias/listado",
                                "/resena/listado",
                                "/webjars/**")
                        .permitAll()
                        .requestMatchers(
                                "/admin/**",
                                "/postres/**",
                                "/reposterias/**",
                                "/resena/**",
                                "pasteles/**"
                        ).hasRole("ADMIN")
                        .requestMatchers("/carrito/**").hasRole("USER")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());

        return http.build();
    }
}