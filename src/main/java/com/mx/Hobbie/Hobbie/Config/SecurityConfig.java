package com.mx.Hobbie.Hobbie.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.mx.Hobbie.Hobbie.Service.UserAUService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserAUService userAuService;
	
	@Bean
	SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(
				authorize -> authorize
				.requestMatchers("/api/hobbie/guardar").hasRole("ADMIN")
				.requestMatchers("/api/hobbie/editar").hasRole("ADMIN")
				.requestMatchers("/api/hobbie/eliminar").hasRole("ADMIN")
				.anyRequest().permitAll()
				)
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	//@Bean
	//UserDetailsService userDetailsService() {
	//	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		//manager.createUser(
		//		User.withDefaultPasswordEncoder()
		//		.username("enucom")
		//		.password("1234")
			//	.roles("ADMIN")
			//	.build()
			//	);
		//manager.createUser(
		//		User.withDefaultPasswordEncoder()
		//		.username("fatt")
			//	.password("12345")
			//	.roles("USER")
			//	.build()
			//	);
				
		//	return manager;
	
	@Bean
	public AuthenticationManager autenticationManager(AuthenticationConfiguration confg) throws Exception{
		return confg.getAuthenticationManager();
	}
				
	@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }	
	
		
	}


