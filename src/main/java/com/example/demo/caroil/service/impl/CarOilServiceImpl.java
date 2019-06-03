package com.example.demo.caroil.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.caroil.dao.CarOilMapper;
import com.example.demo.caroil.model.CarOil;
import com.example.demo.caroil.service.CarOilService;
import com.example.demo.util.Page;
 

@Service("carOilService")
public class CarOilServiceImpl implements CarOilService {
	
	@Autowired
	private CarOilMapper carOilMapper;

	@Override
	public List<CarOil> selectCarOilListByCarNoAndDate(String carNo, String tableName, String date) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("carNo", carNo);
		params.put("tableName", tableName);
		params.put("date", date);
		List<CarOil> carOilList = carOilMapper.selectCarOilListByCarNoAndDate(params);
		return carOilList == null? new ArrayList<CarOil>():carOilList ;
	}
	
    @Override
    public Page<CarOil> findListByPage(Page<CarOil> page) throws Exception {
        List<CarOil> list = carOilMapper.findListByPage(page);
        if (page != null && page.getTotalSize() == 0) {
            Integer totalSize = carOilMapper.findCountByPage(page);
            page.setTotalSize(totalSize);
        }
        page.setList(list);
        return page;
    }


}
