package com.example.food_ordering_system.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.food_ordering_system.food.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{

}
