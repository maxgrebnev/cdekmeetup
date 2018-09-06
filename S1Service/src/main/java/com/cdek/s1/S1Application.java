package com.cdek.s1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class S1Application {

	public static void main(String[] args) {
		SpringApplication.run(S1Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory fact = new SimpleClientHttpRequestFactory();
		fact.setReadTimeout(3000);
		return new RestTemplate(fact);
	}
}
