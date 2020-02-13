package com.oshop.restful.oshop.bean;

import java.io.Serializable;

public class CheckOutControllerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long totalQuantity;

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	
	
}
