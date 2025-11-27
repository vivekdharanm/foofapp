package com.example.food_ordering_system.food.controller;

import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.food_ordering_system.food.model.MenuItem;
import com.example.food_ordering_system.food.model.Order;
import com.example.food_ordering_system.food.repository.MenuItemRepository;
import com.example.food_ordering_system.food.repository.OrderRepository;

@Controller
@RequestMapping("/admin")
public class AdminController 
{
	private final MenuItemRepository menuItemRepository;
    private final OrderRepository orderRepository;
    
    public AdminController(MenuItemRepository menuItemRepository, OrderRepository orderRepository)
    {
        this.menuItemRepository = menuItemRepository;
        this.orderRepository = orderRepository;
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model)
    {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "admin-dashboard";
    }
    
    @GetMapping("/menu")
    public String menu(Model model)
    {
        model.addAttribute("items", menuItemRepository.findAll());
        return "admin-menu";
    }
    
    @PostMapping("/menu/add")
    public String addMenuItem(@ModelAttribute MenuItem item){
        menuItemRepository.save(item);
        return "redirect:/admin/menu";
    }
    
    @PostMapping("/order/{id}/status")
    public String updateOrderStatus(@PathVariable Long id, @RequestParam String status){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(status);
        orderRepository.save(order);
        return "redirect:/admin/dashboard";
    }

}
