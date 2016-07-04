package dao.impl;

import java.util.ArrayList;
import java.util.List;

import beans.Commodity_view;
import dao.InventoryDao;

@SuppressWarnings("rawtypes")
public class InventoryDaoImpl extends BaseDaoImpl implements InventoryDao {

	@Override
	public ArrayList<Commodity_view> getInventory(int store_id,String time) {
		List l = getSessionFactory().getCurrentSession().createSQLQuery("select c.commodity_id,i.amount,i.price,c.name,c.remark from "
				+ "inventory i,commodity c where i.commodity_id=c.commodity_id and i.store_id="+store_id+" and time='"+time+"'").list();
		ArrayList<Commodity_view> list = new ArrayList<Commodity_view>();
		for(int i = 0;i < l.size();i++){
			Object[] temp = (Object[])l.get(i);
			Commodity_view cv = new Commodity_view();
			cv.setCommodity_id(Integer.parseInt(temp[0].toString()));
			cv.setAmount(Integer.parseInt(temp[1].toString()));
			cv.setPrice(Double.parseDouble(temp[2].toString()));
			cv.setName(temp[3].toString());
			cv.setRemark(temp[4].toString());
			list.add(cv);
			
		}
		return list;
	}

	

}
