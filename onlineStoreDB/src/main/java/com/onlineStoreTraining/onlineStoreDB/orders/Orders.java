package com.onlineStoreTraining.onlineStoreDB.orders;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	private int id;
	private int volume;
	private String product;
	private String emission;
	private int theclient;
	
	public Orders() {}
	
	public Orders(int id, int volume, String product, String emission, int theclient) {
		super();
		this.id = id;
		this.volume = volume;
		this.product = product;
		this.emission = emission;
		this.theclient = theclient;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getEmission() {
		return emission;
	}
	public void setEmission(String emission) {
		this.emission = emission;
	}
	public int getTheclient() {
		return theclient;
	}
	public void setTheclient(int theclient) {
		this.theclient = theclient;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", volume=" + volume + ", product=" + product + ", emission=" + emission
				+ ", theclient=" + theclient + "]";
	}
	
}
