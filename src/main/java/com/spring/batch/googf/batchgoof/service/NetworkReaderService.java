package com.spring.batch.googf.batchgoof.service;

import java.io.FileNotFoundException;

import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import com.spring.batch.googf.batchgoof.model.NetworkDto;

public class NetworkReaderService {

	
	@Value("${batchgoof.network.path}")
	private String fileName;
	
	@Bean
    public JsonItemReader<NetworkDto> networkJsonReader() throws FileNotFoundException {
       
		return new JsonItemReaderBuilder<NetworkDto>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(NetworkDto.class))
                .resource(new FileSystemResource("file:" +fileName))
                .name("movieJsonItemReader")
                .build();
    }
	
}
