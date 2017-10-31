package com.rentalsforshare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.rentalsforshare.logger.MyLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class AssetConfig.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.rentalsforshare.logger" })
public class AssetConfig {

	/**
	 * My logger.
	 *
	 * @return the my logger
	 */
	@Bean
	public MyLogger myLogger() {
		return new MyLogger();
	}
}
