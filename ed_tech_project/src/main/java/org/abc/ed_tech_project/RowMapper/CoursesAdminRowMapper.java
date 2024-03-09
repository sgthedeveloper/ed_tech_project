package org.abc.ed_tech_project.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.abc.ed_tech_project.Entity.Courses;
import org.springframework.jdbc.core.RowMapper;

public class CoursesAdminRowMapper implements RowMapper<Courses> {

	@Override
	public Courses mapRow(ResultSet rs, int rowNum) throws SQLException {
		Courses courses = new Courses();
		courses.setCourse_id(rs.getString("course_id"));
		courses.setCourse_name(rs.getString("course_name"));
		courses.setCourse_detail(rs.getString("course_detail"));
		courses.setCourse_instructor(rs.getString("course_instructor"));
		courses.setCourse_skill(rs.getString("course_skill"));
		courses.setOriginal_course_price(rs.getFloat("original_course_price"));
		courses.setDiscount(rs.getInt("discount"));
		courses.setCourse_after_discount(rs.getFloat("course_after_discount"));
		courses.setCourse_quantity(rs.getInt("course_quantity"));
		courses.setCourse_rating(rs.getInt("course_rating"));
		courses.setCourse_popularity(rs.getString("course_popularity"));
		return courses;
	}

}
