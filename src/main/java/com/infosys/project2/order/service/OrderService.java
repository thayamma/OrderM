package com.infosys.project2.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project2.order.dto.OrderDTO;
import com.infosys.project2.order.dto.ProductDTO;
import com.infosys.project2.order.dto.ProductsOrderedDTO;
import com.infosys.project2.order.entity.Order;
import com.infosys.project2.order.entity.ProductsOrdered;
import com.infosys.project2.order.repository.OrderRepository;
import com.infosys.project2.order.repository.ProductsOrderedRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository order;

	@Autowired
	ProductsOrderedRepository orders;
	

	public List<OrderDTO> getorders() {
		List<OrderDTO> l=new ArrayList<OrderDTO>();
		List<Order> oe=order.findAll();
		for(Order o: oe) {
		OrderDTO O=OrderDTO.valueof(o);
		l.add(O);
		}
		return l;
	}


	public OrderDTO getordersbyid(Integer id) {
		Order oe=order.getOne(id);
		OrderDTO O=OrderDTO.valueof(oe);
		return O;
	}


	public List<ProductsOrderedDTO> getproductorders() {
		List<ProductsOrderedDTO> l=new ArrayList<ProductsOrderedDTO>();
		List<ProductsOrdered> oe=orders.findAll();
		for(ProductsOrdered o: oe) {
		ProductsOrderedDTO O=ProductsOrderedDTO.valueof(o);
		l.add(O);
		}
		return l;
	}


	public ProductsOrderedDTO getprodordersbyid(Integer orderid) {
		ProductsOrdered oe=orders.getOne(orderid);
		ProductsOrderedDTO O=ProductsOrderedDTO.valueof(oe);
		return O;
	}

	public void removeorder(Integer orderid) {
		Order oe=order.findByOrderId(orderid);
		order.delete(oe);
		
	}
	public void removeorders(Integer orderid) {
		ProductsOrdered oe=orders.findByOrderId(orderid);
		orders.delete(oe);
		
	}
	
	public void addToOrder(ProductDTO prodDTO,Integer quantity) {
		System.out.println("in service");
		ProductsOrderedDTO productOrderDTO= new ProductsOrderedDTO();
		productOrderDTO.setOrderId(productOrderDTO.getOrderId());
		productOrderDTO.setPrice(prodDTO.getPrice());
		productOrderDTO.setQuantity(quantity);
		productOrderDTO.setProdId(prodDTO.getProdid());
		productOrderDTO.setSellerId(prodDTO.getSellerId());
		productOrderDTO.setStatus("Order Placed");
		System.out.println(productOrderDTO);
		System.out.println("after Dto");
		
		ProductsOrdered productOrder=productOrderDTO.createEntity(productOrderDTO);
		System.out.println("after entity");
		System.out.println(productOrder);
		orders.save(productOrder);
		}}
		
	
	