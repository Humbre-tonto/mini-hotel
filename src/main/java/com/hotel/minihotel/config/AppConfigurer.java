package com.informatique.gov.helpdesk.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.informatique.gov.helpdesk.support.dataenum.UserRoleEnum;
import com.informatique.gov.helpdesk.support.security.HelpdeskGrantedAuthority;

@Configuration
public class AppConfigurer {
	
	
	
	
	@Bean
	public List<HelpdeskGrantedAuthority> internalAuthorities(){
		return Collections.unmodifiableList(Arrays.asList(new HelpdeskGrantedAuthority(UserRoleEnum.HELPDESK_AGENT), 
		           new HelpdeskGrantedAuthority(UserRoleEnum.SECTION_HEAD),  new HelpdeskGrantedAuthority(UserRoleEnum.DEPARTMENT_HEAD)));
	} 
}
