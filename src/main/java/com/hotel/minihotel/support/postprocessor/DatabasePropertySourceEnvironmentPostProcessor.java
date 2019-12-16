package com.hotel.minihotel.support.postprocessor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

public class DatabasePropertySourceEnvironmentPostProcessor implements EnvironmentPostProcessor {
	
	private final Logger logger = LoggerFactory.getLogger(DatabasePropertySourceEnvironmentPostProcessor.class);
	private static final String CONFIG_QUERY = "select key, value, description from configuration";

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		
		String activeProfile = environment.getActiveProfiles()[0];
		
		DataSource dataSource = null;
		if(activeProfile.equals("dev")) {
			dataSource = DataSourceBuilder.create().type(org.apache.tomcat.jdbc.pool.DataSource.class)
			                          .url(environment.getRequiredProperty("app.datasource.url"))
			                          .username(environment.getRequiredProperty("app.datasource.username"))
			                          .password(environment.getRequiredProperty("app.datasource.password")).build();
			
			
		}else {
			dataSource = new JndiDataSourceLookup().getDataSource(environment.getRequiredProperty("app.datasource.lookup-name"));
		}
		
		try (Connection connection = dataSource.getConnection(); Statement stmnt = connection.createStatement(); ResultSet rs = stmnt.executeQuery(CONFIG_QUERY)){
			
			
			
			Map<String, Object> props = new HashMap<>();
			while(rs.next()) {
				props.put(rs.getString("key"), rs.getObject("value"));
			}
			
			MapPropertySource mapPropertySource = new MapPropertySource("DatabaseProperties", props);
			
			environment.getPropertySources().addFirst(mapPropertySource);
			
		} catch (SQLException e) {
			logger.error("Error while loading application configuration from DB : ", e);
		}		
	}
}
