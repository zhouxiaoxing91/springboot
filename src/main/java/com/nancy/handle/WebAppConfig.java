package com.nancy.handle;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

	/**
	 * 配置拦截器
	 * 
	 * @author lance
	 * @param registry
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		UserSecurityInterceptor userSecurity = new UserSecurityInterceptor();
		registry.addInterceptor(userSecurity);
		super.addInterceptors(registry);
	}

//	@Bean
	//	public InternalResourceViewResolver internalResourceViewResolver () {
	//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	//		viewResolver.setPrefix("/WEB-INF/jsp/");
	//		viewResolver.setSuffix(".jsp");
	//		return viewResolver;
	//	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
