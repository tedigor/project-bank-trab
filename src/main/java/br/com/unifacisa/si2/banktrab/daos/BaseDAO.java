package br.com.unifacisa.si2.banktrab.daos;

import java.io.Serializable;
import java.util.List;

import br.com.unifacisa.si2.banktrab.models.EntityBase;

public interface BaseDAO <K extends Serializable,T extends EntityBase<K>>{
	
	public List<T> findAll();
	
	public T save(T entity);
	
	public T deleteById(K id);
	
	public T findById(K id);

}
