package com.example.demo.caroil.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.caroil.model.CarOil;
import com.example.demo.util.Page;

@Mapper
public interface CarOilMapper {
 
    List<CarOil> selectCarOilListByCarNoAndDate(Map<String, String> params);

	List<CarOil> findListByPage(Page<CarOil> page);

	Integer findCountByPage(Page<CarOil> page);
    
}