package com.mark_1.Mark_1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Mark1Application {

	@Value("${openai_key}")
	private String openAiKey;

	public static void main(String[] args) {
		SpringApplication.run(Mark1Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(((request, body, execution) -> {
			request.getHeaders().add("Authorization",
					"Bearer "+openAiKey);
			return execution.execute(request,body);
		}));
		return restTemplate;
	}

}
