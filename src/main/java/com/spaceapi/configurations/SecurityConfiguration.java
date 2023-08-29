package com.spaceapi.configurations;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        if(activeProfile.equals("test")){
            http.csrf((csfr) -> csfr.disable())
                    .authorizeHttpRequests((authorize) ->
                            authorize
                                    .anyRequest()
                                    .permitAll()
                    );
        }



        http
                .csrf((csfr) -> csfr.disable())
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/animes/addAnime").hasRole("ADMIN")
                                .requestMatchers("/animes/edit").hasRole("ADMIN")
                                .requestMatchers("/animes/delete").hasRole("ADMIN")
                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .anyRequest()
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement((session) ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();
    }

}
