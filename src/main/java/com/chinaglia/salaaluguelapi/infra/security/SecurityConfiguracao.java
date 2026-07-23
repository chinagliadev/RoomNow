package com.chinaglia.salaaluguelapi.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguracao {
	
	private final SecurityFilter securityFilter;

	SecurityConfiguracao(SecurityFilter securityFilter) {
		this.securityFilter = securityFilter;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	    return httpSecurity
	            .cors(Customizer.withDefaults()) 
	            .csrf(csrf -> csrf.disable())
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .authorizeHttpRequests(authorize -> authorize
	                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // <- libera o preflight
	                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
	                    .requestMatchers(HttpMethod.POST, "/auth/registrar").permitAll()
	                    .requestMatchers(HttpMethod.GET, "/", "/*.html", "/*.css", "/*.js", "/css/**", "/js/**").permitAll()
	                    .requestMatchers(HttpMethod.POST, "/sala").hasRole("ADMIN")
	                    .anyRequest().authenticated()
	            )
	            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
	            .build();
	}
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration authConfig) 
	{
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder () 
	{
		return new BCryptPasswordEncoder();
	}
	
}
