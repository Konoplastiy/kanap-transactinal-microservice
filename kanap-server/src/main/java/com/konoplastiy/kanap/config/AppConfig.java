package com.konoplastiy.kanap.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    MeterBinder meterBinder() {
        return meterRegistry -> {
            Counter.builder("request_counter")
                    .description("Amount of requests")
                    .register(meterRegistry);
        };
    }
}
