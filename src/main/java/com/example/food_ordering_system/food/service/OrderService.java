package com.example.food_ordering_system.food.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.food_ordering_system.food.model.Order;
import com.example.food_ordering_system.food.repository.OrderRepository;

@Service
public class OrderService 
{
	private OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository)
	{
		this.orderRepository = orderRepository;
	}
	
	public Order saveOrder(Order order)
	{
		return orderRepository.save(order);
	}
	
	public List<Order> getAllOrder()
	{
		return orderRepository.findAll();
	}
	
	public Order updateOrderStatus(Long orderId, String status)
	{
		Order order = orderRepository.findById(orderId).orElseThrow();
		order.setStatus(status);
		return orderRepository.save(order);
	}

}