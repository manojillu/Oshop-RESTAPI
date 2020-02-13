package com.oshop.restful.oshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "myorders")
public class MyOrderData {

	public MyOrderData() {
	}

	public MyOrderData(String userName, int orderNumber) {
		super();
		this.userName = userName;
		this.orderNumber = orderNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "myorder_id")
	private int id;
	@Column(name = "username")
	private String userName;
	@Column(name = "order_number")
	private int orderNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}
