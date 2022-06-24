
package co.unicauca.services.presentation.rest;

import co.unicauca.services.domain.entity.Customer;
import co.unicauca.services.domain.service.CustomerService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
* API REST de los servicios web. Es muy simple por ahora, en otra versión se
* hará una API más robusta. Son nuestros servicios web. La anotación @Path
* indica la URL en la cual responderá los servicios. Esta anotación se puede
* * poner a nivel de clase y método. En este ejemplo todos los servicios
* comparten el mismo Path, la acción se hacer mediante la anotació GET
* (consultar), POST (agregar), PUT (editar), DELETE (eliminar).
*
* @author Libardo, Julio
*/
@Stateless
@Path("services")
public class CustomerController {

    /**
     * Se inyecta la única implementación que hay de ProductService
     */
    @Inject
    private CustomerService service;

    public CustomerController() {
    }

    /*
    Su uso desde consola mediante client url:
    curl -X GET http://localhost:8080/Simple-API-REST-Travel-Agency/product-service/services/
    */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customer> findAll() {
        return service.findAll();
    }

    /*
    Su uso desde consola mediante client url:
    curl -X GET http://localhost:8080/Simple-API-REST-Travel-Agency/productservice/services/98000001
    */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Customer findCustomer(@PathParam("id") String id) {
        return service.findCustomer(id);
    }

    /*
    Su uso desde consola mediante client url:
    curl -X POST \
    http://localhost:8080/Simple-API-REST-Travel-Agency/product-service/services/ \
    -H 'Content-Type: application/json' \
    -d '{
    "id":"98000011",
    "firstName":"Yazmin",
    "lastName":"Gutierrez",
    "address":"Calle 32 No 8-20 Popayan",
    "mobile":"3233408378",   
    "email":"yazmin@gmail.com",
    "gender":"Femenino"
    }'
    */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String createCustomer(Customer cliente) {
        if (service.createCustomer(cliente)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Cliente creado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo crear el cliente\",\"errores\":\"Id ya existe\"}";
        }
    }
    
    /*
    Su uso desde consola mediante client url:
    curl -X PUT \
    http://localhost:8080/Simple-API-REST/product-service/products/\
    -H 'Content-Type: application/json' \
    -d '{
    "id":"98000006",
    "firstName":"Viviana",
    "lastName":"Sarria",
    "address":"Calle 32 No 8-20 Popayan",
    "mobile":"3217296166",   
    "email":"yazmin@gmail.com",
    "gender":"Femenino"
    }'
    */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String update(Customer cliente) {
        if (service.updateCustomer(cliente)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Cliente modificado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo modificar el cliente\",\"errores\":\"Id no existe\"}";
        }
    }
    
    /*
    Su uso desde consola mediante client url:
    curl -X DELETE http://localhost:8080/Simple-API-REST/productservice/products/
    */
    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") String id) {
        if (service.deleteCustomer(id)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Cliente borrado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo eliminar el cliente\",\"errores\":\"Id no existe\"}";
        }
    }
    
}
