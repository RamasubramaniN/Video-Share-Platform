package com.psg.ramasubramani.concepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rn5
 *
 */
@SpringBootApplication
public class MyApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
		System.out.println("Spring Boot Application Started...");
	}

}
