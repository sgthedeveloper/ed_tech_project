package org.abc.ed_tech_project.Entity;

import java.math.BigInteger;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Customer {
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message="Username shouldn't be empty")
	private String customer_username;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",message="Password Format Is Incorrect")
	@NotEmpty(message="Password shouldn't be empty")
	private String customer_password;
	
	@NotEmpty(message="Name shouldn't be empty")
	private String customer_name;
	
	@NotEmpty(message="Address shouldn't be empty")
	private String customer_address;
	
	@Pattern(regexp = "[0-9]*",message="Phone Number Should Be In Number")
	@Size(min=10, max=10)
	@NotEmpty(message="Phone Number shouldn't be empty")
	private String customer_pho;
	
	
	public String getCustomer_username() {
		return customer_username;
	}
	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_pho() {
		return customer_pho;
	}
	public void setCustomer_pho(String customer_pho) {
		this.customer_pho = customer_pho;
	}
	@Override
	public String toString() {
		return "Customer [customer_username=" + customer_username + ", customer_password=" + customer_password +", customer_name="+ customer_name
				+", customer_address="+ customer_address+", customer_pho=" +customer_pho+"]";
	}
}
