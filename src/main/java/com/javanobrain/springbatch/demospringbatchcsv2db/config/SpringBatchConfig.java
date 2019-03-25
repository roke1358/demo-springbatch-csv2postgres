package com.javanobrain.springbatch.demospringbatchcsv2db.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javanobrain.springbatch.demospringbatchcsv2db.batch.DBWriter;
import com.javanobrain.springbatch.demospringbatchcsv2db.batch.Processor;
import com.javanobrain.springbatch.demospringbatchcsv2db.batch.Reader;
import com.javanobrain.springbatch.demospringbatchcsv2db.domain.User;
import com.javanobrain.springbatch.demospringbatchcsv2db.domain.UserRepository;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	UserRepository userRepository;
	
	@Value("${input}")
	private String inputFile;
	

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).flow(step()).end().build();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get("step").<User, User>chunk(100).reader(Reader.reader(inputFile))
				.processor(new Processor()).writer(new DBWriter(userRepository)).build();
	}
}
