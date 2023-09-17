package io.github.jornadamilhas.Infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecutiry {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/**").permitAll()  // Permitir todos os acessos
                )
                .csrf(AbstractHttpConfigurer::disable)  // Desabilitar CSRF
                .cors(AbstractHttpConfigurer::disable)  // Desabilitar CORS
                .build();
    }

}

