package com.wideshot.alimtalk.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@MapperScan(value = "com.wideshot.alimtalk.dao", sqlSessionFactoryRef = "service1SqlSessionFactory")
public class Service1DataSourceConfig {
	
	@Bean(name = "service1DataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSource service1DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "service1SqlSessionFactory")
	@Primary
	public SqlSessionFactory service1SqlSessionFactory(@Qualifier("service1DataSource")
			DataSource service1DataSource, ApplicationContext applicationContext) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(service1DataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/serviceDB1/*.xml"));
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		return sqlSessionFactoryBean.getObject(); 
	}
	
	@Bean(name = "service1SqlSessionTemplate")
	@Primary
	public SqlSessionTemplate service1SqlSessionTemplate(SqlSessionFactory service1SqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(service1SqlSessionFactory);
	}
}
