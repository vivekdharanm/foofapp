package com.example.food_ordering_system.food.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.food_ordering_system.food.model.MenuItem;
import com.example.food_ordering_system.food.repository.MenuItemRepository;

@Service
public class MenuService 
{
	private final MenuItemRepository menuItemRepository;
	
	public MenuService(MenuItemRepository menuItemRepository) 
	{
        this.menuItemRepository = menuItemRepository;
	}
	
	 public MenuItem addMenuItem(MenuItem item) 
	 {
	        return menuItemRepository.save(item);
	 }
	 
	 public List<MenuItem> getAllMenuItems() 
	 {
	        return menuItemRepository.findAll();
	 }
	 
	 public MenuItem getMenuItemById(Long id) 
	 {
	        return menuItemRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Menu item not found"));
	 }
	 
	 public MenuItem updateMenuItem(Long id, MenuItem updatedItem) 
	 {
	        MenuItem existing = getMenuItemById(id);
	        existing.setName(updatedItem.getName());
	        existing.setCategory(updatedItem.getCategory());
	        existing.setPrice(updatedItem.getPrice());
	        existing.setImageUrl(updatedItem.getImageUrl());
	        return menuItemRepository.save(existing);
	 }
	 
	 public void deleteMenuItem(Long id) 
	 {
	        menuItemRepository.deleteById(id);
	 }

}
