package com.example.food_ordering_system.food.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order 
{
	@ManyToOne
	private User user;
	
     private String status;
	
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

   
    public void setUser(User user) 
    {
        this.user = user;
    }

   
    public User getUser() 
    {
        return user;
    }
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItem> items = new ArrayList<>();

    // 👇 getter for items
    public List<OrderItem> getItems() {
        return items;
    }

    // 👇 setter for items (optional)
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    // 👇 you can also add helper method
    public void addItem(OrderItem item) {
        this.items.add(item);
    }
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	

	private LocalDateTime createdAt = LocalDateTime.now();
	
	

}
