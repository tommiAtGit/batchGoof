package com.spring.batch.googf.batchgoof.application;

import java.io.FileNotFoundException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.spring.batch.googf.batchgoof.model.NetworkDto;
import com.spring.batch.googf.batchgoof.model.swc.Network;
import com.spring.batch.googf.batchgoof.service.NetworkReaderService;
import com.spring.batch.googf.batchgoof.service.NetworkWriterService;
import com.spring.batch.googf.batchgoof.service.prosessor.NetworkProsessor;

@Configuration
public class NetworkJobConfig {
  
	@Autowired
    private JobBuilderFactory jobBuilders;

    @Autowired
    private StepBuilderFactory stepBuilders;
    
    @Autowired
    private NetworkReaderService networkReader;
    
    @Autowired
    private NetworkProsessor  networkProsessor;
    
    @Autowired
    private  NetworkWriterService networkWriter;
    
    
    @Bean 
    NetworkReaderService networkReaderService(){
    	return new NetworkReaderService();
    }
    
    @Bean
    NetworkProsessor networkProseccor() {
    	return new NetworkProsessor();
    }
    
    @Bean 
    NetworkWriterService networkWriterService() {
    	return new NetworkWriterService();
    }
    
    @Bean
    @Primary
    public Job networkConfigJob() {
    	 return jobBuilders.get("networkConfigJob")
    		        .start(networkConfigStep())
    		        .build();
    }
	    
	@Bean
	public Step networkConfigStep(){
		 try {
			return stepBuilders.get("networkConfigStep")
				        .<NetworkDto, Network>chunk(20)
				        .reader(networkReader.networkJsonReader())
				        .processor(networkProsessor.networkItemProsesor())
				        .writer(networkWriter.networkWriter())
				        .build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 return null;
	}

}
