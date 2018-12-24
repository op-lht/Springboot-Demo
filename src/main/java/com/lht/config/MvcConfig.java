package com.lht.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lht.interceptor.LoginInterceptor;

//注册我们自定义的拦截器
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/**
	 * 通过@Bean注解，将我们定义的拦截器注册到spring容器中
	 * 
	 * @return
	 */
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

	/**
	 * 重写接口中的addInterceptors方法，添加自定义拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.loginInterceptor()).addPathPatterns("/**");
	}

}
