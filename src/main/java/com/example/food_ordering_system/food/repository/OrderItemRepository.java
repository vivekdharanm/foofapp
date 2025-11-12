package com.example.food_ordering_system.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.food_ordering_system.food.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{

}
