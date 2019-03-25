package com.javanobrain.springbatch.demospringbatchcsv2db.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet result, int rowNum) throws SQLException {
		
		User user = new User();
		user.setId(result.getInt("id"));
		user.setFirstName(result.getString("first_name"));
		user.setLastName(result.getString("last_name"));
		user.setBirthdate(result.getDate("birthdate"));
		user.setGender(result.getString("gender"));
		user.setPhoneNumber(result.getString("phone_number"));
		user.setEmail(result.getString("email"));
		user.setStreetName(result.getString("street_name"));
		user.setCity(result.getString("city"));
		user.setState(result.getString("state_abbr"));
		user.setZipCode(result.getString("zip_code"));
		user.setDept(result.getString("dept"));

		return user;
	}
	
	

}
