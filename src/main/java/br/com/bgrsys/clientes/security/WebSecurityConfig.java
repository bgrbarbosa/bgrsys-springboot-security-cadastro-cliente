package br.com.bgrsys.clientes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/* 
 * Essa Classe apresenta métodos de autenticação em memória, usando o conceito de Basic Autentication.
 * Para que um determinado usuário consiga consumir eses dados, é necessário acrescentar os dados de autenticação.
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/* Método pelo qual faz o controle de acesso na API, bloqueando e permitindo o acesso */
	@Override
	protected void configure(HttpSecurity http)throws Exception{	
		http
			.httpBasic()
			.and()
				.authorizeRequests()
				.anyRequest().authenticated()
			.and()
				.csrf().disable();
	}
	
	/* Método pelo qual gerencia a autenticação na API */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	
		auth.inMemoryAuthentication()			
			.withUser("bruno")
			.password(passwordEncoder().encode("123456"))
			.roles("ADMIN");
	}
	
   /* 
	* Bean utilizado para encodar o password em uma criptografia. Pois para que o 
	*método de autenticação, exige que a senha esteja criptografada
	*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
