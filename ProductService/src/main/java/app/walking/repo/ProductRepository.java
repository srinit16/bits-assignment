package app.walking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.walking.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
