package com.oshop.restful.oshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.oshop.restful.oshop.entity.CategoryData;
import com.oshop.restful.oshop.entity.ProductData;
import com.oshop.restful.oshop.repository.ProductDataRepository;


public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductDataRepository productDataRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	private List<CategoryData> categoryDataList = null;
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	@Override
	public Response addProducts(ProductData data) {
		ProductData savedProduct = productDataRepository.saveAndFlush(data);
		return Response.ok(savedProduct).build();
	}

	@Override
	public List<ProductData> getAllProducts() {
		return productDataRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductData> getProductsByCategory(String category) {
		Query<ProductData> query = getSession().getNamedQuery("getProductByCategory");
		query.setParameter("category", category);
		List<ProductData> productList = query.list();
		return productList;
	}

	@Override
	public ProductData getProductsById(int id) {
		ProductData productData = productDataRepository.findById(id).get();
		return productData;
	}

	@Override
	public ProductData updateProduct(ProductData updateProductData) {
		return productDataRepository.save(updateProductData);
	}

	@Override
	public void deleteProduct(int id) {
		productDataRepository.deleteById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCatogories() {
		List<String> categoryList = null;
		Query<CategoryData> query = getSession().getNamedQuery("getAllCategories");
		categoryDataList = query.list();
		if (categoryDataList != null && !categoryDataList.isEmpty()) {
			categoryList = new ArrayList<String>();
			for (CategoryData data : categoryDataList) {
				categoryList.add(data.getName());
			}
		}
		return categoryList;
	}

	
}
