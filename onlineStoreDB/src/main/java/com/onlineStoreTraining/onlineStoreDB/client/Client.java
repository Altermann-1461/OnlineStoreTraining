package com.onlineStoreTraining.onlineStoreDB.client;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	private int client_id;
	private String first_name;
	private String last_name;
	private char sex ;
	
	public Client() {}
	
	public Client(int client_id, String first_name, String last_name, char sex) {
		super();
		this.client_id = client_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.sex = sex;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", first_name=" + first_name + ", last_name=" + last_name + ", sex="
				+ sex + "]";
	}
	
	

}
