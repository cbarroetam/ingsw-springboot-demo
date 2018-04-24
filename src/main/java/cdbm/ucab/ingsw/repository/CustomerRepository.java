package cdbm.ucab.ingsw.repository;

import cdbm.ucab.ingsw.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerRepository")
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findFirst3ByEmailIgnoreCaseContaining(String partialEmailAddress);
}
