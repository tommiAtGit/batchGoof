package com.spring.batch.googf.batchgoof.model.swc;

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
public class Network {

	private String uuid;
	private String Name;
	private String Description;
}
