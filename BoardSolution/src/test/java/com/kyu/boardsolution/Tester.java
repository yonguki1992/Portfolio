package com.kyu.boardsolution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kyu.boardsolution.vo.board.BoardVO;

public class Tester {

	
	@Test
	public void test1() {
		BoardVO vo = new BoardVO();
		
		assertEquals(vo.str2Array("감자|`|고구마"), new String[] {"감자","고구마"});
	}
	@Test
	public void test2() {
		BoardVO vo = new BoardVO();
		
		assertEquals(vo.array2Str(new String[] {"감자","고구마"}), "감자|`|고구마");
	}
}
