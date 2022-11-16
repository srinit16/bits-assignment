package app.walking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity @Table(name="products")
@Setter @Getter
public class Product {
	@Id @Column(name="id")
	private int id;
	@Column(name="product")
	private String productName;
	@Column(name="price")
	private double price;
	@Column(name="quantity")
	private int qty;
	
}
