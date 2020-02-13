package com.oshop.restful.oshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.restful.oshop.entity.MyOrderData;

public interface MyOrderDataRepository  extends JpaRepository<MyOrderData, String>{

}
