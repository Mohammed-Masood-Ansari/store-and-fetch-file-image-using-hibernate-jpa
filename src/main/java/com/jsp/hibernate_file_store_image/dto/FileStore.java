package com.jsp.hibernate_file_store_image.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileStore implements Serializable {

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Transient
	private String name;
	
	@Lob
	private byte[] file;

	public FileStore(String name) {
		super();
		this.name = name;
	}
}
