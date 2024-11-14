package com.example.tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackingApplication {

	public static void main(String[] args) {
		System.out.println("##TrackingApplication.main():start:");
		SpringApplication.run(TrackingApplication.class, args);
		System.out.println("##TrackingApplication.main():end:");
	}

}
