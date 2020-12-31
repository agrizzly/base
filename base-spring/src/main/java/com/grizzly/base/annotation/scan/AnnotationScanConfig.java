package com.grizzly.base.annotation.scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationScanConfig {

    @Bean
    public CustomAnnotationScan customAnnotationScan(){
        return new CustomAnnotationScan();
    }
}
