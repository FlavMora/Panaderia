package com.Panaderia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Bean para codificar las contraseñas usando BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración de seguridad HTTP
    
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Las rutas que comienzan con /admin/ solo pueden ser accedidas por usuarios con rol ADMIN
                .antMatchers("/admin/**").hasRole("ADMIN")
                // Las rutas que comienzan con /cliente/ solo pueden ser accedidas por usuarios con rol CLIENTE
                .antMatchers("/cliente/**").hasRole("CLIENTE")
                // Cualquier otra solicitud debe estar autenticada
                .anyRequest().authenticated()
            .and()
            .formLogin()
                // Configura la página de login personalizada
                .loginPage("/login")
                // Permite el acceso a todos a la página de login
                .permitAll()
            .and()
            .logout()
                // Permite el acceso a todos al logout
                .permitAll();
    }
}
