package cn.et.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.et.lesson02.entity.Food;


@Mapper
public interface FoodMapper {
	@Select("select * from food")
	List<Food>queryFood();
	
	
	@Select("select * from food where foodid=#{0}")
	Food queryById(int id);
}
