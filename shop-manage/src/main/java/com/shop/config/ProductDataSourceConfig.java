package com.shop.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
//副数据源
@Configuration
@MapperScan(basePackages = ProductDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "productSqlSessionFactory")
public class ProductDataSourceConfig {

	// 精确到 product 目录，以便跟其他数据源隔离
	static final String PACKAGE = "com.shop.dao.product";
	static final String MAPPER_LOCATION = "classpath:mapper/product/*.xml";

	@Value("${product.datasource.url}")
	private String url;

	@Value("${product.datasource.username}")
	private String user;

	@Value("${product.datasource.password}")
	private String password;

	@Value("${product.datasource.driverClassName}")
	private String driverClass;

	@Value("${product.datasource.type}")
	private String type;
	
	@Bean(name = "productDataSource")
	public DataSource productDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setDbType(type);
		return dataSource;
	}

	@Bean(name = "productTransactionManager")
	public DataSourceTransactionManager productTransactionManager() {
		return new DataSourceTransactionManager(productDataSource());
	}

	@Bean(name = "productSqlSessionFactory")
	public SqlSessionFactory productSqlSessionFactory(@Qualifier("productDataSource") DataSource productDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(productDataSource);
		sessionFactory.setTypeAliasesPackage("com.shop.domain.product");
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(ProductDataSourceConfig.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}
}
