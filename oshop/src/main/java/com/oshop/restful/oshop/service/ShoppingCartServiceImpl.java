 package com.oshop.restful.oshop.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oshop.restful.oshop.entity.ShoppingCartData;
import com.oshop.restful.oshop.repository.ShoppingCartDataRepository;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService{

	@Autowired
	private ShoppingCartDataRepository shoppingCartDataRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	@Override
	public void saveShoppingCart(List<ShoppingCartData> shoppingCartDataList) {
		if (shoppingCartDataList != null && !shoppingCartDataList.isEmpty()) {
			for(ShoppingCartData data:shoppingCartDataList) {
				shoppingCartDataRepository.save(data);
			}
		}
	}

	@Override
	public ShoppingCartData saveToCart(ShoppingCartData data) {
		return shoppingCartDataRepository.save(data);
	}

	@Override
	public List<ShoppingCartData> getShoppingCartList() {
		return shoppingCartDataRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ShoppingCartData getShoppingCartDataByProductId(int id) {
		Query<ShoppingCartData> query = getSession().getNamedQuery("getShoppingCartDataByProductId");
		query.setParameter("id", id);
		List<ShoppingCartData> list = query.list();
		if(list!=null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getQuantity() {
		Query<Long> shoppingCartList = getSession().getNamedQuery("getQuantityCount");
		List<Long> quantity = shoppingCartList.list();
		return quantity.get(0);
	}

	@Override
	public void deleteCartById(int id) {
	shoppingCartDataRepository.deleteById(id);
	}
	
	
}
