package com.strateknia.evaluation.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="com.strateknia.evaluation.common.entity")
@Slf4j
public class EvaluationServer {

    public static void main(String[] args) {
        SpringApplication.run(EvaluationServer.class, args);
    }

}