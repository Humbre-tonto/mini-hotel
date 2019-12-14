package com.informatique.gov.helpdesk.config;

import java.util.Optional;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.service.InternalSecurityService;


@Configuration
@EnableJpaRepositories(basePackages = { "com.informatique.gov.helpdesk.persistence.repository" })
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "securityAuditor")
public class PersistenceContextConfigurer {
	
	private static final String[] ENTITY_PACKAGES = { "com.informatique.gov.helpdesk.domain" };
	
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment environment) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);
		

		Properties jpaProperties = new Properties();

		jpaProperties.put("hibernate.dialect", environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		jpaProperties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.show-sql"));
		jpaProperties.put("hibernate.jdbc.batch_size", environment.getRequiredProperty("spring.jpa.properties.hibernate.jdbc.batch-size"));		
		jpaProperties.put("hibernate.transaction.coordinator_class", environment.getRequiredProperty("spring.jpa.properties.hibernate.transaction.coordinator-class"));
		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactory);
      return transactionManager;
	}
	
	
	@Bean
	public AuditorAware<String> securityAuditor(InternalSecurityService securityService){
		return () -> {
			try {
				return Optional.ofNullable(securityService.getPrincipal());
			} catch (ShowDogException e) {
				return Optional.empty();
			}
		};
	}
}
