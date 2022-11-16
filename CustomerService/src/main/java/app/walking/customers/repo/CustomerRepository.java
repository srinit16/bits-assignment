package app.walking.customers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.walking.customers.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
