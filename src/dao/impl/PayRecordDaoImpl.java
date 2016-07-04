package dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import dao.PayRecordDao;
import model.PayRecord;

@SuppressWarnings("rawtypes")
public class PayRecordDaoImpl extends BaseDaoImpl implements PayRecordDao {
	

	
	@SuppressWarnings("unchecked")
	@Override
	public void add(PayRecord pr) {
		save(pr);
	}

	@SuppressWarnings({ "deprecation" })
	@Override
	public ArrayList<PayRecord> find(int customer_id) {
			ArrayList<PayRecord> list = new ArrayList<PayRecord>();
			Criteria c = getSessionFactory().getCurrentSession().createCriteria(PayRecord.class);
			c.add(org.hibernate.criterion.Expression.eq("customer_id", customer_id));
			List l = c.list();

			for(int i = 0;i < l.size();i++){
				list.add((PayRecord)l.get(i));
			}
			return list;


	}

}
