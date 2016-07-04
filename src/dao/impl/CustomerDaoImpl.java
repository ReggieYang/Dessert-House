package dao.impl;


import java.util.List;

import dao.CustomerDao;
import model.Customer;




@SuppressWarnings("rawtypes")
public class CustomerDaoImpl extends BaseDaoImpl implements CustomerDao {



	@SuppressWarnings("unchecked")
	@Override
	public Customer find(int id) {
		return (Customer)get(Customer.class, id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public void add(Customer c) {
		save(c);
	}


	@Override
	public int getMaxId() {
		List l = find("select id from Customer c order by c.id");
		return (int)l.get(l.size()-1);
	}

}
