package com.onlineStoreTraining.onlineStoreDB.orders;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
	List<Orders> findByTheclient(int theclient);
}
