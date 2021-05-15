package com.capg.msc.myshoopingcart.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Product Bean")
public class Product {

	@Id
	
	private int productId;
	
	@NotEmpty(message ="Name should not be Null"  )
	@Size(min=3,max=15,message="name not valid")
	
	@ApiModelProperty(name = "ProductName",value = "Hold the min 3 char product name",required = true)
	private String productName;
	@Min(value=1000,message="cost cannot be less than 1000")
	
	@ApiModelProperty(name = "Product cost",value = "Holds Product cost min cost 1000 allowed")
	int productCost;
	
	//@Digits(fraction = 1, integer = 5,message ="rating should be in digits and more than 0")
	@Min(value=0,message ="rating should be more than 0")
	private int productRating;
	@NotEmpty(message="category cannot be null")
	private String category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public int getProductRating() {
		return productRating;
	}
	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productRating=" + productRating + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + productCost;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productRating;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (productCost != other.productCost)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productRating != other.productRating)
			return false;
		return true;
	}
	
	
	
	
	
}
