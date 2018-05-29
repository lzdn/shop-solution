package com.shop.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = ManageDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "manageSqlSessionFactory")
public class ManageDataSourceConfig {

	// 精确到 manage 目录，以便跟其他数据源隔离
	static final String PACKAGE = "com.shop.dao.manage";
	static final String MAPPER_LOCATION = "classpath:mapper/manage/*.xml";

	@Value("${manage.datasource.url}")
	private String url;

	@Value("${manage.datasource.username}")
	private String user;

	@Value("${manage.datasource.password}")
	private String password;

	@Value("${manage.datasource.driverClassName}")
	private String driverClass;

	@Value("${manage.datasource.type}")
	private String type;
	
	@Bean(name = "manageDataSource")
	@Primary
	public DataSource manageDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setDbType(type);
		return dataSource;
	}

	@Bean(name = "manageTransactionManager")
	@Primary
	public DataSourceTransactionManager manageTransactionManager() {
		return new DataSourceTransactionManager(manageDataSource());
	}

	@Bean(name = "manageSqlSessionFactory")
	@Primary
	public SqlSessionFactory manageSqlSessionFactory(@Qualifier("manageDataSource") DataSource manageDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(manageDataSource);
		sessionFactory.setTypeAliasesPackage("com.shop.domain.manage");
		//sessionFactory.setConfigLocation(configLocation);
		  //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);

        //添加插件
       // bean.setPlugins(new Interceptor[]{pageHelper});

		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(ManageDataSourceConfig.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}
}
