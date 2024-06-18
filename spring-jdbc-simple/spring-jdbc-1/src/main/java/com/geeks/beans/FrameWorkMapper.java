package com.geeks.beans; 

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper; 

public class FrameWorkMapper implements RowMapper<FrameWork>{ 

	@Override
	public FrameWork mapRow(ResultSet rs, int map) throws SQLException { 

		FrameWork framework = new FrameWork(); 
		framework.setId(rs.getInt("id")); 
		framework.setName(rs.getString("name")); 
		framework.setDescription(rs.getString("description")); 
		return framework; 
	} 

} 
