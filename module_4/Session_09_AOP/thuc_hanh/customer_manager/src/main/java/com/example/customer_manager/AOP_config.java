package com.example.customer_manager;

import com.example.customer_manager.concern.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOP_config {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
