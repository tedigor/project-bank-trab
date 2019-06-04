package br.com.unifacisa.si2.banktrab.models;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBase<K extends Serializable> implements Serializable {

	private static final long serialVersionUID = -68651697954753660L;
	
	public abstract void setId();
	
	public abstract K getId();
	
	public abstract void setExclusaoLogica();
	
	public abstract Boolean getExclusaoLogica();
	
}