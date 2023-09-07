package com.example.ToDoList.config;

import com.example.ToDoList.config.beans.DatabaseLoader;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public DatabaseLoader databaseLoader() {
        return new DatabaseLoader();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
