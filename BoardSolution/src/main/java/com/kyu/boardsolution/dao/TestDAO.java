package com.kyu.boardsolution.dao;

import java.util.HashMap;

public interface TestDAO {
	/*
	<select id="today" resultType="java.lang.String">
		select sysdate from dual
	</select>

	<select id="mul" parameterType="java.util.HashMap" resultType="int">
		select #{num1 } * #{num2 } from dual
	</select>

	<select id="sum" parameterType="java.util.HashMap" resultType="int">
		select #{num1 } + #{num2 } + #{num3 } from dual
	</select>
	 */
	String today();
	int mul(HashMap<String, Integer> map);
	int sum(HashMap<String, Integer> map);
	int selectWriteBoardCount(HashMap<String, String> map);
}
