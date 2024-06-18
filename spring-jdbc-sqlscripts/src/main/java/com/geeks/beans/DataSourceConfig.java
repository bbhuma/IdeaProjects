package com.geeks.beans; 

import org.springframework.boot.jdbc.DataSourceBuilder; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.core.io.ClassPathResource; 
import org.springframework.jdbc.datasource.init.DatabasePopulator; 
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils; 
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator; 

import javax.sql.DataSource; 

// annotated as configuration so application 
// knows to run it in the start 
@Configuration
public class DataSourceConfig { 
	@Bean(name = "dataSource") 
	public DataSource getDataSource(){ 
		DataSource dataSource = createDataSource(); 
		DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource); 
		return dataSource; 
	} 

	private DatabasePopulator createDatabasePopulator() { 
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(); 
		databasePopulator.setContinueOnError(true); 
		databasePopulator.addScript(new ClassPathResource("schema.sql")); 
		return databasePopulator; 
	} 

	private DataSource createDataSource() { 
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
		dataSourceBuilder.driverClassName("org.hsqldb.jdbc.JDBCDriver"); 
		dataSourceBuilder.url("jdbc:hsqldb:hsql://localhost/geeksforgeeks"); 
		dataSourceBuilder.username("root"); 
		dataSourceBuilder.password("pass"); 
		return dataSourceBuilder.build(); 
	} 
} 
