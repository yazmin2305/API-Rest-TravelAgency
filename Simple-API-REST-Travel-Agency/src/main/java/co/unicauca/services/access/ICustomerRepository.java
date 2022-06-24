package co.unicauca.services.access;

import co.unicauca.services.domain.entity.Customer;
import java.util.List;

/**
 * Interface del respositorio de clientes
 * @author YazminG
 */
public interface ICustomerRepository {
    
    List<Customer> findAll();
    public Customer findCustomer(String id);
    public boolean createCustomer(Customer customer);
    public boolean updateCustomer(Customer customer);    
    public boolean deleteCustomer(String id);

}
