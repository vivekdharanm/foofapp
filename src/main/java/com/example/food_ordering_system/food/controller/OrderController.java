package com.example.food_ordering_system.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_ordering_system.food.model.MenuItem;
import com.example.food_ordering_system.food.model.Order;
import com.example.food_ordering_system.food.model.OrderItem;
import com.example.food_ordering_system.food.model.User;
import com.example.food_ordering_system.food.repository.MenuItemRepository;
import com.example.food_ordering_system.food.repository.OrderItemRepository;
import com.example.food_ordering_system.food.repository.OrderRepository;
import com.example.food_ordering_system.food.repository.UserRepository;

@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody List<Long> itemIds) {
        if (itemIds == null || itemIds.isEmpty()) {
            return ResponseEntity.badRequest().body("No item IDs provided");
        }

        Order order = new Order();
        order.setStatus("PENDING");
        orderRepository.save(order);
        
        User user = userRepository.findById(1L).orElse(null);
        order.setUser(user);

        for (Long itemId : itemIds) {
            MenuItem menuItem = menuItemRepository.findById(itemId)
                    .orElseThrow(() -> new RuntimeException("Item not found with id: " + itemId));

            OrderItem orderItem = new OrderItem();
            orderItem.setMenuItem(menuItem);
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);

            order.addItem(orderItem);
        }

        orderRepository.save(order);
        return ResponseEntity.ok(order);
    }
    
}
