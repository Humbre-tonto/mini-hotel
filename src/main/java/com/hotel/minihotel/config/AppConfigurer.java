package com.hotel.minihotel.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotel.minihotel.support.dataenum.UserRoleEnum;
import com.hotel.minihotel.support.security.HotelGrantedAuthority;

@Configuration
public class AppConfigurer {
	
	
	
	
	@Bean
	public List<HotelGrantedAuthority> internalAuthorities(){
		return Collections.unmodifiableList(Arrays.asList(new HotelGrantedAuthority(UserRoleEnum.HELPDESK_AGENT), 
		           new HotelGrantedAuthority(UserRoleEnum.SECTION_HEAD),  new HotelGrantedAuthority(UserRoleEnum.DEPARTMENT_HEAD)));
	} 
}
