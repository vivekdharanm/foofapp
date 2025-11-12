package com.example.food_ordering_system.food.controller;

import java.util.List;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.food_ordering_system.food.model.MenuItem;
import com.example.food_ordering_system.food.model.Order;
import com.example.food_ordering_system.food.model.OrderItem;
import com.example.food_ordering_system.food.model.User;
import com.example.food_ordering_system.food.repository.MenuItemRepository;
import com.example.food_ordering_system.food.repository.OrderRepository;
import com.example.food_ordering_system.food.repository.UserRepository;

@Controller
public class UserController 
{
	private final MenuItemRepository menuItemRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final SimpMessagingTemplate template;
    
    public UserController (MenuItemRepository menuItemRepository, OrderRepository orderRepository,
            UserRepository userRepository, SimpMessagingTemplate template) 
    {
    	this.menuItemRepository = menuItemRepository;
    	this.orderRepository = orderRepository;
    	this.userRepository = userRepository;
    	this.template = template;
    }
    
    @GetMapping("/menu")
    public String menuPage(Model model)
    {
        List<MenuItem> items = menuItemRepository.findAll();
        model.addAttribute("items", items);
        return "menu";
    }
    
    @PostMapping("/order")
    public String placeOrder(@RequestParam List<Long> itemIds, Model model)
    {
        User user = userRepository.findById(1L).orElseThrow(); // demo user
        Order order = new Order();
        order.setUser(user);

        for(Long id: itemIds)
        {
            MenuItem menuItem = menuItemRepository.findById(id).orElseThrow();
            OrderItem orderItem = new OrderItem();
            orderItem.setMenuItem(menuItem);
            orderItem.setQuantity(1);
            orderItem.setOrder(order);
            order.getItems().add(orderItem);
        }

        orderRepository.save(order);

        
        template.convertAndSend("/topic/orders", order);

        model.addAttribute("message", "Order placed successfully!");
        return "menu";
    }


}
