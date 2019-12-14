package com.informatique.gov.helpdesk.support.security;

public class Constants {
	
	public static final String CSRF_TOKEN_NAME = "x-xsrf-token";
	public static final String AUTHENTICATION_TOKEN_NAME = "x-auth-token";
	public static final String LOGIN_URL = "/api/login";
	public static final String LOGOUT_URL = "/api/logout";
	public static final String API_DOCUMENTATION_URL = "/api/v2/api-docs";
	public static final String ANONYMOUS_PRINCIPLE = "ANONYMOUS";
	public static final int MAXIMUM_SESSIONS = 1;
	
	private Constants(){
		
	}
}
