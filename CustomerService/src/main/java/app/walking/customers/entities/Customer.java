package app.walking.customers.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity @Table(name="customers")
@Setter @Getter
public class Customer {
	@Id @Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="phone_no")
	private String phone;
	@Column(name="pincode")
	private String pincode;
	@Column(name="address")
	private String address;
}
