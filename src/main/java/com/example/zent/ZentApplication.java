package com.example.zent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ZentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZentApplication.class, args);
	}

}
