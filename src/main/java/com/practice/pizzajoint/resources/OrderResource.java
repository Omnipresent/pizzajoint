package com.practice.pizzajoint.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.practice.pizzajoint.json.Order;
import com.practice.pizzajoint.json.Topping;
import com.practice.pizzajoint.parameter.CsvParam;
import com.practice.pizzajoint.parameter.DateParam;
import com.practice.pizzajoint.parameter.SimpleDateParam;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author bhaarat
 */

@Path("/orders")
@Produces({MediaType.APPLICATION_JSON})
public class OrderResource {
    
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final Map<Integer, Order> ORDERS = Maps.newConcurrentMap();
    
    @GET
    public Collection<Integer> listOrderIds() {
        return ORDERS.keySet();
    }
    
    @GET
    @Path("{id: [0-9]+}")
    public Order getOrder(@PathParam("id") int id) {
        final Order order = ORDERS.get(id);
        if (order == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        else 
            return order;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public int prepareOrder(@FormParam("ordername") String name,
                            @FormParam("readydate") SimpleDateParam orderDate,
                            @FormParam("crust") String type,
                            @FormParam("carryout") @DefaultValue ("false") boolean carryout,
                            @FormParam("toppings") CsvParam csvToppings) throws IOException, Throwable {
        List<Topping> toppings = Lists.newLinkedList();
        Date dateOfOrder = orderDate.getValue();
        for (String toppingStr : csvToppings.getValue())
            toppings.add(MAPPER.readValue("\""+toppingStr+"\"", Topping.class));
        final Order newOrder = new Order(name, type, carryout, dateOfOrder, toppings);
        final Order oldOrder = ORDERS.put(newOrder.getId(), newOrder);
        return newOrder.getId();
    }
    
    
}
