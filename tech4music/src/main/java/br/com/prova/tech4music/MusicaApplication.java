package br.com.prova.tech4music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MusicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicaApplication.class, args);
	}

}
