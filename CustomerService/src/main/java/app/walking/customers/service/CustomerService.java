package app.walking.customers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.walking.customers.entities.Customer;
import app.walking.customers.entities.Message;
import app.walking.customers.repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository cres;
	
	public Customer find(int id) {
		Customer c=null;
		Optional<Customer> oc=cres.findById(id);
		if(oc.isPresent()) {
			c=oc.get();
		}
		return c;
	}
	
	public List<Customer> findAll() {
		return cres.findAll();
	}
	
	public Message save(Customer c) {
		Message m=new Message();
		try {
			c=cres.save(c);
			m.setInfo("Customer :["+c.getFirstName()+"] is added successfully");
		}catch(Exception ex) {
			m.setInfo("Error while adding customer :["+c.getFirstName()+"]"+ex.getMessage());
		}
		return m;
	}

}
