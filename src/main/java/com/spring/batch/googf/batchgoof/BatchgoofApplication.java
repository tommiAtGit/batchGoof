package com.spring.batch.googf.batchgoof;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.spring.batch.googf.batchgoof.application.NetworkJobConfig;
import com.spring.batch.googf.batchgoof.application.SensorJobConfig;

@EnableBatchProcessing
@SpringBootApplication
@EnableScheduling
public class BatchgoofApplication {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	NetworkJobConfig networkJob;
	
	@Autowired
	SensorJobConfig sensorJob;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BatchgoofApplication.class, args);
	}

	@Scheduled(cron = "0 */1 * * * ?")
	public void launchNetworkJob() {
		JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        try {
			jobLauncher.run(networkJob.networkConfigJob(), params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Scheduled(cron = "0 */5 * * * ?")
	public void launchSernsorJob() {
		JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        try {
			jobLauncher.run(sensorJob.sensorConfigJob(), params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
