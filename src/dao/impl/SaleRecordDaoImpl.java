package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import beans.Commodity_view;
import beans.SaleRecord_view;
import dao.SaleRecordDao;
import model.Commodity;
import model.SaleCommodity;
import model.SaleRecord;
import model.Store;

@SuppressWarnings("rawtypes")
public class SaleRecordDaoImpl extends BaseDaoImpl implements SaleRecordDao{

	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public ArrayList<SaleRecord_view> showRecord(int sale_status){

		Criteria c = getSessionFactory().getCurrentSession().createCriteria(SaleRecord.class);
		c.add(org.hibernate.criterion.Expression.eq("sale_status", sale_status));
		ArrayList<SaleRecord_view> spv = new ArrayList<SaleRecord_view>();

		List l = c.list();
		for(int i = 0;i<l.size();i++){
			SaleRecord sp = (SaleRecord)l.get(i);
			SaleRecord_view temp = new SaleRecord_view();
			temp.setSale_id(sp.getSale_id());
			temp.setSale_status(sp.getSale_status());
			temp.setStore_id(sp.getStore_id());
			Store s = (Store)getSessionFactory().getCurrentSession().get(Store.class, sp.getStore_id());
			temp.setStore_name(s.getName());
			temp.setTime(sp.getTime());
			ArrayList<Commodity_view> cvl = new ArrayList<Commodity_view>();
			List list = sp.getList();
			for(int j = 0;j < list.size();j++){
				Commodity_view cv = new Commodity_view();
				SaleCommodity sc = (SaleCommodity)list.get(j);
				Commodity co = (Commodity)getSessionFactory().getCurrentSession().get(Commodity.class, sc.getCommodity_id());
				cv.setAmount(sc.getAmount());
				cv.setId(sc.getId());
				cv.setCommodity_id(sc.getCommodity_id());
				cv.setPrice(sc.getPrice());
				cv.setName(co.getName());
				cv.setRemark(co.getRemark());
				cvl.add(cv);
			}
			temp.setList(cvl);
			spv.add(temp);
		}


		return spv;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ArrayList<SaleRecord_view> showAllRecord(int cid) {
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(SaleRecord.class);
		c.add(org.hibernate.criterion.Expression.eq("customer_id", cid));
		ArrayList<SaleRecord_view> spv = new ArrayList<SaleRecord_view>();
		List l = c.list();
		System.out.println(l.size()+"size");
		for(int i = 0;i<l.size();i++){
			SaleRecord sp = (SaleRecord)l.get(i);
			SaleRecord_view temp = new SaleRecord_view();
			temp.setSale_id(sp.getSale_id());
			temp.setSale_status(sp.getSale_status());
			temp.setStore_id(sp.getStore_id());
			Store s = (Store)getSessionFactory().getCurrentSession().get(Store.class, sp.getStore_id());
			temp.setStore_name(s.getName());
			temp.setTime(sp.getTime());
			ArrayList<Commodity_view> cvl = new ArrayList<Commodity_view>();
			List list = sp.getList();
			for(int j = 0;j < list.size();j++){
				Commodity_view cv = new Commodity_view();
				SaleCommodity sc = (SaleCommodity)list.get(j);
				Commodity co = (Commodity)getSessionFactory().getCurrentSession().get(Commodity.class, sc.getCommodity_id());
				cv.setAmount(sc.getAmount());
				cv.setId(sc.getId());
				cv.setCommodity_id(sc.getCommodity_id());
				cv.setPrice(sc.getPrice());
				cv.setName(co.getName());
				cv.setRemark(co.getRemark());
				cvl.add(cv);
			}
			temp.setList(cvl);
			spv.add(temp);
		}


		return spv;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public ArrayList<SaleRecord_view> showAllRecord2(int cid) {
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(SaleRecord.class);
		c.add(org.hibernate.criterion.Expression.eq("customer_id", cid));
		ArrayList<SaleRecord_view> spv = new ArrayList<SaleRecord_view>();
		List l = getSessionFactory().getCurrentSession().createQuery("from SaleRecord sr where sr.customer_id="+cid).list();
		System.out.println(l.size()+"siz2");
		for(int i = 0;i<l.size();i++){
			SaleRecord sp = (SaleRecord)l.get(i);
			SaleRecord_view temp = new SaleRecord_view();
			temp.setSale_id(sp.getSale_id());
			temp.setSale_status(sp.getSale_status());
			temp.setStore_id(sp.getStore_id());
			Store s = (Store)getSessionFactory().getCurrentSession().get(Store.class, sp.getStore_id());
			temp.setStore_name(s.getName());
			temp.setTime(sp.getTime());
			ArrayList<Commodity_view> cvl = new ArrayList<Commodity_view>();
			List list = sp.getList();
			for(int j = 0;j < list.size();j++){
				Commodity_view cv = new Commodity_view();
				SaleCommodity sc = (SaleCommodity)list.get(j);
				Commodity co = (Commodity)getSessionFactory().getCurrentSession().get(Commodity.class, sc.getCommodity_id());
				cv.setAmount(sc.getAmount());
				cv.setId(sc.getId());
				cv.setCommodity_id(sc.getCommodity_id());
				cv.setPrice(sc.getPrice());
				cv.setName(co.getName());
				cv.setRemark(co.getRemark());
				cvl.add(cv);
			}
			temp.setList(cvl);
			spv.add(temp);
		}


		return spv;
	}
	
}
