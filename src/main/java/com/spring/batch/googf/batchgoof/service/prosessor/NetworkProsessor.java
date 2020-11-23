package com.spring.batch.googf.batchgoof.service.prosessor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;

import com.spring.batch.googf.batchgoof.model.NetworkDto;
import com.spring.batch.googf.batchgoof.model.swc.Network;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetworkProsessor {

	@Bean
	public ItemProcessor<NetworkDto,Network> networkItemProsesor() {
		
		log.info(".. At itemprosessor Network dto: " );
		return networkDto -> new Network(networkDto.getUuid(),networkDto.getName(),networkDto.getDescription());
		
		
	}
}
