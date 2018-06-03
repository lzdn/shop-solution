package com.shop.conf;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class FastJsonConfiger extends WebMvcConfigurationSupport {

	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter fastConventer = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConventer.setFastJsonConfig(fastJsonConfig);
		converters.add(fastConventer);
	}

}
