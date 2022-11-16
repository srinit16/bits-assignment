package app.walking.customers.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.walking.customers.entities.Customer;
import app.walking.customers.entities.Message;
import app.walking.customers.service.CustomerService;

@RestController
@RequestMapping("/walking-app")
public class CustomerController {
	@Autowired
	private CustomerService cs;
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<?> find(@PathVariable int id){
		Customer c=cs.find(id);
		if(c!=null) {
			return ResponseEntity.ok(c);
		}else {
			Message m=new Message();
			m.setInfo("Customer with Id :["+id+"], doesnt exist");
			return ResponseEntity.ok(m);
		}
	}
	
	@GetMapping("/customers")
	public List<Customer> find(){
		List<Customer> clist=cs.findAll();
		return clist;
	}

	@PostMapping("/customers")
	public Message add(@RequestBody Customer c){
		return cs.save(c);
	}
}
