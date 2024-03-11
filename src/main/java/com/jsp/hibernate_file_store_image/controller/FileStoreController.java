package com.jsp.hibernate_file_store_image.controller;

import com.jsp.hibernate_file_store_image.dao.FileDao;
import com.jsp.hibernate_file_store_image.dto.FileStore;

public class FileStoreController {

	public static void main(String[] args) {
		
		FileStore fileStore = new FileStore("D:/d/resume.pdf");
		
		FileDao  dao = new FileDao();
		
		dao.saveFileStoreDao(fileStore);
	}
}
