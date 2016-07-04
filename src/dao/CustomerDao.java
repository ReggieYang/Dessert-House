package dao;

import model.Customer;

@SuppressWarnings("rawtypes")
public interface CustomerDao extends BaseDao{
	
	public Customer find(int id);
		
	public void add(Customer c);
	
	public int getMaxId();
}
