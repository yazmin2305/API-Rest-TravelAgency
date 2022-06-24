package co.unicauca.services.domain.service;

import co.unicauca.services.access.ICustomerRepository;
import co.unicauca.services.domain.entity.Customer;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.inject.Inject;


/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
 * @author Libardo, Julio
 */
public class CustomerService {

    /**
     * Repositorio de clientes
     */
    @Inject
    @Default
    ICustomerRepository repo;
    
    public CustomerService(){}

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo ICustomerRepository
     */
    public CustomerService(ICustomerRepository repo) {
        this.repo = repo;
    }

    /**
     * Buscar un cliente
     *
     * @param id cedula
     * @return objeto tipo Customer
     */
    public Customer findCustomer(String id) {
        return repo.findCustomer(id);
    }

    public boolean createCustomer(Customer customer) {
        return repo.createCustomer(customer);
    }   
    
    public boolean deleteCustomer(String id) {
        return repo.deleteCustomer(id);
    }
    
    public boolean updateCustomer(Customer customer){
        return repo.updateCustomer(customer);
    }
    
    public List<Customer> findAll() {
        return repo.findAll();
    }

}
