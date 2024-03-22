package com.rpietraszewski.medicalclinicproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MedicalClinicProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalClinicProxyApplication.class, args);
	}

}
