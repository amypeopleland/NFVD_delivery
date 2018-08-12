package com.service;

import java.util.List;

import com.Dao.Goods;
import com.Dao.GoodsDao;

public class Admini_service {
	GoodsDao  goods=new GoodsDao();
	
	public void addGoods(Goods t){
		goods.addGoods(t);
	}
	
	public List<Goods> findAllGoods(){
		return goods.findAllGoods();
	}
	public Goods findAllGoodsById(String id){
		return goods.findGoodsById(id);
	}
	
	public Goods UpdateGoodsByID(Goods te){
		return goods.UpdateGoodsByID(te);
	}
	public int DeleteGoods(int id){
		//return goods.DeleteGoods(id);
		int flag;
		flag=goods.DeleteGoods(id);
		return flag;
	}
	
	public List<Goods> findAllToBuyGoods(){
		return goods.findAllToBuyGoods();
	}
	public Goods BuyerById(int id){
		return goods.BuyerById(id);
	}

	public int getGOODS_remain(int id){
		return goods.getGOODS_remain(id);
	}
	public void Updateremain(int remain,int number){
		goods.Updateremain(remain, number);
		
	}
}
