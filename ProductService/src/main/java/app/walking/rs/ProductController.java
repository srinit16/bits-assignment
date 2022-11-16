package app.walking.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import app.walking.entities.Message;
import app.walking.entities.Product;
import app.walking.service.ProductService;


@RestController
@RequestMapping("/walking-app")
public class ProductController {
	@Autowired
	private ProductService cs;
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> find(@PathVariable int id){
		Product c=cs.find(id);
		if(c!=null) {
			return ResponseEntity.ok(c);
		}else {
			Message m=new Message();
			m.setInfo("Product with Id :["+id+"], doesnt exist");
			return ResponseEntity.ok(m);
		}
	}
	
	@GetMapping("/products")
	public List<Product> find(){
		List<Product> clist=cs.findAll();
		return clist;
	}

	@PostMapping("/products")
	public Message add(@RequestBody Product c){
		return cs.save(c);
	}
}
