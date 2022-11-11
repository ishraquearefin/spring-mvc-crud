package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	
   /**
    * Dependency Injection of SessionFactory
    * */
	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		/**
		 * Generate a session from SessionFactory
		 * */
	       Session session = sessionFactory.getCurrentSession();
	       
	      /**
	       * Creating query
	       * */
	       
	       Query<Customer> theQuery = session.createQuery("from Customer  order by firstName",Customer.class);
	       
	       List<Customer> customers = theQuery.getResultList();
	       
	       return customers;
	       
	
		
	}
	@Override
	public void saveCustomer(Customer customer) {
		  Session session = sessionFactory.getCurrentSession();
		  session.saveOrUpdate(customer);
		
	}
	@Override
	public Customer getCustomer(int id) {
		  Session session = sessionFactory.getCurrentSession();
		  Customer customer=session.get(Customer.class,id);
		  return customer;
	}
	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		Query theQuery=session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId",id);
		theQuery.executeUpdate();
		
	}

}
