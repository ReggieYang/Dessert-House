package dao;

import java.util.ArrayList;

import model.Working;
import model.WorkingRecord;



@SuppressWarnings("rawtypes")
public interface WorkingDao extends BaseDao{

	public void add(Working w);
	
	public void delete(int waiter_id);
	
	public int findStore(int waiter_id);
	
	public ArrayList<WorkingRecord> findWaiter();
	
	public void updateWorking(Working w);
	
	public WorkingRecord findWaiterById(int id);
}
