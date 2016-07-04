package dao.impl;


import java.util.List;
import dao.StaffDao;

import model.Staff;

@SuppressWarnings("rawtypes")
public class StaffDaoImpl extends BaseDaoImpl implements StaffDao {
	

	int firstID = 131250199;
	

	


	@SuppressWarnings("unchecked")
	@Override
	public void add(Staff s) {
		save(s);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(int id) {
		delete(Staff.class,id);
	}

	@Override
	public void updateStaff(Staff s) {
		
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public Staff find(int id) {
		return (Staff)get(Staff.class, id);
	}


	@Override
	public int getMaxId() {
		List l = find("select sid from Staff s order by s.sid");
		return (int)l.get(l.size()-1);
	}

}
