package com.spring.batch.googf.batchgoof.service;

import java.io.FileNotFoundException;

import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import com.spring.batch.googf.batchgoof.model.SensorDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SensorReadService {

	
	@Value("${swc.sensor.path}")
	private String fileName;
	
	@Bean
    public JsonItemReader<SensorDto> sensorJsonReader() throws FileNotFoundException {
       
		log.info("..At file reader. Reading file: " +  fileName);
		ResourceLoader resourceLoader = new DefaultResourceLoader();
			
		
		return new JsonItemReaderBuilder<SensorDto>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(SensorDto.class))
                .resource(resourceLoader.getResource("file:" + fileName))
                .name("movieJsonItemReader")
                .build();
    }
}
