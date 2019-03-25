package com.javanobrain.springbatch.demospringbatchcsv2db.batch;

import org.springframework.batch.item.file.FlatFileItemReader;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

import com.javanobrain.springbatch.demospringbatchcsv2db.domain.User;

public class Reader {

	public static FlatFileItemReader<User> reader(String inputFile) {
		FlatFileItemReader<User> reader = new FlatFileItemReader<User>();

		reader.setResource(new ClassPathResource(inputFile));
		reader.setLinesToSkip(0);
		reader.setName("CSV-Reader");
		reader.setLineMapper(lineMapper());
		return reader;
	}

	private static LineMapper<User> lineMapper() {

		DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "id", "firstName", "lastName", "email", "dept", 
				"streetName", "city", "state", "zipCode", "phoneNumber", "gender", "birthDate" });

		BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<User>();
		fieldSetMapper.setTargetType(User.class);

		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);

		return defaultLineMapper;
	}

}
