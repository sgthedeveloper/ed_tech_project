package org.abc.ed_tech_project.database;

import java.util.List;

import org.abc.ed_tech_project.Entity.CourseCatalog;
import org.abc.ed_tech_project.Entity.Courses;
import org.abc.ed_tech_project.Entity.Customer;

public interface AllDatabaseConnection {
	
	public void create_tablecourses();

	public int createRecordcourses(Courses courses);
	
	public List<Courses> loadadminCourses();

	public void deleteCourses(String id);
	
	public int updateRecord(Courses cou);
	
	public Courses getCourses(String course_id);
	
	public void create_tablecustomersregistration();

	public int createRecord(Customer customer);

	Customer getCustomer(String customer_username);

	List<Courses> getSearchCourses(String search_courses);

	void create_coursecatalog();

	int buyCourse(String couId, String cusname);

	List<CourseCatalog> loadcoursecatalog(String cusname);

	List<Courses> loadcoursecatalog1(String cusname);

}
