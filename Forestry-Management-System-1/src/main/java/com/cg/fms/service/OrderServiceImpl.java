package com.cg.fms.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.OrderDao;
import com.cg.fms.exception.LandException;
import com.cg.fms.exception.OrderException;
import com.cg.fms.model.OrderModel;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private OrderDao orderRepo;
	
	@Autowired
	private EMParser parser;
	
	public OrderServiceImpl() {
		/* default constructor */
	}
	
	public OrderServiceImpl(OrderDao orderRepo) {
		super();
		this.orderRepo = orderRepo;
		this.parser =new EMParser();
	}
	
	

	public OrderDao getOrderRepo() {
		return orderRepo;
	}



	public void setOrderRepo(OrderDao orderRepo) {
		this.orderRepo = orderRepo;
	}



	public EMParser getParser() {
		return parser;
	}



	public void setParser(EMParser parser) {
		this.parser = parser;
	}

	@Override
	public OrderModel getOrder(String orderNumber) throws OrderException {
		if (!orderRepo.existsById(orderNumber))
			throw new OrderException("No order found for the given Id");
		return parser.parse(orderRepo.findById(orderNumber).get());
	}

	@Override
	public OrderModel addOrder(OrderModel order) throws OrderException{
		if(order==null) {
			throw new OrderException("order should not be null");
		}
		else if ( order!= null) {
			if (orderRepo.existsById(order.getOrderNumber())) {
				throw new OrderException("Order with this id already exists");
			}

			order = parser.parse(orderRepo.save(parser.parse(order)));
		}

		return order;
	}
	@Override
	public OrderModel updateOrder(OrderModel orderModel) {
		if (orderModel != null) {
			if (orderRepo.existsById(orderModel.getOrderNumber())) {
				orderModel = parser.parse(orderRepo.save(parser.parse(orderModel)));
			}
			
		}
		return orderModel;
	}

	@Override
	public void deleteOrder(String orderNumber) {
		if(orderNumber==null) {
			throw new OrderException("Order number should not be null");
		}else if (!orderRepo.existsById(orderNumber)) {
			throw new OrderException("Order Number"+orderNumber+" does not exists");
		}else {
			orderRepo.deleteById(orderNumber);
		}
	}
	@Override
	public List<OrderModel> getAllOrders() {
		return orderRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Override
	public OrderModel findById(String orderNumber) throws OrderException {
		if(orderNumber==null) {
			throw new OrderException("Order number should not be null");
		}else if (!orderRepo.existsById(orderNumber)) {
			throw new OrderException("Order Number"+orderNumber+" does not exists");
		}else {
			return parser.parse(orderRepo.findById(orderNumber).orElse(null));
		}
	}
	
	@Override
	public boolean existsById(String orderNumber) throws OrderException {
		if(orderNumber==null) {
			throw new OrderException("Order Number should not be null");
		}
		return orderRepo.existsById(orderNumber);
	}
	
}
