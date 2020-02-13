package com.oshop.restful.oshop.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.transaction.annotation.Transactional;

import com.oshop.restful.oshop.entity.ProductData;

@Consumes("application/json")
@Produces("application/json")
@Path("/productservice")
public interface IProductService {
	
	@Path("/products")
	@POST
	public Response addProducts(ProductData data);
	
	@Path("/products")
	@GET
	public List<ProductData> getAllProducts();
	
	@Path("/category/{category}")
	@GET
	@Transactional
	public List<ProductData> getProductsByCategory(@PathParam("category") String category);
	
	@GET
	@Path("/products/{id}")
	public ProductData getProductsById(@PathParam("id") int id);
	
	@Path("/products")
	@PUT
	public ProductData updateProduct(ProductData updateProductData);
	
	@Path("/products/{id}")
	@DELETE
	public void deleteProduct(@PathParam("id") int id);
	
	@Path("/category")
	@GET
	@Transactional
	public List<String> getCatogories();
	
}
