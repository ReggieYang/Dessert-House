package dao.impl;


import java.util.ArrayList;
import java.util.List;
import dao.WorkingDao;
import model.Staff;
import model.Store;
import model.Working;
import model.WorkingRecord;

@SuppressWarnings("rawtypes")
public class WorkingDaoImpl extends BaseDaoImpl implements WorkingDao {
	


	@SuppressWarnings("unchecked")
	@Override
	public void add(Working w) {
		save(w);
	}

	@Override
	public void delete(int waiter_id) {
		getSessionFactory().getCurrentSession().createQuery("delete from Working w where w.waiter_id="+waiter_id).executeUpdate();
	}

	@Override
	public void updateWorking(Working w) {
//		getSessionFactory().getCurrentSession().saveOrUpdate(w);
		
		getSessionFactory().getCurrentSession().createQuery("update Working w set w.store_id="+w.getStore_id()+
				" where w.waiter_id="+w.getWaiter_id()).executeUpdate();
	}

	@Override
	public int findStore(int waiter_id) {
		List l = find("select store_id from Working w where w.waiter_id="+waiter_id);
		return (int)l.get(0);
	}
	
	
	
	
	@Override
	public ArrayList<WorkingRecord> findWaiter() {
		String sql = "SELECT s1.`name`,s1.store_id,student.sid,student.sname FROM student LEFT JOIN "+
		"(select working.store_id,working.waiter_id,store.name FROM working,store  WHERE working.store_id=store.id) as s1"+
		" ON student.sid=s1.waiter_id WHERE student.type='waiter'";	
		
		List l = getSessionFactory().getCurrentSession().createSQLQuery(sql).list();
		
		ArrayList<WorkingRecord> list = new ArrayList<WorkingRecord>();
		
		for(int i = 0;i<l.size();i++){
			Object[] temp = (Object[])l.get(i);
			WorkingRecord wr = new WorkingRecord();
			if(temp[1]!=null){
				wr.setStore_name(temp[0].toString());
				wr.setStore_id((int)temp[1]);
			}
			
			else{
				wr.setStore_id(0);
				wr.setStore_name("ÔÝÎÞ");
			}
			wr.setWaiter_id((int)temp[2]);
			wr.setWaiter_name(temp[3].toString());
			list.add(wr);
		}

		return list;
		
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public WorkingRecord findWaiterById(int id) {
			List l = find("select store_id from Working w where w.waiter_id="+id);
			int store_id = (int)l.get(0);
			Store s = (Store)get(Store.class, store_id);
			Staff st = (Staff)get(Staff.class, id);
			WorkingRecord wr = new WorkingRecord();
			wr.setWaiter_id(id);
			wr.setWaiter_name(st.getName());
			wr.setStore_id(store_id);
			wr.setStore_name(s.getName());
			return wr;
	}

	
	
	

}
