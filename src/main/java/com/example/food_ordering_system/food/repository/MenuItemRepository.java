package com.example.food_ordering_system.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.food_ordering_system.food.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long>
{
	

}
