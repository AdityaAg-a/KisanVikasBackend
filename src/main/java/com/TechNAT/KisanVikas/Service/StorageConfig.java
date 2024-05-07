package com.TechNAT.KisanVikas.Service;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Bean
    public Storage storage() {
        // Create and return an instance of Storage using your preferred method of authentication
        return StorageOptions.getDefaultInstance().getService();
    }
}
