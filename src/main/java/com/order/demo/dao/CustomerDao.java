package com.order.demo.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.order.demo.entities.Customer;


@Repository
public interface CustomerDao extends MongoRepository<Customer,String>{	
	
	@Query("select customerDetail from Customer customerDetail where customerDetail.id=:userId")
	public Customer getCustomerDetail(@Param("userId") String userId);
	
	
}