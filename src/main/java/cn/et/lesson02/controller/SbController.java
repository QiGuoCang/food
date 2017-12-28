package cn.et.lesson02.controller;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson02.entity.Food;
import cn.et.lesson02.mapper.FoodMapper;

@RestController
public class SbController {
	 @Autowired
	 DataSource dataSource;
	 @Autowired
	 FoodMapper fm ;
	 /**
	  * 使用springmvc的例子
	  * @return
	  */
	 @RequestMapping("/sysoSource")
	 public String hello(){
		 return dataSource.toString();
	 }	
	 
	 @RequestMapping("/queryAll")
	 public List<Food> queryAll(){
		 return fm.queryFood();
	 }	
	 
	 
	 @RequestMapping("/FoodOne/{foodid}")
	 public Food FoodOne(@PathVariable Integer foodid){
		return fm.queryById(foodid);
	 }	
	 
}
