package com.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.model.Client;

@EnableWebMvc
@ComponentScan(basePackages="com")
@Configuration
public class AppConfig 
{
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver irc=new InternalResourceViewResolver();
		irc.setSuffix(".jsp");
		return irc;
	}
	
	@Bean
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb_javabased");
		ds.setUsername("root");
		ds.setPassword("p@ssw0rd");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(dataSource());
		Properties ps=new Properties();
		ps.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		ps.setProperty("hibernate.hbm2ddl.auto", "update");
		ps.setProperty("hibernate.show_sql", "true");
		
		sf.setHibernateProperties(ps);
		sf.setAnnotatedClasses(Client.class);
		return sf;
	}

}
