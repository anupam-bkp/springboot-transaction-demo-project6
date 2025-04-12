package com.learner.transaction.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please Bootstrap some Data....");
    }
}
