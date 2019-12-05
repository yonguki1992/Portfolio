package com.kyu.boardsolution.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kyu.boardsolution.vo.board.BoardVO;
import com.kyu.boardsolution.vo.write.WriteBoardVO;

public interface WriteBoardDAO {
	
	// 특정 게시판 존재 여부 확인
	int selectWriteBoardExistingCheck(Map<String, Object> map);
	
	// 모든 게시판 목록 가져오기
	List<BoardVO> selectBoardList();
	
	// 특정 게시판의 전체 갯수 가져오기 
	int selectWriteBoardGetCount(Map<String, Object> map);
	
	// startNo ~ endNo 까지 특정 게시판 하나의 페이지 정보 가져오기
	List<WriteBoardVO> selectWriteBoardGetList(Map<String, Object> map);
	
	//전체 게시판의 갯수 가져오기
	int selectAllWriteBoardGetCount();
	
	// startNo ~ endNo 까지 모든 게시판의 페이지 정보 가져오기
	List<WriteBoardVO> selectAllWriteBoardGetList(Map<String, Object> map);
	
	// insert
	// 특정 게시판에 글 작성
	void insertWriteBoardContent(Map<String, Object> map);
	
	// board 테이블의 특정 테이블(bo_table값)을 찾아 bo_count_write 증가시킴
	void updateBoardBoCountWriteUp(Map<String, Object> map);
	// insert
	
	
	//게시글 고유번호, 게시판 이름으로 글하나 가져오기
	WriteBoardVO selectWriteBoardByWrId(Map<String, Object> map);
	
	
	// update 게시글 고유번호, 게시판 이름, 게시판 정렬번호 및 유저 정보로 게시글 수정하기
	// board 테이블의 "bo_table"='특정 게시판 이름' 조건으로 찾아 bo_count_write 증가 시키지 않음
	void updateWriteBoardContent(Map<String, Object> map);
	
	
	//delete
	// 글 삭제
	void deleteWriteBoardContent(Map<String, Object> map);
	
	void updateBoardBoCountWriteDown(Map<String, Object> map);
	//delete
	
}
