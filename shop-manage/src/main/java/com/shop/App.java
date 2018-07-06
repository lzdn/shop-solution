package com.shop;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Configuration
@ServletComponentScan
@ComponentScan(basePackages = { "com.shop"})
@EnableAutoConfiguration
public class App extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

	// 增加此代码是因为 LogAspect 会用到RequestContextHolder，不然会报空指针。springMVC则是通过配置文件配置
	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(1024L * 512);
		factory.setFileSizeThreshold(0);
		return factory.createMultipartConfig();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

}
