package com.example.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.example.demo")
@EnableTransactionManagement
public class ApplicationContextConfig {

	public ApplicationContextConfig() {}
		
		
	
		@Bean 
	    public  DataSource getDataSource()
	    {
	        BasicDataSource dataSource = new BasicDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/hr");
			dataSource.setUsername("root");
			dataSource.setPassword("8266@!Dev");
			
	        return dataSource;
	    }

		
		 private  Properties getHProperties()
		    {
		        Properties properties = new Properties();
		        properties.put( "hibernate.show_sql", "true" );
		        properties.put( "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect" );
		        properties.put( "hibernate.hbm2ddl.auto", "update" );
		        return properties;
		    }
	
		 	@Bean
		 	@Autowired
		    public LocalSessionFactoryBean getSessionFactory() {
			 LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		        sessionFactory.setDataSource(getDataSource());
		        sessionFactory.setPackagesToScan("com.example.demo.model");
		        sessionFactory.setHibernateProperties(getHProperties());
		 
		        return sessionFactory;
		    }

	
		 	@Bean
		 	@Autowired
			public HibernateTransactionManager getTransactionManager() {
		        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		        transactionManager.setSessionFactory(getSessionFactory().getObject());

		        return transactionManager;
		    }

	

}
