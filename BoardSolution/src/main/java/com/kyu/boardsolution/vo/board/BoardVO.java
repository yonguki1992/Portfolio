package com.kyu.boardsolution.vo.board;

import java.util.StringTokenizer;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class BoardVO {
	private String	bo_table;
	private String	gr_id;
	private String	bo_subject;
	private String	bo_mobile_subject;
	private String	bo_device;
	private String	bo_admin;
	private int		bo_list_level;
	private int		bo_read_level;
	private int		bo_write_level;
	private int		bo_reply_level;
	private int		bo_comment_level;
	private int		bo_upload_level;
	private int		bo_download_level;
	private int		bo_html_level;
	private int		bo_link_level;
	private int		bo_count_delete;
	private int		bo_count_modifiy;
	private int		bo_read_point;
	private int		bo_write_point;
	private int		bo_comment_point;
	private int		bo_download_point;
	private int		bo_use_category;
	private String	bo_category_list;	//|`| 로 구분함
	private int		bo_use_sideview;
	private int		bo_use_file_content;	// 파일 설명 사용
	private int		bo_use_secret;
	private int		bo_use_dhtml_editor;
	private int		bo_use_rss_view;
	private int		bo_use_good;
	private int		bo_use_nogood;
	private int		bo_use_name;
	private int		bo_use_signature;
	private int		bo_use_ip_view;
	private int		bo_use_list_view;
	private int		bo_use_list_file;
	private int		bo_use_list_content;
	private int		bo_table_width;
	private int		bo_subject_len;
	private int		bo_mobile_subject_len;
	private int		bo_page_rows;
	private int		bo_mobile_page_rows;
	private int		bo_new;
	private int		bo_hot;
	private int		bo_image_width;
	private String	bo_skin;
	private String	bo_mobile_skin;
	private String	bo_include_head;
	private String	bo_include_tail;
	private String	bo_content_head;
	private String	bo_mobile_content_head;
	private String	bo_content_tail;
	private String	bo_mobile_content_tail;
	private String	bo_insert_content;
	private int		bo_gallery_cols;	
	private int		bo_gallery_width;
	private int		bo_gallery_height;
	private int		bo_mobile_gallery_width;
	private int		bo_mobile_gallery_height;
	private int		bo_upload_size;
	private int		bo_reply_order;
	private int		bo_use_search;
	private int		bo_order;
	private int		bo_count_write;
	private int		bo_count_comment;
	private int		bo_write_min;
	private int		bo_write_max;
	private int		bo_comment_min;
	private int		bo_comment_max;
	private String	bo_notice;			//|`| 로 구분
	private int		bo_upload_count;
	private int		bo_use_email;
	private String	bo_use_cert;		//본인확인 사용
	private int		bo_use_sns;
	private String	bo_sort_field;
	
	
	private String[] bo_category_list_items;
	private String[] bo_notice_items;
	
	//문자열을 배열로
	public void str2Array() {
		StringTokenizer st1 = new StringTokenizer(bo_category_list,"|`|");
		bo_category_list_items= new String[st1.countTokens()];
		
		int cnt = 0;
		while(st1.hasMoreTokens()) {
			bo_category_list_items[cnt++] = st1.nextToken();
		}
		
		
		StringTokenizer st2 = new StringTokenizer(bo_notice,"|`|");
		bo_notice_items = new String[st2.countTokens()];
		
		cnt = 0;
		while(st2.hasMoreTokens()) {
			bo_notice_items[cnt++] = st2.nextToken();
		}
	}
	
	public String[] str2Array(String item) {
		StringTokenizer st1 = new StringTokenizer(item,"|`|");
		String[] items= new String[st1.countTokens()];
		
		int cnt = 0;
		while(st1.hasMoreTokens()) {
			items[cnt++] = st1.nextToken();
		}
		return items;
	}
	
	public void array2Str() {
		StringBuffer sb1 = new StringBuffer();
		
		for(int i = 0; i<bo_category_list_items.length; ++i) {
			sb1.append(bo_category_list_items[i].trim());
			if(i != bo_category_list_items.length-1) {
				sb1.append("|`|");
			}
		}
		bo_category_list = sb1.toString();
		
		StringBuffer sb2 = new StringBuffer();
		
		for(int i = 0; i<bo_notice_items.length; ++i) {
			sb2.append(bo_notice_items[i].trim());
			if(i != bo_notice_items.length-1) {
				sb2.append("|`|");
			}
		}
		bo_category_list = sb2.toString();
	}
	
	public String array2Str(String[] items) {
		StringBuffer sb1 = new StringBuffer();
		
		for(int i = 0; i<items.length; ++i) {
			sb1.append(items[i].trim());
			if(i != items.length-1) {
				sb1.append("|`|");
			}
		}
		return sb1.toString();
	}
	
	public void setBo_notice(String bo_notice) {
		this.bo_notice = bo_notice;
		this.bo_notice_items = str2Array(bo_notice);
	}
	
	public void setBo_category_list(String bo_category_list) {
		this.bo_category_list = bo_category_list;
		this.bo_category_list_items = str2Array(bo_category_list);
	}

	public void setBo_category_list_items(String[] bo_category_list_items) {
		this.bo_category_list_items = bo_category_list_items;
		bo_category_list = array2Str(bo_category_list_items);
	}

	public void setBo_notice_items(String[] bo_notice_items) {
		this.bo_notice_items = bo_notice_items;
		this.bo_notice = array2Str(bo_notice_items);
	}


	//여분 필드
	private String	bo_1_subj;
	private String	bo_2_subj;
	private String	bo_3_subj;
	private String	bo_4_subj;
	private String	bo_5_subj;
	private String	bo_6_subj;
	private String	bo_7_subj;
	private String	bo_8_subj;
	private String	bo_9_subj;
	private String	bo_10_subj;
	
	private String	bo_1;
	private String	bo_2;
	private String	bo_3;
	private String	bo_4;
	private String	bo_5;
	private String	bo_6;
	private String	bo_7;
	private String	bo_8;
	private String	bo_9;
	private String	bo_10;
	
}
