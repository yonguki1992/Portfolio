package com.kyu.boardsolution.vo.write;

import java.util.List;

import lombok.Data;

@Data
public class Paging<T> {
	//입력받을 변수
	private int	totalCount;		//전체 글 갯수
	private int	currentPage;	//현재 페이지
	private int	pageSize;		//페이지당 글 갯수
	private int	blockSize;		//하단 페이지 갯수
	
	
	//계산할 변수
	private int	totalPage;		//전체 페이지 수
	private int startNo;		//시작 글번호
	private int	endNo;			//끝 글번호
	private int	startPage;		//시작 페이지
	private int	endPage;		//끝 페이지
	
	//한 페이지 분량의 VO를 담을 리스트
	private List<T> list;

	public Paging(int totalCount, int currentPage, int pageSize, int blockSize) {
		super();
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		calc();
	}
	
	public Paging(int totalCount, CommonVO commVO) {
		this(totalCount, commVO.getCurrentPage(), commVO.getPageSize(), commVO.getBlockSize());
	}
	
	//입력된 변수로 페이지를 계산하는 메서드
	private void calc() {
		//글이 1개 라도 있을때만
		if(currentPage < 1) {
			currentPage = 1;
		}
		if(pageSize < 1) {
			pageSize = 10;
		}
		if(blockSize < 1) {
			blockSize = 10;
		}
		if(totalCount>0) {
			totalPage = (totalCount - 1)/pageSize + 1;
			if(currentPage > totalPage) {
				currentPage = 1;
			}
			startNo = (currentPage - 1)*pageSize+1;	//오라클은 +1
			//startNo = (currentPage - 1)*pageSize;	//마리아db에서만 사용
			
			endNo = startNo + pageSize - 1;
			//끝 글번호는 전체갯수를 넘을 수 없다.
			if(endNo >= totalCount) {
				endNo = totalCount;	//오라클에서만 사용
				//endNo = totalCount-1;	//마리아db에서만 사용
			}
			startPage = (currentPage - 1)/blockSize*blockSize+1;
			endPage = startPage + blockSize - 1;
			if(endPage > totalPage) {
				endPage = totalPage;
			}
		}
	}
	
	//페이지 정보 출력하는 메서드 - 전체 totalCount 개 ( currentPage / totalPage )
	public String getPageInfo() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("전체").append(totalCount).append("개");
		if(totalCount > 0) {
			sb.append("(").append(currentPage).append("/").append(totalPage).append(")");
		}
		
		return sb.toString();
	}
	
	//페이지 이동버튼출력
	// [처음] [이전] [1] [2] [3] [4] ... [10] [다음] [맨뒤] 대신
	// 부트 스트랩 사용
	public String getPageList() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<nav aria-label='Page navigation example'>")
		.append("<ul class='pagination pagination-sm justify-content-center'>");
		
		//처음 & 이전
		if(startPage > blockSize) {
			sb.append("<li class='page-item'>")
			//.append("<a class='page-link' href='?p="+(startPage-1)+"&s="+pageSize+"&b="+blockSize+"' aria-label='Previous'>")
			.append("<a class='page-link' href='javascript:sendPost(\"?\",{\"p\":"+(startPage-1)+",\"s\":"+pageSize+",\"b\":"+blockSize+"})' aria-label='Previous'>")
			.append("<span aria-hidden='true'>&laquo;</span>")
			.append("<span class='sr-only'>Previous</span>")
			.append("</a>")
			.append("</li>");			
		}
		// 숫자
		for(int i = startPage; i <= endPage; ++i) {
			if(i==currentPage) {
				sb.append("<li class='page-item active'><span class='page-link' >"+i+"</span></li>");				
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='javascript:sendPost(\"?\",{\"p\":"+i+",\"s\":"+pageSize+",\"b\":"+blockSize+"})'>"+i+"</a></li>");
				// get 방식
				//.append("<li class='page-item'><a class='page-link' href='?p="+i+"&s="+pageSize+"&b="+blockSize+"'>"+i+"</a></li>");				
			}
		}
		
		//다음 & 맨뒤
		if(endPage < totalPage) {
			sb.append("<nav aria-label='Page navigation example'>")
			.append("<ul class='pagination'>")
			.append("<li class='page-item'>")
			// get 방식
			//.append("<a class='page-link' href='?p="+(endPage+1)+"&s="+pageSize+"&b="+blockSize+"' aria-label='Next'>")
			.append("<a class='page-link' href='javascript:sendPost(\"?\",{\"p\":"+(endPage+1)+",\"s\":"+pageSize+",\"b\":"+blockSize+"})' aria-label='Next'>")
			.append("<span aria-hidden='true'>&raquo;</span>")
			.append("<span class='sr-only'>Next</span>")
			.append("</a>")
			.append("</li>");	
		}
		sb.append("</ul>")
		.append("</nav>");
		return sb.toString();
	}
	
	
}
