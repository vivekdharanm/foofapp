package com.example.food_ordering_system.food.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class OrderItem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "menu_item_id")
	private MenuItem menuItem;
	
	private int quantity;
	
	public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
	
    public MenuItem getMenuItem() 
    {
        return menuItem;
    }
    
    public void setMenuItem(MenuItem menuItem) 
    {
        this.menuItem = menuItem;
    }

   
    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }

}
