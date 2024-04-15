package com.fas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fas.entity.Orders;
import com.fas.service.OrderService;

@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

	public OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody Orders order, @RequestHeader(value = "id") int id) {
		return orderService.createOrder(order, id);
	}

	@GetMapping
	public ResponseEntity<List<Orders>> fetchAllOrders() {
		return orderService.fetchAllOrders();
	}

	@GetMapping(value = "/id")
	public ResponseEntity<Orders> fetchOrderById(@RequestParam(name = "id") int id) {
		return orderService.fetchOrderById(id);
	}

	@GetMapping(value = "/date")
	public ResponseEntity<List<Orders>> fetchOrderByOrderDate(@RequestParam(name = "orderDate") LocalDate orderDate) {
		return orderService.fetchOrderByOrderDate(orderDate);
	}

	@PutMapping(value = "/status")
	public ResponseEntity<String> updateOrderStatus(@RequestParam(name = "id") int id,
			@RequestParam(name = "status") String status) {
		return orderService.updateOrderStatus(id, status);
	}
}
