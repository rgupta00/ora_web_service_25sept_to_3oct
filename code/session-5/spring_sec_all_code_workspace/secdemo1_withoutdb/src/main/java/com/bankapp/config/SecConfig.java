package com.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecConfig {

	// authentication
	@Bean
	UserDetailsService detailsService(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("raj").password(encoder.encode("raj123")).roles("ADMIN", "MGR").build();
		UserDetails mgr = User.withUsername("ekta").password(encoder.encode("ekta123")).roles("MGR").build();

		return new InMemoryUserDetailsManager(admin, mgr);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// authrorization
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(AbstractHttpConfigurer::disable)
				.cors(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(registry ->
						registry.requestMatchers("/admin/**").hasAnyRole("ADMIN")
						.requestMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
						.requestMatchers("/home/**").permitAll()
						.anyRequest().authenticated()
						)
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.build();
	}

}
