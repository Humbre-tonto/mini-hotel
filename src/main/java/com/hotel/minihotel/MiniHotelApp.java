package com.informatique.gov.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {QuartzAutoConfiguration.class})
public class ShowdogApp extends SpringBootServletInitializer  implements WebApplicationInitializer 
{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShowdogApp.class);
    }
	
    public static void main( String[] args )
    {
        SpringApplication.run(ShowdogApp.class, args);
    }
}
