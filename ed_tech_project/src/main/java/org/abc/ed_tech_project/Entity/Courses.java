package org.abc.ed_tech_project.Entity;

public class Courses {
	private String course_id=null;
	private String course_name;
	private String course_detail;
	private String course_instructor;
	private String course_skill;
	private float original_course_price;
	private int discount;
	private float course_after_discount;
	private int course_quantity;
	private int course_rating;
	private String course_popularity;
	
	

	public String getCourse_id() {
		return course_id;
	}



	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}



	public String getCourse_name() {
		return course_name;
	}



	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}



	public String getCourse_detail() {
		return course_detail;
	}



	public void setCourse_detail(String course_detail) {
		this.course_detail = course_detail;
	}



	public String getCourse_instructor() {
		return course_instructor;
	}



	public void setCourse_instructor(String course_instructor) {
		this.course_instructor = course_instructor;
	}



	public String getCourse_skill() {
		return course_skill;
	}



	public void setCourse_skill(String course_skill) {
		this.course_skill = course_skill;
	}



	public float getOriginal_course_price() {
		return original_course_price;
	}



	public void setOriginal_course_price(float original_course_price) {
		this.original_course_price = original_course_price;
	}



	public int getDiscount() {
		return discount;
	}



	public void setDiscount(int discount) {
		this.discount = discount;
	}



	public float getCourse_after_discount() {
		return course_after_discount;
	}



	public void setCourse_after_discount(float course_after_discount) {
		this.course_after_discount = course_after_discount;
	}



	public int getCourse_quantity() {
		return course_quantity;
	}



	public void setCourse_quantity(int course_quantity) {
		this.course_quantity = course_quantity;
	}



	public int getCourse_rating() {
		return course_rating;
	}



	public void setCourse_rating(int course_rating) {
		this.course_rating = course_rating;
	}



	public String getCourse_popularity() {
		return course_popularity;
	}



	public void setCourse_popularity(String course_popularity) {
		this.course_popularity = course_popularity;
	}



	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name +", course_detail="+ course_detail
				+", course_instructor="+ course_instructor+", course_skill=" +course_skill+", original_course_price="+original_course_price+""
						+ ", discount="+discount+", course_after_discount="+course_after_discount+", course_quantity="+
				course_quantity+", course_rating="+course_rating+", course_popularity="+course_popularity+"]";
	}
}
