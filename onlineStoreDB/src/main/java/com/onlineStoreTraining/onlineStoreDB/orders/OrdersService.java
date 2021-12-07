package com.onlineStoreTraining.onlineStoreDB.orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	public List<Orders> getAllOrders(){
		List<Orders> orders= new ArrayList<>();
		ordersRepository.findAll()
		.forEach(orders::add);
		return orders;	
	}
	public Orders getOrders(Integer id) {
		 return ordersRepository.findById(id).get();
	}
	public void addOrders(Orders order) {
		ordersRepository.save(order);	
	}
	public void updateOrders(Orders order) {
		ordersRepository.save(order);	
	}
	public void deleteOrders(Integer id) {
		ordersRepository.deleteById(id);	
	}
	public List<Orders> getAllOrdersFromClient(Integer theclient){
		List<Orders> orders= new ArrayList<>();
		ordersRepository.findByTheclient(theclient)
		.forEach(orders::add);
		return orders;
	}
}
