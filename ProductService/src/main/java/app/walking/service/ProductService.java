package app.walking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import app.walking.entities.Message;
import app.walking.entities.Product;

import app.walking.repo.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository cres;
	
	public Product find(int id) {
		Product c=null;
		Optional<Product> oc=cres.findById(id);
		if(oc.isPresent()) {
			c=oc.get();
		}
		return c;
	}
	
	public List<Product> findAll() {
		return cres.findAll();
	}
	
	public Message save(Product c) {
		Message m=new Message();
		try {
			c=cres.save(c);
			m.setInfo("Customer :["+c.getProductName()+"] is added successfully");
		}catch(Exception ex) {
			m.setInfo("Error while adding customer :["+c.getProductName()+"]"+ex.getMessage());
		}
		return m;
	}

}
