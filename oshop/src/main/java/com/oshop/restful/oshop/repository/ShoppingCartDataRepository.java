package com.oshop.restful.oshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.restful.oshop.entity.ShoppingCartData;

public interface ShoppingCartDataRepository extends JpaRepository<ShoppingCartData, Integer>{

}
