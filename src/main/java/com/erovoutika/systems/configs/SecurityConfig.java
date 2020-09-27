package com.erovoutika.systems.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * SecurityConfig
 */
@EnableWebSecurity
public class SecurityConfig {
	// @Autowired
	// Securityhandler successHandler;
	
	public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

	@Configuration
	@EnableWebSecurity
	public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
		  
		//Hibernate Integration
		@Autowired
		@Qualifier("accountAuthorization")
	private DataSource securityDataSource;

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	// 	auth.jdbcAuthentication().dataSource(securityDataSource).passwordEncoder(encoder());
	// }
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
				  throws Exception {
				auth.jdbcAuthentication()
				  .dataSource(securityDataSource)
			  .usersByUsernameQuery("select email,password,enabled "
			   + "from users "
			+ "where email = ?")
			  .authoritiesByUsernameQuery("select email,authority "
				+ "from authorities "
			   + "where email = ?");
}
		@Override
		protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/dashboard/**").hasAnyRole("USER", "ADMIN")
            .and()
            .formLogin()
				.loginPage("/login")
				.usernameParameter("email")
				.passwordParameter("password")
                .loginProcessingUrl("/v2")
                .successForwardUrl("/dashboard")
				.permitAll()
				// .successHandler(successHandler)
            .and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.permitAll()
				.logoutSuccessUrl("/login")
            		.and()
						.exceptionHandling()
			
						.accessDeniedPage("/access-denied");
		}
	
	}
}

