package cn.et.lesson01.dao;

import org.springframework.data.repository.CrudRepository;

import cn.et.lesson01.entiy.Food;

public interface FoodRepository extends CrudRepository<Food, Integer> {

}
