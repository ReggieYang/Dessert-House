package dao;

import java.util.ArrayList;

import model.PayRecord;

@SuppressWarnings("rawtypes")
public interface PayRecordDao extends BaseDao{
	public void add(PayRecord pr);
	
	public ArrayList<PayRecord> find(int customer_id);
}
