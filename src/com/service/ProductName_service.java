package com.service;

import java.util.List;

import com.Dao.Products;
import com.Dao.ProductsDao;

public class ProductName_service {
	ProductsDao p=new ProductsDao();
	
	public List<Products> findAllProducts(int flag){
		return p.findAllProductsName(flag);
	}
	public String findProductsName(int Goods_number){
		return p.findProductsName(Goods_number);
	}
	public void addProducts(Products t,int flag){
		p.addProductsName(t,flag);
	}
	public void deleteProducts(int id,int flag){
		p.deleteProducts(id,flag);
	}
	public Products findProductsById(int Goods_number){
		return p.findProductsNameById(Goods_number);
	}
	public Products findProductsAreaById(int GOODS_AreaNum){
		return p.findProductsAreaById(GOODS_AreaNum);
	}
	public void UpdateProducts(Products pp,int flag){
		p.UpdateProducts(pp,flag);
	}
	public Products findProductsId(int Goods_number){
		return p.findProductsNameId(Goods_number);
	}

}
