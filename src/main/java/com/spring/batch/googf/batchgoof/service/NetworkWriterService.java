package com.spring.batch.googf.batchgoof.service;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.spring.batch.googf.batchgoof.model.swc.Network;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetworkWriterService {

	public ItemWriter<Network> networkWriter(){
	
			
			return new ItemWriter<Network>() {
				
				@Override
				public void write(List<? extends Network> items) throws Exception {
					log.info(".. At NetworkWriterService, write netwok items: {}", items.get(0).getUuid());
					
				}
			};
		
	}
}
