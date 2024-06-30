package root.repository;


import org.springframework.data.repository.CrudRepository;
import root.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}