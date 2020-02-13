package com.oshop.restful.oshop.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.oshop.restful.oshop.entity.MyOrderData;

@Consumes("application/json")
@Produces("application/json")
@Path("/myorderservice")
public interface IMyOrderService {
	
	@Path("/myorders")
	@GET
	public List<MyOrderData> getAllOrder();
	
	@Path("/myorders/{userName}")
	@GET
	public MyOrderData getOrderByUserName(@PathParam("userName") String userName);

}
