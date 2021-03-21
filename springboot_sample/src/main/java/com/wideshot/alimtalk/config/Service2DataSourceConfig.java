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

@Configuration
@MapperScan(value = "com.wideshot.alimtalk.dao2", sqlSessionFactoryRef = "service2SqlSessionFactory")
public class Service2DataSourceConfig {
	
	@Bean(name = "service2DataSource")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource service2DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "service2SqlSessionFactory")
	public SqlSessionFactory service2SqlSessionFactory(@Qualifier("service2DataSource")
			DataSource service2DataSource, ApplicationContext applicationContext) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(service2DataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/serviceDB2/*.xml"));
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name = "service2SqlSessionTemplate")
	public SqlSessionTemplate service2SqlSessionTemplate(SqlSessionFactory service2SqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(service2SqlSessionFactory);
	}
}
