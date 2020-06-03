package br.nom.consani.gerenciadorativos;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.headers().frameOptions().disable();
		
		http.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/fonts/**").permitAll()
			.antMatchers("/login*").permitAll()
			.antMatchers("/ativos/novo").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST,"/ativos").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/ativos").hasAnyRole("USUARIO","ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
	        //.loginProcessingUrl("/perform_login")
	        .defaultSuccessUrl("/ativos", true)
	        .failureUrl("/login?error=true")
	        //.failureHandler(authenticationFailureHandler())
	        .and()
	        .logout()
	        .logoutSuccessUrl("/login")
	        .deleteCookies("JSESSIONID");
		
		
		
	}
	
	@Override
	  public void configure(AuthenticationManagerBuilder builder) throws Exception {
	
		builder.inMemoryAuthentication()
	           .withUser("admin").password("{noop}admin")
	           .roles("ADMIN")
	           .and()
	           .withUser("user").password("{noop}user")
	           .roles("USUARIO");
	 }
	
	
	
}
