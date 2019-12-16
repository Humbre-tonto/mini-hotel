package com.hotel.minihotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {QuartzAutoConfiguration.class})
public class MiniHotelApp extends SpringBootServletInitializer  implements WebApplicationInitializer 
{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MiniHotelApp.class);
    }
	
    public static void main( String[] args )
    {
        SpringApplication.run(MiniHotelApp.class, args);
    }
}
