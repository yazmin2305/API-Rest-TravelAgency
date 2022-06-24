package co.unicauca.services.access;

import co.unicauca.services.domain.entity.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de ICustomerRepository. Utilliza arreglos en memoria
 *
 * @author YazminG
 */
public final class CustomerRepositoryImplArrays implements ICustomerRepository {

    /**
     * Array List de clientes
     */
    private static List<Customer> customers;

    public CustomerRepositoryImplArrays() {
        if (customers == null){
            customers = new ArrayList();
        }
        
        if (customers.size() == 0){
            inicializar();
        }
    }

    public void inicializar() {
        customers.add(new Customer("98000001", "Andrea", "Sanchez", "Calle 14 No 11-12 Popayan", "3145878752", "andrea@hotmail.com", "Femenino"));
        customers.add(new Customer("98000002", "Libardo", "Pantoja", "Santa Barbar Popayan", "3141257845", "libardo@gmail.com", "Masculino"));
        customers.add(new Customer("98000003", "Carlos", "Pantoja", "Santa Barbar Popayan", "3141257846", "carlos@gmail.com", "Masculino"));
        customers.add(new Customer("98000004", "Fernanda", "Arevalo", "Calle 16 No 12-12 Popayan", "3154562133", "fercha@hotmail.com", "Femenino"));
        customers.add(new Customer("98000005", "Manuel", "Perez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000006", "Alejandro", "Mosquera", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000007", "Cesar", "Gutierres Sanchez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000008", "Julio", "Bravo Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000009", "Alberto", "Mendez Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000010", "Alexander", "Ponce Yepes", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));

    }
    @Override
    public List<Customer> findAll() {
        return customers;
    }

    /**
     * Busca un Customer en el arreglo
     *
     * @param id cedula del customer
     * @return objeto Customer
     */
    @Override
    public Customer findCustomer(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
    /**
     * Crea un Customer en el arreglo
     *
     * @param customer objeto Customer
     * @return boolean
     */
    @Override
    public boolean createCustomer(Customer customer) {
        Customer cust = this.findCustomer(customer.getId());
        if(cust != null){
            //el cliente ya existe
            return false;
        }        
        customers.add(customer);
        return true;
    }    
    /**
     * Actualiza un Customer en el arreglo
     *
     * @param customer objeto Customer
     * @return boolean
     */
    @Override
    public boolean updateCustomer(Customer customer) {
        Customer cust = this.findCustomer(customer.getId());
        if(cust != null){
            //el cliente existe y se puede actualizar
            cust.setFirstName(customer.getFirstName());
            cust.setLastName(customer.getLastName());
            cust.setAddress(customer.getAddress());
            cust.setMobile(customer.getMobile());
            cust.setEmail(customer.getEmail());
            cust.setGender(customer.getGender());
            return true;
        }        
        return false;
    }
    /**
     * Elimina un Customer en el arreglo
     *
     * @param id cedula del customer
     * @return boolean
     */
    @Override
    public boolean deleteCustomer(String id) {
        int i = 0;
        for (Customer cliente : customers) {
            if (cliente.getId().equals(id)) {
                customers.remove(cliente);
                return true;
            }
        }
        return false;
    }

}
