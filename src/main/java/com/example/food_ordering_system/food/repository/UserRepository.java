package com.example.food_ordering_system.food.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.food_ordering_system.food.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	Optional<User> findByEmail(String email);
}
