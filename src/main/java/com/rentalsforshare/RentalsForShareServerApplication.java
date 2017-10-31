package com.rentalsforshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.rentalsforshare.config.sercurity.JwtFilter;

@SpringBootApplication
public class RentalsForShareServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalsForShareServerApplication.class, args);
	}

	/**
	 * Jwt filter.
	 *
	 * @return the filter registration bean
	 */
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
}
