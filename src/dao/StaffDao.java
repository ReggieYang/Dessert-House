package dao;


import model.Staff;

@SuppressWarnings("rawtypes")
public interface StaffDao extends BaseDao{

	
	public void add(Staff s);
	
	public void delete(int id);

	public void updateStaff(Staff s);
	
	public Staff find(int id);
	
	public int getMaxId();
	
}
