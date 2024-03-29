package com.aswin.Write.Your.Thought;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WriteYourThoughtApplication {

	public static void main(String[] args) {
		SpringApplication.run(WriteYourThoughtApplication.class, args);
	}

}
