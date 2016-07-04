package dao;

import model.BankAccount;

@SuppressWarnings("rawtypes")
public interface BankDao extends BaseDao{

	public boolean pay(int cid,double amount);
	
	public BankAccount find(int cid);

	
	public void add(BankAccount ba);
	
}
