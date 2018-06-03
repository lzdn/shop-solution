package com.shop.config.db;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableTransactionManagement
@ConditionalOnBean({ ManageDataSourceConfig.class, ProductDataSourceConfig.class })
public class DataSourcesAutoConfiguration implements TransactionManagementConfigurer {

	@Resource
	private ManageDataSourceConfig manageDataSourceConfig;

	@Resource
	private ProductDataSourceConfig productDataSourceConfig;

	// 配置分布式事务管理
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {

		return new ChainedTransactionManager(manageDataSourceConfig.manageTransactionManager(),
				productDataSourceConfig.productTransactionManager());
	}

}
