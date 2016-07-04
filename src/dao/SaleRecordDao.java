package dao;

import java.util.ArrayList;

import beans.SaleRecord_view;

@SuppressWarnings("rawtypes")
public interface SaleRecordDao extends BaseDao{

	
	public ArrayList<SaleRecord_view> showRecord(int sale_status);
	
	
	public ArrayList<SaleRecord_view> showAllRecord(int cid);
	
	
	public ArrayList<SaleRecord_view> showAllRecord2(int cid);
}
