package org.abc.ed_tech_project.database;

import java.util.ArrayList;
import java.util.List;

import org.abc.ed_tech_project.Entity.CourseCatalog;
import org.abc.ed_tech_project.Entity.Courses;
import org.abc.ed_tech_project.Entity.Customer;
import org.abc.ed_tech_project.RowMapper.CourseCatalogRowMapper;
import org.abc.ed_tech_project.RowMapper.CoursesAdminRowMapper;
import org.abc.ed_tech_project.RowMapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AllDatabaseConnectionImpl implements AllDatabaseConnection{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void create_tablecourses() {
		// TODO Auto-generated method stub
		String create_table_courses = "create table if not exists courses(course_id varchar(10), course_name varchar(50), course_detail varchar(1000), course_instructor varchar(30), course_skill varchar(40), original_course_price float, discount int, course_after_discount float, course_quantity int, course_rating int, course_popularity varchar(60), PRIMARY KEY(course_id));";
		jdbcTemplate.execute(create_table_courses);
		System.out.println("Table inserted Successfully");
	}
	
	@Override
	public void create_coursecatalog() {
		// TODO Auto-generated method stub
		String create_table_coursecatalog = "create table if not exists coursecatalog(course_id varchar(10), customer_username varchar(80),PRIMARY KEY (course_id, customer_username));";
		jdbcTemplate.execute(create_table_coursecatalog);
		System.out.println("Table inserted Successfully");
	}

	@Override
	public int createRecordcourses(Courses courses) {
		// TODO Auto-generated method stub
		String query = "insert into courses values(?,?,?,?,?,?,?,?,?,?,?)";
		float ocs = courses.getOriginal_course_price();
		int d = courses.getDiscount();
		float cad;
		float discountedrate=ocs-(d*ocs/100);
		courses.setCourse_after_discount(discountedrate);
		int recordInserted = 0;
		if(!courses.getCourse_id().isEmpty()&&!courses.getCourse_name().isEmpty()) {
			Object records[] = { courses.getCourse_id(), courses.getCourse_name(), courses.getCourse_detail(),
					courses.getCourse_instructor(), courses.getCourse_skill(),courses.getOriginal_course_price(),courses.getDiscount(),
					courses.getCourse_after_discount(),courses.getCourse_quantity(),courses.getCourse_rating(),courses.getCourse_popularity()};
			try {
				recordInserted = jdbcTemplate.update(query, records);
				System.out.println("1"+recordInserted);
				return recordInserted;
			}catch(Exception e) {
				return recordInserted;
			}
			
		}
		else {
			return recordInserted;
		}
	}

	@Override
	public List<Courses> loadadminCourses() {
		List<Courses> coursesList = new ArrayList<>();
		String query = "select * from courses";
		coursesList = jdbcTemplate.query(query, new CoursesAdminRowMapper());
		return coursesList;
	}

	@Override
	public void deleteCourses(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from courses where course_id = ?";
		jdbcTemplate.update(sql, id);
		String sql1 = "delete from coursecatalog where course_id = ?";
		jdbcTemplate.update(sql1, id);
	}

	@Override
	public int updateRecord(Courses cou) {
		String sql = "update courses set course_name = ?, course_detail = ?, course_instructor = ?, course_skill = ?,"
				+ "original_course_price = ?, discount = ?, course_after_discount = ?, course_quantity = ? where course_id = ?";
		float ocs = cou.getOriginal_course_price();
		int d = cou.getDiscount();
		float cad;
		float discountedrate=ocs-(d*ocs/100);
		cou.setCourse_after_discount(discountedrate);
		Object[] args = {cou.getCourse_name(), cou.getCourse_detail(),cou.getCourse_instructor(), 
				cou.getCourse_skill(),cou.getOriginal_course_price(),cou.getDiscount(),cou.getCourse_after_discount(),
				cou.getCourse_quantity(),cou.getCourse_id()};
		int recordsUpdated = jdbcTemplate.update(sql, args);
		return recordsUpdated;
	}

	@Override
	public Courses getCourses(String course_id) {
		String sql = "select * from courses where course_id = ?";
		Courses courses = jdbcTemplate.queryForObject(sql, new CoursesAdminRowMapper(), course_id);
		return courses;
	}

	@Override
	public void create_tablecustomersregistration() {
		// TODO Auto-generated method stub
		String create_table_courses = "create table if not exists customers(customer_username varchar(80), customer_password varchar(50), customer_name varchar(20), customer_address varchar(200), customer_pho varchar(10), PRIMARY KEY(customer_username));";
		jdbcTemplate.execute(create_table_courses);
		System.out.println("Table inserted Successfully");
	}

	@Override
	public int createRecord(Customer customer) {
		String query = "insert into customers values(?,?,?,?,?)";
		int recordInserted = 0;
		Object records[] = {customer.getCustomer_username(),customer.getCustomer_password(),customer.getCustomer_name(),customer.getCustomer_address(),customer.getCustomer_pho()};
		try {
			recordInserted = jdbcTemplate.update(query, records);
			System.out.println("1"+recordInserted);
			return recordInserted;
		}catch(Exception e) {
			System.out.println(e);
			return recordInserted;
		}
	}
	
	@Override
	public Customer getCustomer(String customer_username) {
		String sql = "select * from customers where customer_username = ?";
		Customer customers = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), customer_username);
		return customers;
	}
	@Override
	public List<Courses> getSearchCourses(String search_courses) {
		List<Courses> coursesList = new ArrayList<>();
		String query = "SELECT * FROM courses WHERE course_skill LIKE '%"+search_courses+"%' OR course_name LIKE '%"+search_courses+"%' OR course_after_discount LIKE '%"+search_courses+"%'";
		coursesList = jdbcTemplate.query(query, new CoursesAdminRowMapper());
		return coursesList;
	}
	@Override
	public int buyCourse(String couId, String cusname) {
		String sql = "update courses set course_quantity = ? where course_id = ?";
		String sql1 = "select * from courses where course_id = ?";
		String sql2 = "insert into coursecatalog values(?,?)";
		Courses courses = jdbcTemplate.queryForObject(sql1, new CoursesAdminRowMapper(), couId);
		int recordsUpdated=0;
		int recordsInserted=0;
		System.out.println(courses.getCourse_quantity());
		if(courses.getCourse_quantity()>0) {
			Object records[] = {couId,cusname};
			try {
				recordsInserted = jdbcTemplate.update(sql2, records);
				if(recordsInserted==1) {
					int quantity = courses.getCourse_quantity()-1;
					courses.setCourse_quantity(quantity);
					Object[] args = {courses.getCourse_quantity(),courses.getCourse_id()};
					recordsUpdated = jdbcTemplate.update(sql, args);
					return recordsUpdated;
				}
				else {
					recordsUpdated = 2;
					return recordsUpdated;
				}
			}catch(Exception e) {
				System.out.println(e);
				recordsUpdated = 2;
				return recordsUpdated;
			}
		}
		else {
			return recordsUpdated;
		}
		
	}
	@Override
	public List<CourseCatalog> loadcoursecatalog(String cusname) {
		List<CourseCatalog> coursesList = new ArrayList<>();
		String query = "SELECT * FROM coursecatalog WHERE customer_username='"+cusname+"'";
		coursesList = jdbcTemplate.query(query, new CourseCatalogRowMapper());
		return coursesList;
	}
	
	@Override
	public List<Courses> loadcoursecatalog1(String cusname) {
		List<Courses> courses = new ArrayList<>();
		String sql = "select * from courses where course_id = '"+cusname+"'";
		courses = jdbcTemplate.query(sql, new CoursesAdminRowMapper());
		System.out.println("Hi1");
		return courses;
	}
}
