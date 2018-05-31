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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = ManageDataSourceConfig.MANAGE_PACKAGE, sqlSessionFactoryRef = "manageSqlSessionFactory")
public class ManageDataSourceConfig {

	private Logger logger = LoggerFactory.getLogger(ManageDataSourceConfig.class);

	static final String MANAGE_PACKAGE = "com.shop.dao.manage";
	private static final String MANAGE_MAPPER_LOCAL = "classpath:mapper/manage/*.xml";

	/**
	 * 配置一个主库
	 * 
	 * @return DruidDataSource
	 */
	@Bean(name = "manageDataSource")
	@Primary
	@ConfigurationProperties(prefix = "manage.datasource")
	public DruidDataSource manageDruidDataSource() {
		return new DruidDataSource();
	}

	@Bean(name = "manageSqlSessionFactory")
	@Primary
	public SqlSessionFactory manageSqlSessionFactory() {
		final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(manageDruidDataSource());

		try {
			sessionFactoryBean
					.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MANAGE_MAPPER_LOCAL));
			return sessionFactoryBean.getObject();
		} catch (Exception e) {
			logger.error("配置主库的SqlSessionFactory失败，error:{}", e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

	@Bean(name = "manageTransactionManager")
	@Primary
	public DataSourceTransactionManager manageTransactionManager() {
		return new DataSourceTransactionManager(manageDruidDataSource());
	}

}
