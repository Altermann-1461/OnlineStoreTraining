package com.onlineStoreTraining.onlineStoreDB.orders;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("/orders")
	public List<Orders> getAllOrders(){
		return ordersService.getAllOrders();
	}
	
	@RequestMapping("/orders/{id}")
	public Orders getOrder(@PathVariable Integer id) {
		return ordersService.getOrders(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/orders")
	public void addOrders(@RequestBody Orders order) {
		ordersService.addOrders(order);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/orders/{id}")
	public void updateOrders(@RequestBody Orders order,@PathVariable Integer id) {
		ordersService.updateOrders(order);	
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/orders/{id}")
	public void deleteOrders(@PathVariable Integer id) {
		ordersService.deleteOrders(id);

	}
	@RequestMapping("/orders/clientid/{theclient}")
	public List<Orders> getAllByClientId(@PathVariable int theclient){
		return ordersService.getAllOrdersFromClient(theclient);
	}

}
