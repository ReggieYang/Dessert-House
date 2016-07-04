package dao.impl;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import dao.BankDao;
import model.BankAccount;

@SuppressWarnings("rawtypes")
public class BankDaoImpl extends BaseDaoImpl implements BankDao {

	
	Configuration conf;
	SessionFactory sf;
	Session sess;
	Transaction tx;

	
	@SuppressWarnings("unchecked")
	public BankAccount find(int cid){
		return (BankAccount)get(BankAccount.class, cid);
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean pay(int cid, double amount) {
		BankAccount ba = (BankAccount)get(BankAccount.class, cid);
		ba.setBalance(ba.getBalance()-amount);
		update(ba);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(BankAccount ba) {
		save(ba);
	}

}
