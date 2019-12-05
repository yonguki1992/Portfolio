package com.kyu.boardsolution.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyu.boardsolution.dao.TestDAO;


@Service
public class TestService {
	
	private static final Logger logger = LoggerFactory.getLogger(TestService.class);
	
	@Autowired
	private TestDAO testDAO;
	
	public String getToday() {
		logger.info("getToday() 호출");
		return testDAO.today();
	}
	
	public int getMul(int num1, int num2) {
		StringBuffer sb = new StringBuffer();
		sb.append("getMul(int num1, int num2) 호출 : ")
			.append(String.format("num1=%d", num1))
			.append(String.format(",num2=%d", num2));
		logger.info(sb.toString());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("num1", num1);
		map.put("num2", num2);
		
		return testDAO.mul(map);
	}
	
	public int getSum(int num1, int num2, int num3) {
		StringBuffer sb = new StringBuffer();
		sb.append("getSum(int num1, int num2, int num3) 호출 : ")
			.append(String.format("num1=%d", num1))
			.append(String.format(",num2=%d", num2))
			.append(String.format(",num3=%d", num3));
		logger.info(sb.toString());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("num1", num1);
		map.put("num2", num2);
		map.put("num3", num3);
		
		return testDAO.sum(map);
	}
	
	public int selectWriteBoardCount(String bo_table) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("bo_table", bo_table);
		
		return testDAO.selectWriteBoardCount(map);
	}
}
