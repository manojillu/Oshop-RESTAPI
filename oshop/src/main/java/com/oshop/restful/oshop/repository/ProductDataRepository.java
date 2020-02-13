package com.oshop.restful.oshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.restful.oshop.entity.ProductData;

public interface ProductDataRepository extends JpaRepository<ProductData, Integer>{

}
