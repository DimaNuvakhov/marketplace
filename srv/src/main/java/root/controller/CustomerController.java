package root.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.model.Customer;
import root.service.CustomerService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Iterable<Customer> getCustomers() {
        log.info("Getting all customers.");
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        log.info("Getting customer by id: [{}].", id);
        return customerService.findById(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        log.info("Creating customer: [{}].", customer);
        return customerService.create(customer);
    }

    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        log.info("Updating customer with id: [{}].", customer.getId());
        return customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Deleting customer: [{}].", id);
        customerService.deleteById(id);
    }


}
