package com.oshop.restful.oshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oshop.restful.oshop.entity.MyOrderData;
import com.oshop.restful.oshop.repository.MyOrderDataRepository;

@Service
public class MyOrderServiceImpl implements IMyOrderService {
	
	@Autowired
	private MyOrderDataRepository myOrderDataRepo;
	
	@Override
	public List<MyOrderData> getAllOrder() {
		return myOrderDataRepo.findAll();
	}

	@Override
	public MyOrderData getOrderByUserName(String userName) {
		return myOrderDataRepo.findById(userName).get();
	}

}
