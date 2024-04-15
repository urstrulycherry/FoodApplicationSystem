package com.fas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fas.entity.Orders;
import com.fas.entity.User;
import com.fas.repository.OrderRepo;
import com.fas.utils.RestTemplateBean;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	private OrderRepo orderRepo;
	private RestTemplateBean restTemplateBean;

	public OrderService(OrderRepo orderRepo, RestTemplateBean restTemplateBean) {
		this.orderRepo = orderRepo;
		this.restTemplateBean = restTemplateBean;
	}

	public ResponseEntity<String> createOrder(Orders order, int id) {
		final String apiUrl = "http://localhost:8080/api/user?id=" + id;
		ResponseEntity<User> responseEntity = restTemplateBean.getRestTemplate().exchange(apiUrl, HttpMethod.GET, null,
				User.class);

		User user = responseEntity.getBody();
		if (user != null) {
			order.setCustomerName(user.getUserName());
			order.setCustomerAddress(user.getUserAddress());
			order.setCustomerPhone(user.getUserPhone());
			order.setOrderDate(LocalDate.now());
			orderRepo.save(order);
			return new ResponseEntity<String>("Order created Successfully!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Order is not created successfully", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Orders>> fetchAllOrders() {
		return new ResponseEntity<List<Orders>>(orderRepo.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<Orders> fetchOrderById(int id) {
		return new ResponseEntity<Orders>(orderRepo.findById(id), HttpStatus.OK);
	}

	public ResponseEntity<List<Orders>> fetchOrderByOrderDate(LocalDate orderDate) {
		return new ResponseEntity<List<Orders>>(orderRepo.findByOrderDate(orderDate), HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<String> updateOrderStatus(int id, String status) {
		Orders order = orderRepo.findById(id);
		order.setStatus(status);
		orderRepo.save(order);
		return new ResponseEntity<String>("Order Status Updated Successfully!", HttpStatus.OK);
	}
}