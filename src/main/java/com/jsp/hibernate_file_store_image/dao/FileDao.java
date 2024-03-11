package com.jsp.hibernate_file_store_image.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate_file_store_image.dto.FileStore;

public class FileDao {

	EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	EntityTransaction et = em.getTransaction();

	public FileStore saveFileStoreDao(FileStore fileStore) {

		/**
		 * read the file path
		 */
		Path filePath = Path.of(fileStore.getName());

		try {
			byte[] fileBytes = Files.readAllBytes(filePath);

			fileStore.setFile(fileBytes);

			et.begin();
			em.persist(fileStore);
			et.commit();

			return fileStore;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileStore;
	}
	
	public String fetchFileFromDatabaseDao(int id,String filePath) {
		
		FileStore fileStore = em.find(FileStore.class,id);
		
		if(fileStore!=null) {
			et.begin();
			byte[] fileData = fileStore.getFile();
			
			if(fileData!=null) {
				
				try(FileOutputStream  fileOutputStream = new FileOutputStream(filePath)){
					fileOutputStream.write(fileData);
					return filePath;
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			et.commit();
		}
		return null;
	}
}
