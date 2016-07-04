package dao;

import java.util.ArrayList;

import beans.SalePlan_view;

@SuppressWarnings("rawtypes")
public interface SalePlanDao extends BaseDao{

	public ArrayList<SalePlan_view> showPlan(int plan_status);
	
	public ArrayList<SalePlan_view> showAllPlan();
	
	public SalePlan_view showCertainPlan(int id);
	
}
