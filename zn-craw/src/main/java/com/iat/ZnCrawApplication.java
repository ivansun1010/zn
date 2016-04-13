package com.iat;

import com.iat.zn.craw.util.SpringApplicationContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZnCrawApplication {

	public static void main(String[] args) {
		SpringApplicationContextHolder.setContext(SpringApplication.run(ZnCrawApplication.class, args));
	}
}
