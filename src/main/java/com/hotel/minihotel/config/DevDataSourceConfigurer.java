package com.informatique.gov.helpdesk.config;

import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DevDataSourceConfigurer {
	@Bean(name = "dataSource")
	@Profile({ "dev" })
	@QuartzDataSource
	@ConfigurationProperties("app.datasource")
	public org.apache.tomcat.jdbc.pool.DataSource dataSourceCreator() {
		return (org.apache.tomcat.jdbc.pool.DataSource) DataSourceBuilder.create()
				.type(org.apache.tomcat.jdbc.pool.DataSource.class).build();
	}
}
