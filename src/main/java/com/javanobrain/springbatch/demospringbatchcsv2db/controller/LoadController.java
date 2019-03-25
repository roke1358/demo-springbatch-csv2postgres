package com.javanobrain.springbatch.demospringbatchcsv2db.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javanobrain.springbatch.demospringbatchcsv2db.domain.User;
import com.javanobrain.springbatch.demospringbatchcsv2db.domain.UserRepository;

@RestController
@RequestMapping("/")
public class LoadController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/load-all")
	public BatchStatus load() throws JobExecutionAlreadyRunningException, 
		JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, parameters);

		while (jobExecution.isRunning()) {
			System.out.println("batch in progress...");
		}
		
		System.out.println("JobExecution: " + jobExecution.getStatus());
		System.out.println("[DONE] " );
		
		return jobExecution.getStatus();
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findOne(@PathVariable("id") int id) {
		User user = userRepository.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/users/all")
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userRepository.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
