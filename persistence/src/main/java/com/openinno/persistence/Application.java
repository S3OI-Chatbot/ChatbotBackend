package com.openinno.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@EntityScan(basePackages = {"com.openinno"})
@ComponentScan(basePackages = {"com.openinno"})
@EnableJpaRepositories(basePackages = {"com.openinno"})
@ServletComponentScan
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class);
    }
}
