package com.spring.batch.googf.batchgoof.application;

import java.io.FileNotFoundException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.batch.googf.batchgoof.model.SensorDto;
import com.spring.batch.googf.batchgoof.model.swc.Sensor;
import com.spring.batch.googf.batchgoof.service.SensorReadService;
import com.spring.batch.googf.batchgoof.service.SensorWriterService;
import com.spring.batch.googf.batchgoof.service.prosessor.SensorProsessor;

@Configuration
public class SensorJobConfig {

	 @Autowired
	    private JobBuilderFactory jobBuilders;

	    @Autowired
	    private StepBuilderFactory stepBuilders;
	    
	    @Autowired
	    private SensorReadService sensorReader;
	    
	    @Autowired
	    private SensorProsessor  sensorProsessor;
	    
	    @Autowired
	    private  SensorWriterService sensorWriter;
	    
	    
	    @Bean 
	    SensorReadService sensorReaderService(){
	    	return new SensorReadService();
	    }
	    
	    @Bean
	    SensorProsessor sensorProseccor() {
	    	return new SensorProsessor();
	    }
	    
	    @Bean 
	    SensorWriterService sensorWriterService() {
	    	return new SensorWriterService();
	    }
	    @Bean
	    public Job sensorConfigJob() {
	    	 return jobBuilders.get("sensorConfigJob")
	    		        .start(sensorConfigStep())
	    		        .build();
	    }
		    
		@Bean
		public Step sensorConfigStep(){
			 try {
				return stepBuilders.get("SensorConfigStep")
					        .<SensorDto, Sensor>chunk(20)
					        .reader(sensorReader.sensorJsonReader())
					        .processor(sensorProsessor.sensorItemProsesor())
					        .writer(sensorWriter.sensorWriter())
					        .build();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			 return null;
		}
}
