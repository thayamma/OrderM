package com.infosys.project2.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.project2.order.entity.ProductsOrdered;

public interface ProductsOrderedRepository  extends JpaRepository<ProductsOrdered, Integer>{

//	Optional<ProductsOrdered> findAllById(Integer orderid);
	ProductsOrdered getOne(Integer orderId);

	ProductsOrdered findByOrderId(Integer orderid);

}