package dao;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface StatsDao extends BaseDao{
	
	
	
	public List customerAge();
	
	public List customerGender();
	
	public List customerAddress();
	
	public List customerValid();
	
	public List hotSale();
	
	public List hotSale(String date);
	
	public List customerSale();
	
	public List storeSale(String date);
	
	public List storeSale();
	
	public List storeReserve(String date);
	
	public List storeReserve();

}
