
package com.spring.batch.googf.batchgoof.service.prosessor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;

import com.spring.batch.googf.batchgoof.model.SensorDto;
import com.spring.batch.googf.batchgoof.model.swc.Sensor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SensorProsessor {

	@Bean
	public ItemProcessor<SensorDto,Sensor> sensorItemProsesor() {
		
		log.info(".. At itemprosessor sensordto: " );
		return sensorDto -> new Sensor(sensorDto.getUuid(),sensorDto.getName(),sensorDto.getDesccription());
		
		
	}
}
