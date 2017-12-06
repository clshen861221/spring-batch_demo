package org.clshen.batch.batch_demo.schedule;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class ScheduledTask {

	@Bean
	public TaskScheduler poolScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("poolScheduler");
		scheduler.setPoolSize(10);
		return scheduler;
	}

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job importJob;

	public JobParameters jobParameters;

	@Scheduled(initialDelay = 3000, fixedRate = 30000)
	public void execute() throws Exception {
		jobParameters = new JobParametersBuilder().addLong("time",
				System.currentTimeMillis()).toJobParameters();
		jobLauncher.run(importJob, jobParameters);
	}
}