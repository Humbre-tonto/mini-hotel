package com.informatique.gov.helpdesk.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.session.ExpiringSession;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.informatique.gov.helpdesk.support.security.Constants;
import com.informatique.gov.helpdesk.support.security.HelpdeskAuthenticationProvider;
import com.informatique.gov.helpdesk.support.security.OnlyLoginBasicAuthenticationFilter;
import com.informatique.gov.helpdesk.support.security.RestAuthenticationEntryPoint;

@Profile("!dev")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SessionRepositoryFilter<?> sessionRepositoryFilter;
	
	@Autowired
	private HelpdeskAuthenticationProvider helpdeskAuthenticationProvider;
	
	@Autowired
	private FindByIndexNameSessionRepository<? extends ExpiringSession> findByIndexNameSessionRepository;
	
	@Bean
	public CommandLineRunner setSecurityContextHolderStrategyNameCommand() {
		return (str) -> SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.addFilterBefore(sessionRepositoryFilter, SecurityContextPersistenceFilter.class)
		.cors().configurationSource(corsConfigurationSource()).and()
		//.csrf().csrfTokenRepository(csrfTokenRepository()).and()
		.csrf().disable()
		
		.logout().logoutUrl(Constants.LOGOUT_URL).logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK));
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).
		maximumSessions(Constants.MAXIMUM_SESSIONS).sessionRegistry(sessionRegistry()).expiredSessionStrategy(expiredSessionStrategy() );

		http.addFilterBefore(onlyLoginBasicAuthenticationFilter(), RequestCacheAwareFilter.class).exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint());
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v2/api-docs").permitAll();
	    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/swagger-ui.html").permitAll();
	    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/swagger-resources/**").permitAll();
	    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/csrf").permitAll();
	    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/").permitAll();
	    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/webjars/**").permitAll();
	    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/notificationsWebsocket/**").permitAll();
		http.authorizeRequests().antMatchers("/api/**").authenticated();
	}
	public SessionInformationExpiredStrategy expiredSessionStrategy() {
		return (event) -> {
			HttpServletResponse response = event.getResponse();			
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
		};
	}
	
	@SuppressWarnings("unchecked")
	public SessionRegistry sessionRegistry() {
		SessionRegistry sessionRegistry = new SpringSessionBackedSessionRegistry((FindByIndexNameSessionRepository<ExpiringSession>) findByIndexNameSessionRepository);
	    return sessionRegistry;
	}
	
	@Bean
	public GrantedAuthorityDefaults grantedAuthorityDefaults() {
	    return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
	}
	
	@Bean
	public AuthenticationEntryPoint restAuthenticationEntryPoint() {
		AuthenticationEntryPoint authenticationEntryPoint = new RestAuthenticationEntryPoint();
		return authenticationEntryPoint;
	}

	@Bean
	public OnlyLoginBasicAuthenticationFilter onlyLoginBasicAuthenticationFilter() throws Exception {
		OnlyLoginBasicAuthenticationFilter onlyLoginBasicAuthenticationFilter = new OnlyLoginBasicAuthenticationFilter(
				authenticationManagerBean(), restAuthenticationEntryPoint());

		return onlyLoginBasicAuthenticationFilter;
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(helpdeskAuthenticationProvider);
	}

//	private CsrfTokenRepository csrfTokenRepository() {
//		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//		repository.setHeaderName(Constants.CSRF_TOKEN_NAME);
//		return repository;
//	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("Authorization");
		config.addAllowedHeader("Content-Type");
		config.addAllowedHeader(Constants.AUTHENTICATION_TOKEN_NAME);
		config.addAllowedHeader("If-None-Match");
		config.addAllowedHeader("If-Match");
		config.addExposedHeader("ETag");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}
