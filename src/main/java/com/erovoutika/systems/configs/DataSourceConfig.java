package com.erovoutika.systems.configs;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * DataSourceConfig
 */
@Configuration
// @EnableJpaRepositories(basePackages={"${spring.data.jpa.repository.packages}"})
public class DataSourceConfig {
    // @Primary
	// @Bean
	// @ConfigurationProperties(prefix="app.datasource")
	// public DataSource appDataSource() {
	// 	return DataSourceBuilder.create().build();
    // }
	// @Bean
	// @ConfigurationProperties(prefix="spring.data.jpa.entity")
	// public LocalContainerEntityManagerFactoryBean entit777hh                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   yManagerFactory(EntityManagerFactoryBuilder builder, DataSource appDataSource) {
	// 	return builder
	// 			.dataSource(appDataSource)
	// 			.build();
	// }
	@Bean
	@ConfigurationProperties(prefix="secured.datasource")
	public DataSource accountAuthorization() {
		return DataSourceBuilder.create().build();
	}
}