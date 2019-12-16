package com.hotel.minihotel.support.security;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class OnlyLoginBasicAuthenticationFilter extends BasicAuthenticationFilter{
	
	
	private final Logger logger = LoggerFactory.getLogger(OnlyLoginBasicAuthenticationFilter.class);

	public OnlyLoginBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	public OnlyLoginBasicAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationManager, authenticationEntryPoint);
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
					throws IOException, ServletException {
		
		final boolean debug = logger.isDebugEnabled();
		
		if(debug) {
			logger.debug("RequestURI : " + request.getRequestURI());
			logger.debug("Evaluating RequestURI ends with : " + Constants.LOGIN_URL + ", results : " + request.getRequestURI().endsWith(Constants.LOGIN_URL));
		}
		
		if(request.getRequestURI().endsWith(Constants.LOGIN_URL)){
			
			if(debug) {
				logger.debug("Using BasicAuthenticationFilter.doFilterInternal...");
			}
			
			super.doFilterInternal(request, response, chain);
		}else {
			chain.doFilter(request, response);
		}
	}

}
