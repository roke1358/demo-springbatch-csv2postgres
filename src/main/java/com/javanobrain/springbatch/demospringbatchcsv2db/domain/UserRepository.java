package com.javanobrain.springbatch.demospringbatchcsv2db.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public User save(User user) {
		
		final String sql = "insert into public.user(id,first_name,last_name,gender,birthdate,street_name,city,state_abbr,zip_code,phone_number,email,dept) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, user.getId());
				ps.setString(2, user.getFirstName());
				ps.setString(3, user.getLastName());
				ps.setString(4, user.getGender());
				ps.setDate(5,  new java.sql.Date(user.getBirthdate().getTime()));
				ps.setString(6, user.getStreetName());
				ps.setString(7, user.getCity());
				ps.setString(8, user.getState());
				ps.setString(9, user.getZipCode());
				ps.setString(10, user.getPhoneNumber());
				ps.setString(11, user.getEmail());
				ps.setString(12, user.getDept());
				
				return ps;
			}
		});
		return user;
	
		/*	//this code also worked!!
		jdbcTemplate.update(sql,
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getGender(),
				new java.sql.Date(user.getBirthdate().getTime()),
				user.getStreetName(),
				user.getCity(),
				user.getState(),
				user.getZipCode(),
				user.getPhoneNumber(),
				user.getEmail(),
				user.getDept());
		
		return user; */
	}

	public User getUserById(int id) {
		String sql = "Select * from public.user where id=?";
		User result = jdbcTemplate.queryForObject(sql, new UserRowMapper(), new Object[] {id});
		return result;
	}
	
	public List<User> findAll() {
		String sql = "Select * from public.user";
		List<User> result = jdbcTemplate.query(sql, new UserRowMapper());
		return result;
	}
	
	public void updateUser(User user) {
		String sql = "Update user set ";
		
	}
}
