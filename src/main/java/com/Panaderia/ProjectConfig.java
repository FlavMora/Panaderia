package com.Panaderia;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebSecurity
public class ProjectConfig implements WebMvcConfigurer {

    //os siguientes métodos son para incorporar el tema de internacionalización en el proyecto*/

    //localeResolver se utiliza para crear una sesión de cambio de idioma */
    @Bean
public LocaleResolver localeResolver() {
    var slr = new SessionLocaleResolver();
    slr.setDefaultLocale(Locale.getDefault());
    slr.setLocaleAttributeName("session.current.locale");
    slr.setTimeZoneAttributeName("session.current.timezone");
    return slr;
}


    //localeChangeInterceptor se utiliza para crear un interceptor de cambio de idioma*/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    // Bean para poder acceder a los Messages.properties en código...
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /*
     * Configuración de seguridad para la aplicación
     */

    // Bean para codificar las contraseñas usando BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración de seguridad HTTP
    @Override
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
