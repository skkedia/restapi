package com.siddhant.kedia.master;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.siddhant.kedia.endpoints"})
public class RestApiApplication {
	
	static {
		System.out.println("rest app");
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		System.out.println(sf);
	}

}
