package com.spring.batch.googf.batchgoof.service;

import java.io.FileNotFoundException;

import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import com.spring.batch.googf.batchgoof.model.NetworkDto;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class NetworkReaderService {

	@Autowired
	Environment env;
	
	@Value("${swc.network.path}")
	private String fileName;
	
	@Bean
    public JsonItemReader<NetworkDto> networkJsonReader() throws FileNotFoundException {
       
		log.info("..At file reader. Reading file: " +  fileName);
		ResourceLoader resourceLoader = new DefaultResourceLoader();
			
		
		return new JsonItemReaderBuilder<NetworkDto>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(NetworkDto.class))
                .resource(resourceLoader.getResource("file:" + fileName))
                .name("movieJsonItemReader")
                .build();
    }
	
}
