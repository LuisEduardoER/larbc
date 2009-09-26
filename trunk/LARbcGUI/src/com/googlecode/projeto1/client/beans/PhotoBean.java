package com.googlecode.projeto1.client.beans;

import java.io.Serializable;

/**
 * @author Alcione Pinheiro
 * @author Diego Rodrigues
 * @author João Felipe
 * @version LARbc 1.0
 */
public class PhotoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private long idCaso;
	private String path;
	
	public PhotoBean(){}
	
	public long getIdCaso() {
		return idCaso;
	}
	public void setIdCaso(long idCaso) {
		this.idCaso = idCaso;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
