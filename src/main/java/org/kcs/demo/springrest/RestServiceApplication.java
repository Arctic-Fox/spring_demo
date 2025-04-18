package org.kcs.demo.springrest;

import org.kcs.gaming.dnd.fifth.rest.query.DndRestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
		//SpringApplication.run(DndRestClient.class, args);
	}

}