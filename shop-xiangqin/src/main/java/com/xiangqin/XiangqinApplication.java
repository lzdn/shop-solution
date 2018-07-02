package com.xiangqin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.xiangqin.repository.base.BaseRepositoryFactoryBean;

@EnableJpaRepositories(basePackages = { "com.xiangqin.repository" }, 
	repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class// 指定自己的工厂类
)
@SpringBootApplication
public class XiangqinApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiangqinApplication.class, args);
	}
}
