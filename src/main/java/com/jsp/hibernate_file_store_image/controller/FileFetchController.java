package com.jsp.hibernate_file_store_image.controller;

import com.jsp.hibernate_file_store_image.dao.FileDao;

public class FileFetchController {

	public static void main(String[] args) {
		
		FileDao dao = new FileDao();
		
		String msg=dao.fetchFileFromDatabaseDao(1,"D:/d/resume1.pdf");
		
		if(msg!=null) {
			System.out.println("data....fetched....");
		}else {
			System.out.println("data.......not....fetched...");
		}
	}
}
