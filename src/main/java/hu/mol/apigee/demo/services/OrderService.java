package hu.mol.apigee.demo.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import hu.mol.apigee.demo.model.Order;

@Path("/orders")
public class OrderService {

    private static HashMap<String, HashMap<String, Order>> orderStore = new HashMap<String, HashMap<String, Order>>();

    @GET
    @Path("example/generate")
    @Produces({MediaType.APPLICATION_JSON})
    public Order getExampleOrder() {
		FreshCornerService freshCornerService = new FreshCornerService();
		return new Order("1", new Date().toString(), freshCornerService.getShops().get(1),
		    freshCornerService.getMeals(), freshCornerService.getDrinks());
    }

    @GET
    @Path("{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Order> getUserOrders(@PathParam("username") String username) {
        if(orderStore.get(username) != null) {
            return new ArrayList<Order>(orderStore.get(username).values());
		}
		else {
			return new ArrayList<Order>();
		}
    }

    @POST
    @Path("{username}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Order placeOrder(@PathParam("username") String username, Order order) {
        HashMap<String, Order> userOrderStore = orderStore.get(username);
        if(userOrderStore == null) {
            userOrderStore = new HashMap<String, Order>();
            orderStore.put(username, userOrderStore);
		}
		order.setId(Long.toString(System.currentTimeMillis()));
		userOrderStore.put(order.getId(), order);
		return order;
	}

    @DELETE
    @Path("{username}/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Order deleteOrder(@PathParam("username") String username, @PathParam("id") String id) {
        HashMap<String, Order> userOrderStore = orderStore.get(username);
        if(userOrderStore != null) {
            return userOrderStore.remove(id);
		}
        return null;
	}

}
