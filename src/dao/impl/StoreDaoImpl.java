package dao.impl;


import java.util.ArrayList;
import java.util.List;
import dao.StoreDao;
import model.Store;

@SuppressWarnings("rawtypes")
public class StoreDaoImpl extends BaseDaoImpl implements StoreDao {
	


	@SuppressWarnings("unchecked")
	@Override
	public void add(Store s) {
		save(s);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(int id) {
		delete(Store.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateStore(Store s) {
		update(s);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Store findById(int id) {
		return (Store)get(Store.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Store> findAll() {
		ArrayList<Store> list = new ArrayList<Store>();
		List l = findAll(Store.class);

		for(int i = 0;i < l.size();i++){
			list.add((Store)l.get(i));
		}
		return list;
		
		
	}

}
