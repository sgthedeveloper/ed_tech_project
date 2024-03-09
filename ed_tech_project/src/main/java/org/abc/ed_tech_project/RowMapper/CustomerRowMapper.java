package org.abc.ed_tech_project.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.abc.ed_tech_project.Entity.Courses;
import org.abc.ed_tech_project.Entity.Customer;
import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		
		customer.setCustomer_username(rs.getString("customer_username"));
		customer.setCustomer_password(rs.getString("customer_password"));
		customer.setCustomer_name(rs.getString("customer_name"));
		customer.setCustomer_address(rs.getString("customer_address"));
		customer.setCustomer_pho(rs.getString("customer_pho"));
		return customer;
	}
}
