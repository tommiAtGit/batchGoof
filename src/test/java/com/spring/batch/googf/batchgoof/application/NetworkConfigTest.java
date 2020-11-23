package com.spring.batch.googf.batchgoof.application;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import com.spring.batch.googf.batchgoof.BatchTestConfiguration;
import com.spring.batch.googf.batchgoof.BatchgoofApplication;


@SpringBootTest(classes = {BatchgoofApplication.class, BatchTestConfiguration.class})
class NetworkConfigTest {

	  @Autowired
	    private JobLauncherTestUtils testUtils;

	    @Autowired
	    private NetworkJobConfig config;
	    
	@Test
	
	void testNetworkConfigJob() {
		JobExecution result = null;
		try {
			result = testUtils.getJobLauncher()
							.run(config.networkConfigJob(),
							testUtils.getUniqueJobParameters());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			fail();
		}
		Assert.assertNotNull(result);
        Assert.assertEquals(BatchStatus.COMPLETED, result.getStatus());
	}

}
