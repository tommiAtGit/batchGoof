package com.spring.batch.googf.batchgoof.application;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import com.spring.batch.googf.batchgoof.BatchTestConfiguration;
import com.spring.batch.googf.batchgoof.BatchgoofApplication;


@SpringBootTest(classes = {BatchgoofApplication.class, BatchTestConfiguration.class})
class NetworkConfigTest {

	  	
	    private JobLauncherTestUtils testUtils;

	    @Autowired
	    private NetworkJobConfig config;
	   
	    @Autowired
		private JobLauncher jobLauncher;
		
		
	    @Autowired
	    private JobRepository jobRepository;

	  
	    
	    
	    private void initailizeJobLauncherTestUtils() {
	        this.testUtils = new JobLauncherTestUtils();
	        this.testUtils.setJobLauncher(jobLauncher);
	        this.testUtils.setJobRepository(jobRepository);
	        this.testUtils.setJob(config.networkConfigJob());
	    }
	    
	    @Before
	    public void setUp() throws Exception {
	        
	    	this.initailizeJobLauncherTestUtils();
	    }
	    
	    
	@Test
	void testNetworkConfigJob() {
		JobExecution result = null;
		try {
			
			
			//result = this.testUtils.launchJob();
			result = this.testUtils.getJobLauncher()
							.run(config.networkConfigJob(),
							testUtils.getUniqueJobParameters());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		Assert.assertNotNull(result);
        Assert.assertEquals(BatchStatus.COMPLETED, result.getStatus());
	}

}
