package com.oshop.restful.oshop.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

import com.oshop.restful.oshop.entity.ShoppingCartData;

@Consumes("application/json")
@Produces("application/json")
@Path("/shoppingcartservice")
public interface IShoppingCartService {
	
	@POST
	@Path("/saveshoppingcartlist")
	public void saveShoppingCart(List<ShoppingCartData> shoppingCartDataList);
	
	@POST
	@Path("/shoppingcart")
	public ShoppingCartData saveToCart(ShoppingCartData data);
	
	@GET
	@Path("/shoppingcart")
	public List<ShoppingCartData> getShoppingCartList();
	
	@GET
	@Path("/shoppingcart/{id}")
	@Transactional
	public ShoppingCartData getShoppingCartDataByProductId(@PathParam("id") int id);
	
	@GET
	@Path("/quantity")
	@Transactional
	public Long getQuantity();
	
	@DELETE
	@Path("/shoppingcart/{id}")
	public void deleteCartById(@PathParam("id") int id);

}
