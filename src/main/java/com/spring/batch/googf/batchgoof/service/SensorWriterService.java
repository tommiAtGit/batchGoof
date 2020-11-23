package com.spring.batch.googf.batchgoof.service;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.spring.batch.googf.batchgoof.model.swc.Sensor;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class SensorWriterService {

	public ItemWriter<Sensor>sensorWriter(){
	
			
			return new ItemWriter<Sensor>() {
				
				@Override
				public void write(List<? extends Sensor> items) throws Exception {
					log.info(".. At SensorWriterService write Sensor items: {}", items.get(0).getUuid());
					
				}
			};
		
	}

}
