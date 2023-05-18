package com.dialogfinance.cashback;

import com.dialogfinance.cashback.configuration.SpringSecurityAuditorAware;
import com.dialogfinance.cashback.entity.Auditable;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.slf4j.Logger;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class Cashback {

//    private static final Logger Logger = LoggerFactory.getLogger(Cashback.class);
    @Bean
    public AuditorAware<String> auditorAware(){
        return new SpringSecurityAuditorAware();
    }
    public static void main(String[] args) {
        SpringApplication.run(Cashback.class, args);

//        Logger.debug("This is a debug message");
//        Logger.info("This is a info message");
//        Logger.warn("This is a warn message");
//        Logger.error("This is a error message");

    }


}
