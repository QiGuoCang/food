package cn.et.lesson01.service;

import java.util.Map;

import cn.et.lesson01.entiy.Food;

public interface EmpService {
	
	public String saveFood();
	public Food queryFood(Integer foodid);
	public Map hello();
	public Map getFood( String foodid);
	public String updateFood();
	public String deleteFood(Integer foodid);
}
