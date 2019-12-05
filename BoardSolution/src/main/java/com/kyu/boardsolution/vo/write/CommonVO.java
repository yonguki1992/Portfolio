package com.kyu.boardsolution.vo.write;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;

//페이지 넘어갈때 전달되는 정보들
@XmlRootElement
@Getter
public class CommonVO {

	private int p; 				// 현재 페이지(쿼리스트링)
	private int s; 				// 페이지당 글 갯수(쿼리스트링)
	private int b; 				// 하단 페이지 갯수(쿼리스트링)
	private int wr_id; 			// 게시글 고유번호(id)
	private int currentPage;	// 현재 페이지
	private int pageSize;		// 페이지당 글 갯수
	private int blockSize;		// 하단 페이지 갯수

	public CommonVO() {
		this.currentPage = 1;
		this.pageSize = 10;
		this.blockSize = 10;
	}

	public void setP(int p) {
		this.p = p;
		this.currentPage = this.p > 0 ? this.p : 1;
	}

	public void setS(int s) {
		this.s = s;
		this.pageSize = this.s >= 1 ? this.s : 10;
	}

	public void setB(int b) {
		this.b = b;
		this.blockSize = this.b >= 1 ? this.b : 10;
	}

	public void setWr_id(int wr_id) {
		this.wr_id = wr_id;
	}

}
