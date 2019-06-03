package com.example.demo.caroil.service;

import java.util.List;
import com.example.demo.caroil.model.CarOil;
import com.example.demo.util.Page;
 
public interface CarOilService {
	
	List<CarOil> selectCarOilListByCarNoAndDate(String carNo, String tableName, String date);

	Page<CarOil> findListByPage(Page<CarOil> page) throws Exception;
}
