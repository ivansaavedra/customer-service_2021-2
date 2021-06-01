package com.dws.customerservice.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.dws.customerservice.service.UsuarioServiceImp;


@Configuration
@EnableWebSecurity
public class SpringBootSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	 JwtTokenProvider jwtTokenProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder autenticacion) throws Exception{
		UserDetailsService userDetailsService = detallesUsuario();
		autenticacion.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Reglas para restringir acceso segun roles de usuario
		http.httpBasic().disable().csrf().disable().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
			.antMatchers("/api/autenticacion/login", "/api/autenticacion/registro", "/usuario/").permitAll()
			.antMatchers("/ruta_restringida/**").hasAuthority("ADMINISTRADOR").anyRequest().authenticated().and().csrf()
			.disable().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint()).and()
			.apply(new JwtConfigurer(jwtTokenProvider));
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources/**", 
									"/css/**", 
									"/assets/**", 
									"/js/**",
									"/v2/api-docs",
					                "/configuration/ui",
					                "/swagger-resources/**",
					                "/configuration/security",
					                "/swagger-ui.html",
					                "/webjars/**");
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public AuthenticationEntryPoint unauthorizedEntryPoint() {
		return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
	}

	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService detallesUsuario() {
		return new UsuarioServiceImp();
	}
}