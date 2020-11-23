package com.spring.batch.googf.batchgoof.model.swc;

import java.util.List;
import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Sensor {

	private UUID uuid;
	
	private String name;
	
	private String description;
}
