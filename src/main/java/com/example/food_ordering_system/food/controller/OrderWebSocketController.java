package com.example.food_ordering_system.food.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.example.food_ordering_system.food.model.Order;

@Controller
public class OrderWebSocketController 
{
	@MessageMapping("/order")
	@SendTo("/topic/orders")
	public Order sendOrder(Order order) throws Exception
	{
		return order;
	}

}
