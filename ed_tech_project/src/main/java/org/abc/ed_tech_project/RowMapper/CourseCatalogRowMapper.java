package org.abc.ed_tech_project.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.abc.ed_tech_project.Entity.CourseCatalog;
import org.abc.ed_tech_project.Entity.Courses;
import org.springframework.jdbc.core.RowMapper;

public class CourseCatalogRowMapper implements RowMapper<CourseCatalog>{

	@Override
	public CourseCatalog mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseCatalog coursecatalog = new CourseCatalog();
		coursecatalog.setCourse_id(rs.getString("course_id"));
		coursecatalog.setCustomer_username(rs.getString("customer_username"));
		return coursecatalog;
	}

}
