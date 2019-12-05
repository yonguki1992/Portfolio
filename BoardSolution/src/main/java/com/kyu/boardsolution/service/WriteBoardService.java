package com.kyu.boardsolution.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyu.boardsolution.dao.WriteBoardDAO;
import com.kyu.boardsolution.vo.board.BoardVO;
import com.kyu.boardsolution.vo.write.CommonVO;
import com.kyu.boardsolution.vo.write.Paging;
import com.kyu.boardsolution.vo.write.WriteBoardVO;

@Service
public class WriteBoardService {
	
	@Autowired
	private WriteBoardDAO writeBoardDAO;
	//특정 게시판이 존재하는지 여부
	public int selectWriteBoardExistingCheck(String boTable) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bo_table", boTable);
		
		return writeBoardDAO.selectWriteBoardExistingCheck(map);
	}
	
	
	//<!-- 모든 게시판 목록 가져오기 -->
	public List<BoardVO> selectBoardList(){
		return writeBoardDAO.selectBoardList(); 
	}
		
	// 특정 게시판의 전체 갯수 가져오기
	public int selectWriteBoardGetCount(String boTable) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bo_table", boTable);
		
		return writeBoardDAO.selectWriteBoardGetCount(map);
	}
	
	//특정 게시판의 한 페이지 가져오기
	public Paging<WriteBoardVO> selectWriteBoardGetList(String boTable, int totalCount, int currentPage, int pageSize, int blockSize){
		Paging<WriteBoardVO> paging = new Paging<WriteBoardVO>(totalCount, currentPage, pageSize, blockSize);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bo_table", boTable);
		map.put("startNo", paging.getStartNo());
		map.put("endNo", paging.getEndNo());
		
		paging.setList(writeBoardDAO.selectWriteBoardGetList(map));
			
		return paging;
		
	}
	public Paging<WriteBoardVO> selectWriteBoardGetList(String boTable,int totalCount, CommonVO commVO){
		return selectWriteBoardGetList(boTable, totalCount, commVO.getCurrentPage(), commVO.getPageSize(), commVO.getBlockSize());
	}
	
	// 전체 게시판의 갯수
	public int selectAllWriteBoardGetCount() {
		return writeBoardDAO.selectAllWriteBoardGetCount();
	}
	
	
	// 모든 게시판에서 한 페이지 가져오기
	public Paging<WriteBoardVO> selectAllWriteBoardList(int totalCount, int currentPage, int pageSize, int blockSize){
		Paging<WriteBoardVO> paging = new Paging<WriteBoardVO>(totalCount, currentPage, pageSize, blockSize);
		List<BoardVO> boardList = selectBoardList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bo_table_list", boardList);
		map.put("startNo", paging.getStartNo());
		map.put("endNo", paging.getEndNo());
		
		paging.setList(writeBoardDAO.selectAllWriteBoardGetList(map));
			
		return paging;
		
	}
	public Paging<WriteBoardVO> selectAllWriteBoardList(int totalCount, CommonVO commVO){
		return selectAllWriteBoardList(totalCount, commVO.getCurrentPage(), commVO.getPageSize(), commVO.getBlockSize());
	}
	
	//글 작성하는 쿼리
	//board 테이블에서 bo_table 조건으로 찾아 bo_count_write 값 증가 시킴
	public void insertWriteBoardContent(String boTable, WriteBoardVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bo_table", boTable);
		map.put("vo", vo);
		
		writeBoardDAO.insertWriteBoardContent(map);
		writeBoardDAO.updateBoardBoCountWriteUp(map);
	}
	
	// 게시글 고유번호, 게시판 이름, 정렬 번호로 하나 가져오기(수정, 삭제 밑작업)
	public WriteBoardVO selectWriteBoardByWrId(String boTable, int wrID) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bo_table", boTable);
		map.put("wr_id", wrID);
		
		return writeBoardDAO.selectWriteBoardByWrId(map);
	}
	
	
	//update 게시글 고유번호, 게시판 이름, 게시판 정렬번호 및 유저 정보로 게시글 수정하기
	void updateWriteBoardContent(String boTable, int wrID, WriteBoardVO vo) {
		WriteBoardVO dbvo = selectWriteBoardByWrId(boTable, wrID);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bo_table", boTable);
		map.put("wr_id", wrID);
		map.put("vo", vo);
		
		// 이때 아이디 확인와 비번은 현재 접속중인 멤버가 누군지
		// 알아내는 쿼리를 통해 얻어온다.
		// controller 에서 주입해서 넘기면 될듯
		if(dbvo != null && vo != null
				&& vo.getMb_id().equals(dbvo.getMb_id())
				&& vo.getWr_password().equals(dbvo.getWr_password())) {
	
			writeBoardDAO.updateWriteBoardContent(map);
		
		}
		
	}
	
	//글삭제
	//게시글 고유번호, 게시판 이름, 게시판 정렬번호 및 유저 정보로 게시글 삭제하기
	//board 테이블에서 bo_table 조건으로 찾아 bo_count_write 값 감소 시킴
	public void deleteWriteBoardContent(String boTable, int wrID, WriteBoardVO vo) {
		WriteBoardVO dbvo = selectWriteBoardByWrId(boTable, wrID);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bo_table", boTable);
		map.put("wr_id", wrID);

		// 이때 아이디 확인와 비번은 현재 접속중인 멤버가 누군지
		// 알아내는 쿼리를 통해 얻어온다.
		// controller 에서 주입해서 넘기면 될듯
		if(dbvo != null && vo != null
				&& vo.getMb_id().equals(dbvo.getMb_id())
				&& vo.getWr_password().equals(dbvo.getWr_password())) {
	
			writeBoardDAO.deleteWriteBoardContent(map);
			writeBoardDAO.updateBoardBoCountWriteDown(map);
		}
	}	
	
}
