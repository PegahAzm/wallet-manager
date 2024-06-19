package com.wallet.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages = "com.wallet.manager")
@EntityScan(basePackages = "com.wallet.manager")
@EnableJpaRepositories(basePackages = "com.wallet.manager")
@ConfigurationPropertiesScan(basePackages = "com.wallet.manager")
@EnableScheduling
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationRunner.class);
        ConfigurableApplicationContext ctx = application.run(args);
        ctx.registerShutdownHook();
    }
}
