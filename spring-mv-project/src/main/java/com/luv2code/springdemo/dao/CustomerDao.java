package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(int id);
	void deleteCustomer(int id);

}
