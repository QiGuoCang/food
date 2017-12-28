package cn.et.lesson01;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson01.entiy.Food;
import cn.et.lesson01.service.EmpService;
@RestController
@SpringBootApplication
public class SbController {
	 
	@Autowired
	EmpService emp ;
	
	@RequestMapping("/hello")
	public Map hello(){
		return emp.hello();
		
	}
	
@RequestMapping("/food/{foodid}")
	public Map getFood(@PathVariable String foodid){
		
		return emp.getFood(foodid);
	}
	
	//添加
	@RequestMapping("/saveFood")
	public String saveFood(){
		return emp.saveFood();
	}

	//查询
	@RequestMapping("/queryFood")
	public Food queryFood(){
		return emp.queryFood(33);
	}

	@RequestMapping("/updateFood")
	public String updateFood(){
		return emp.updateFood();
	}

	@RequestMapping("/deleteFood/{foodid}")
	public String deleteFood(@PathVariable Integer foodid){
		return emp.deleteFood(foodid);
	}

	
	
}
