package com.kyu.boardsolution.vo.write;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class WriteBoardVO {
	private int		wr_id;				//게시글 고유번호
	private int		wr_num;				//게시글 정렬 번호
	private String	wr_reply;			//글답변
	private int		wr_parent;			//원 글번호
	private int		wr_is_comment;		//댓글 있는지
	private int		wr_comment;			//댓글 수
	private String	wr_comment_reply;	//댓글 답변
	private String	ca_name;			//분류(category)
	private String	wr_option;			//게시글 옵션(html1/html2/secret/mail:0/0/0/0)
	private String	wr_subject;			//글 제목
	private String	wr_content;			//글 내용
	private String	wr_link1;			//글 작성시 들어가는 링크1
	private String	wr_link2;			//링크2
	private int		wr_link1_hit;		//링크1의 조회수
	private int		wr_link2_hit;		//링크2의 조회수
	private int		wr_hit;				//조회수
	private int		wr_good;			//추천수
	private int		wr_nogood;			//비추수
	private String	mb_id;				//작성자(회원) 아이디(=이메일)
	private String	wr_password;		//작성자 비번()
	private String	wr_name;			//작성자(닉네임과 같음)
	private String	wr_email;			//이메일
	private String	wr_homepage;		//homepage
	private Date	wr_datetime;		//글 작성일시
	private int		wr_file;			//파일 첨부 여부(0 : false, 1 : true)
	private String	wr_last;			//게시글 마지막 수정 시간
	private String	wr_ip;				//글 등록 ip
	private String	wr_facebook_user;	//facebook 계정(사용안함)
	private String	wr_twitter_user;	//twitter 계정(사용안할예정)
	private String	wr_1;				//여분필드
	private String	wr_2;				//여분필드
	private String	wr_3;				//여분필드
	private String	wr_4;				//여분필드
	private String	wr_5;				//여분필드
	private String	wr_6;				//여분필드
	private String	wr_7;				//여분필드
	private String	wr_8;				//여분필드
	private String	wr_9;				//여분필드
	private String	wr_10;				//여분필드
}


/*
CREATE TABLE "write_notice" (
"wr_id"	int		NOT NULL,	
"wr_num"	int	DEFAULT 0	NOT NULL,
"wr_reply"	varchar(10)		NOT NULL,
"wr_parent"	int	DEFAULT 0	NOT NULL,
"wr_is_comment"	int		NOT NULL,
"wr_comment"	int		NOT NULL,
"wr_comment_reply"	varchar(5)		NOT NULL,
"ca_name"	varchar(255)		NOT NULL,
"wr_option"	varchar2(4) DEFAULT '0000'	NOT NULL,
"wr_subject"	varchar(255)		NOT NULL,
"wr_content"	varchar(20)		NOT NULL,
"wr_link1"	varchar(20)		NOT NULL,
"wr_link2"	varchar(20)		NOT NULL,
"wr_link1_hit"	int	DEFAULT 0	NOT NULL,
"wr_link2_hit"	int	DEFAULT 0	NOT NULL,
"wr_hit"	int	DEFAULT 0	NOT NULL,
"wr_good"	int	DEFAULT 0	NOT NULL,
"wr_nogood"	int	DEFAULT 0	NOT NULL,
"mb_id"	varchar(20)		NOT NULL,
"wr_password"	varchar(255)		NOT NULL,
"wr_name"	varchar(255)		NOT NULL,
"wr_email"	varchar(255)		NOT NULL,
"wr_homepage"	varchar(255)		NOT NULL,
"wr_datetime"	timestamp		NOT NULL,
"wr_file"	int	DEFAULT 0	NOT NULL,
"wr_last"	varchar(19)		NOT NULL,
"wr_ip"	varchar(255)		NOT NULL,
"wr_facebook_user"	varchar(255)		NOT NULL,
"wr_twitter_user"	varchar(255)		NOT NULL,
"wr_1"	varchar(255)		NOT NULL,
"wr_2"	varchar(255)		NOT NULL,
"wr_3"	varchar(255)		NOT NULL,
"wr_4"	varchar(255)		NOT NULL,
"wr_5"	varchar(255)		NOT NULL,
"wr_6"	varchar(255)		NOT NULL,
"wr_7"	varchar(255)		NOT NULL,
"wr_8"	varchar(255)		NOT NULL,
"wr_9"	varchar(255)		NOT NULL,
"wr_10"	varchar(255)		NOT NULL
);
*/