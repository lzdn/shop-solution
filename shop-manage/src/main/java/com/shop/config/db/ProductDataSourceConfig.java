package com.shop.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = ProductDataSourceConfig.PRODUCT_PACKAGE, sqlSessionFactoryRef = "productSqlSessionFactory")
public class ProductDataSourceConfig {

	private Logger logger = LoggerFactory.getLogger(ProductDataSourceConfig.class);

	static final String PRODUCT_PACKAGE = "com.shop.dao.product";
	private static final String PRODUCT_MAPPER_LOCAL = "classpath:mapper/product/*.xml";

	/**
	 * 配置一个从库
	 * 
	 * @return DruidDataSource
	 */
	@Bean(name = "productDataSource")
	@ConfigurationProperties(prefix = "product.datasource")
	public DruidDataSource productDruidDataSource() {
		return new DruidDataSource();
	}

	@Bean(name = "productSqlSessionFactory")
	public SqlSessionFactory productSqlSessionFactory() {
		final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(productDruidDataSource());

		try {
			sessionFactoryBean
					.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(PRODUCT_MAPPER_LOCAL));
			return sessionFactoryBean.getObject();
		} catch (Exception e) {
			logger.error("配置从库的SqlSessionFactory失败，error:{}", e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

	@Bean(name = "productTransactionManager")
	public DataSourceTransactionManager productTransactionManager() {
		return new DataSourceTransactionManager(productDruidDataSource());
	}

}
