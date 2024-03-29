package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.services.OrderItemService;

@RestController
@RequestMapping(value = "/items")
public class OrderItemResource {
	
	@Autowired
	private OrderItemService service;
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll(){
		List<OrderItem> OrderItems = service.findAll();
		return ResponseEntity.ok().body(OrderItems);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable Long id){
		OrderItem OrderItem = service.findById(id);
		
		return ResponseEntity.ok().body(OrderItem);
	}
}
