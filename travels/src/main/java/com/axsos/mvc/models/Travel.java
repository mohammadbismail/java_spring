package com.axsos.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="travels")
public class Travel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull(message="expense cant be blank")
		@Size(min= 5,max= 100)
		private String expense;
		
		@NotNull(message="vendor cant be blank")
		@Size(min=5, max=100, message="vendor has to be miniumum 5  characters")
		private String vendor;
		
		@NotNull(message="amount cant be blank")
		@Min(value = (long) 0.000001, message="amount has to be more than 0")
		private Double price;
		
		@NotNull(message="description cant be blank")
		@Size(min=5,max=200, message="description has to be miniumum 5  characters")
		private String description;
		
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd','HH:mm")
		private Date createdAt;
		
		@DateTimeFormat(pattern="yyyy-MM-dd','HH:mm")
		private Date updatedAt;
		
		//Constructors
		public Travel() {
		}

		public Travel(String expense,String vendor,Double price,String description) {
			this.expense = expense;
			this.vendor = vendor;
			this.price = price;
			this.description = description;
		}
		// Getters & Setters

		public String getExpense() {
			return expense;
		}

		public void setExpense(String expense) {
			this.expense = expense;
		}

		public String getVendor() {
			return vendor;
		}

		public void setVendor(String vendor) {
			this.vendor = vendor;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Date getCreatedAt() {
			return createdAt;
		}
		
		@PrePersist
		protected void setCreatedAt() {
			this.createdAt = new Date();
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}
		@PreUpdate
		protected void setUpdatedAt() {
			this.updatedAt = new Date();
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		
		
}
