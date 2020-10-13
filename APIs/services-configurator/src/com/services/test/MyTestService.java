package com.services.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.services.configurator.ServicesConfigurator;

import common.beans.Order;
import common.beans.Product;
import common.beans.User;
import common.request.MainRequestObject;
import common.response.MainResponseObject;

public class MyTestService {
	public static final String dbCode = "MX_FIT";
	public static void main(String [] args) {
		//getUsers();
		//getProducts();
		//addProduct();
		//deleteProduct();
		//updateProduct();
		getOrders();
	}
	
	public static void getOrders() {
		ServicesConfigurator servicesConfigurator = new ServicesConfigurator();
		MainRequestObject mainRequestObject = new MainRequestObject();
		MainResponseObject mainResponseObject = null;
		mainRequestObject.setDbCode(dbCode);
		mainResponseObject = servicesConfigurator.getOrders(mainRequestObject);
		System.out.println("Response Code: "+ mainResponseObject.getResponseCode());
		System.out.println("Response Desc: "+ mainResponseObject.getResponseDesc());
		if (null != mainResponseObject.getOrders()) {
			for (Order order : mainResponseObject.getOrders()) {
				System.out.println(" ---- Orders -----");
				System.out.println(order);
				System.out.println("\n");
			}
		}
	}
	
	public static void getUsers() {
		ServicesConfigurator servicesConfigurator = new ServicesConfigurator();
		MainRequestObject mainRequestObject = new MainRequestObject();
		MainResponseObject mainResponseObject = null;
		mainRequestObject.setDbCode(dbCode);
		mainResponseObject = servicesConfigurator.getUsers(mainRequestObject);
		System.out.println("Response Code: "+ mainResponseObject.getResponseCode());
		System.out.println("Response Desc: "+ mainResponseObject.getResponseDesc());
		for (User user : mainResponseObject.getUsers()) {
			System.out.println(" ---- Users -----");
			System.out.println(user);
			System.out.println("\n\n");
		}
	}
	
	public static void getProducts() {
		ServicesConfigurator servicesConfigurator = new ServicesConfigurator();
		MainRequestObject mainRequestObject = new MainRequestObject();
		MainResponseObject mainResponseObject = null;
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		mainRequestObject.setIds(ids);
		mainRequestObject.setDbCode(dbCode);
		mainRequestObject.setFetchOutOfStockProducts(true);
		mainResponseObject = servicesConfigurator.getProducts(mainRequestObject);
		System.out.println("Response Code: "+ mainResponseObject.getResponseCode());
		System.out.println("Response Desc: "+ mainResponseObject.getResponseDesc());
		for (Product product : mainResponseObject.getProducts()) {
			System.out.println(" ---- Products -----");
			System.out.println(product);
			System.out.println("\n");
		}
	}
	
	public static void addProduct() {
		ServicesConfigurator servicesConfigurator = new ServicesConfigurator();
		MainRequestObject mainRequestObject = new MainRequestObject();
		MainResponseObject mainResponseObject = null;
		
		Product product = new Product();
		Date expDate;
		Date mfgDate;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 5);
        cal.set(Calendar.DATE, 24);
        cal.set(Calendar.YEAR, 2022);
        expDate = cal.getTime();
        
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DATE, 01);
        cal.set(Calendar.YEAR, 2020);
        mfgDate = cal.getTime();
        
		product.setName("ON Whey");
		product.setCategory("Protein");
		product.setDescription("Optimum Nutrition");
		product.setDirectiontoUse("1 Serving Per Day");
		product.setBarCode("4455663321");
		product.setDiscount(5.00);
		product.setExpiryDate(expDate);
		product.setFlavour("Vanilla");
		product.setMfgDate(mfgDate);
		product.setNetPrice(12500.00);
		product.setOrgPrice(14800.00);
		product.setRtlPrice(12500.00);
		product.setServings("30");
		product.setWeight("5");
		
		mainRequestObject.setDbCode(dbCode);
		mainRequestObject.setProductInfo(product);
		mainResponseObject = servicesConfigurator.addProduct(mainRequestObject);
		System.out.println("Response Code: "+ mainResponseObject.getResponseCode());
		System.out.println("Response Desc: "+ mainResponseObject.getResponseDesc());
	}
	
	public static void deleteProduct() {
		ServicesConfigurator servicesConfigurator = new ServicesConfigurator();
		MainRequestObject mainRequestObject = new MainRequestObject();
		MainResponseObject mainResponseObject = null;
		mainRequestObject.setDbCode(dbCode);
		
		Product product = new Product();
		product.setId(2);
		mainRequestObject.setProductInfo(product);
		mainResponseObject = servicesConfigurator.deleteProduct(mainRequestObject);
		System.out.println("Response Code: "+ mainResponseObject.getResponseCode());
		System.out.println("Response Desc: "+ mainResponseObject.getResponseDesc());
		
	}
	
	public static void updateProduct() {
		ServicesConfigurator servicesConfigurator = new ServicesConfigurator();
		MainRequestObject mainRequestObject = new MainRequestObject();
		MainResponseObject mainResponseObject = null;
		mainRequestObject.setDbCode(dbCode);
		
		Product product = new Product();
		product.setId(2);
		product.setName("ON my Whey");
		mainRequestObject.setProductInfo(product);
		mainResponseObject = servicesConfigurator.updateProduct(mainRequestObject);
		System.out.println("Response Code: "+ mainResponseObject.getResponseCode());
		System.out.println("Response Desc: "+ mainResponseObject.getResponseDesc());
		
	}
}