package cn.et.lesson01.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import cn.et.lesson01.dao.FoodRepository;
import cn.et.lesson01.entiy.Food;

@Service
public class EmpServiceImp implements EmpService {

	
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	FoodRepository er;
	

	public Map hello(){
		Map map = new HashMap();
		map.put("id", 1);
		map.put("name", "zs");
		
		return map;
	}

	public Map getFood(@PathVariable String foodid){
		List<Map<String, Object>> queryForList = jdbc.queryForList("select * from food where foodid="+foodid);
		return queryForList.get(0);
	}
	
	//添加

	public String saveFood(){
		Food food = new Food();
		food.setFoodname("sss");
		food.setImgpath("45454");
		food.setPrice(15);
		er.save(food);
		return "1";
	}

	//查询

	public Food queryFood(Integer foodid){
		Food food = er.findOne(foodid);
		return food;
	}
	
	//修改
	public String updateFood(){
		Food food = new Food();
		food.setFoodid(31);
		food.setFoodname("李四");
		food.setPrice(15);
		food.setImgpath("sssss");
		er.save(food);
		return "1";
	}
	//删除
	public String deleteFood(Integer foodid){
		
		er.delete(foodid);
		return "1";
		
	}
}
