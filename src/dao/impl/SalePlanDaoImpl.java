package dao.impl;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import beans.Commodity_view;
import beans.SalePlan_view;
import dao.SalePlanDao;
import model.Commodity;
import model.PlanCommodity;
import model.SalePlan;
import model.Store;

@SuppressWarnings("rawtypes")
public class SalePlanDaoImpl extends BaseDaoImpl implements SalePlanDao {

	
	@SuppressWarnings("deprecation")
	public ArrayList<SalePlan_view> showPlan(int plan_status){

		Criteria c = getSessionFactory().getCurrentSession().createCriteria(SalePlan.class);
		c.add(org.hibernate.criterion.Expression.eq("plan_status", plan_status));
		ArrayList<SalePlan_view> spv = new ArrayList<SalePlan_view>();

		List l = c.list();
		for(int i = 0;i<l.size();i++){
			SalePlan sp = (SalePlan)l.get(i);
			SalePlan_view temp = new SalePlan_view();
			temp.setPlan_id(sp.getPlan_id());
			temp.setPlan_status(sp.getPlan_status());
			temp.setStore_id(sp.getStore_id());
			Store s = (Store)getSessionFactory().getCurrentSession().get(Store.class, sp.getStore_id());
			temp.setStore_name(s.getName());
			temp.setTime(sp.getTime());
			ArrayList<Commodity_view> cvl = new ArrayList<Commodity_view>();
			List list = sp.getList();
			for(int j = 0;j < list.size();j++){
				Commodity_view cv = new Commodity_view();
				PlanCommodity sc = (PlanCommodity)list.get(j);
				Commodity co = (Commodity)getSessionFactory().getCurrentSession().get(Commodity.class, sc.getCommodity_id());
				cv.setAmount(sc.getAmount());
				cv.setId(sc.getId());
				cv.setCommodity_id(sc.getCommodity_id());
				cv.setPrice(sc.getPrice());
				cv.setName(co.getName());
				cvl.add(cv);
			}
			temp.setList(cvl);
			spv.add(temp);
		}


		return spv;
	}
	

	
	public ArrayList<SalePlan_view> showAllPlan(){

//		Criteria c = getSessionFactory().getCurrentSession().createCriteria(SalePlan.class);
//		c.add(org.hibernate.criterion.Expression.eq("plan_status", plan_status));
		ArrayList<SalePlan_view> spv = new ArrayList<SalePlan_view>();

		@SuppressWarnings("unchecked")
		List l = findAll(SalePlan.class);
		
//		List l = c.list();
		for(int i = 0;i<l.size();i++){
			SalePlan sp = (SalePlan)l.get(i);
			SalePlan_view temp = new SalePlan_view();
			temp.setPlan_id(sp.getPlan_id());
			temp.setPlan_status(sp.getPlan_status());
			temp.setStore_id(sp.getStore_id());
			Store s = (Store)getSessionFactory().getCurrentSession().get(Store.class, sp.getStore_id());
			temp.setStore_name(s.getName());
			temp.setTime(sp.getTime());
			ArrayList<Commodity_view> cvl = new ArrayList<Commodity_view>();
			List list = sp.getList();
			for(int j = 0;j < list.size();j++){
				Commodity_view cv = new Commodity_view();
				PlanCommodity sc = (PlanCommodity)list.get(j);
				Commodity co = (Commodity)getSessionFactory().getCurrentSession().get(Commodity.class, sc.getCommodity_id());
				cv.setAmount(sc.getAmount());
				cv.setId(sc.getId());
				cv.setCommodity_id(sc.getCommodity_id());
				cv.setPrice(sc.getPrice());
				cv.setName(co.getName());
				cvl.add(cv);
			}
			temp.setList(cvl);
			spv.add(temp);
		}


		return spv;
	}



	@SuppressWarnings("unchecked")
	@Override
	public SalePlan_view showCertainPlan(int id) {

		

			SalePlan sp = (SalePlan)get(SalePlan.class, id);
			SalePlan_view temp = new SalePlan_view();
			temp.setPlan_id(sp.getPlan_id());
			temp.setPlan_status(sp.getPlan_status());
			temp.setStore_id(sp.getStore_id());
			Store s = (Store)getSessionFactory().getCurrentSession().get(Store.class, sp.getStore_id());
			temp.setStore_name(s.getName());
			temp.setTime(sp.getTime());
			ArrayList<Commodity_view> cvl = new ArrayList<Commodity_view>();
			List list = sp.getList();
			for(int j = 0;j < list.size();j++){
				Commodity_view cv = new Commodity_view();
				PlanCommodity sc = (PlanCommodity)list.get(j);
				Commodity co = (Commodity)getSessionFactory().getCurrentSession().get(Commodity.class, sc.getCommodity_id());
				cv.setAmount(sc.getAmount());
				cv.setId(sc.getId());
				cv.setCommodity_id(sc.getCommodity_id());
				cv.setPrice(sc.getPrice());
				cv.setName(co.getName());
				cvl.add(cv);
			}
			temp.setList(cvl);

		


		return temp;
	}
	


}
