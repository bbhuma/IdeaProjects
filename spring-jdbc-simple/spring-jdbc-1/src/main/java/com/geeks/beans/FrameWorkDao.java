package com.geeks.beans; 

import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.List; 

import org.springframework.jdbc.core.JdbcTemplate; 
import org.springframework.jdbc.core.PreparedStatementSetter; 

public class FrameWorkDao{ 
	
	private JdbcTemplate jdbcTemp; 

	public JdbcTemplate getJdbcTemp() { 
		return jdbcTemp; 
	} 

	public void setJdbcTemp(JdbcTemplate jdbcTemp) { 
		this.jdbcTemp = jdbcTemp; 
	} 
	
	public FrameWork getDetail(final String name) { 
		final String SQL = "select * from usertasks.frameworks where name = ? "; 
		List <FrameWork> details = jdbcTemp.query( 
			SQL, new PreparedStatementSetter() { 
				
			public void setValues(PreparedStatement preparedStatement) throws SQLException { 
				preparedStatement.setString(1, name); 
			} 
		}, 
		new FrameWorkMapper()); 
		return details.get(0); 
	} 

} 
