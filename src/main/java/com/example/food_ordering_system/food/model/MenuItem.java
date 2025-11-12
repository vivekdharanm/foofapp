package com.example.food_ordering_system.food.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MenuItem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String category;
	private double price;
	private String imageUrl;
	
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getCategory() 
	{
		return category;
	}
	
	public void setCategory(String category) 
	{
		this.category = category;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public String getImageUrl() 
	{
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) 
	{
		this.imageUrl = imageUrl;
	}

}
