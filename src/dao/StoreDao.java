package dao;

import java.util.ArrayList;

import model.Store;

@SuppressWarnings("rawtypes")
public interface StoreDao extends BaseDao{

	public void add(Store s);
	
	public void delete(int id);
	
	public void updateStore(Store s);
	
	public Store findById(int id);
	
	public ArrayList<Store> findAll();
	
}
