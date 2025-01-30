package com.strateknia.evaluation.server.configuration;

import com.strateknia.evaluation.rules.DroolsEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RulesConfiguration {

    @Bean(initMethod = "init")
    public DroolsEngine droolsEngine() {
        return new DroolsEngine();
    }

}
