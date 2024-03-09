package org.abc.ed_tech_project.Entity;

public class CourseCatalog {
	private String course_id=null;
	private String customer_username;
	
	
	public String getCourse_id() {
		return course_id;
	}


	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}


	public String getCustomer_username() {
		return customer_username;
	}


	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}


	@Override
	public String toString() {
		return "CourseCatalog [course_id=" + course_id + ", customer_username=" + customer_username+"]";
	}
}
