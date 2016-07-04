package beans;

import java.util.ArrayList;

import beans.SalePlan_view;

public class SalePlanList {
	/**
	 * 
	 */

	private ArrayList<SalePlan_view> list;
	
	
	public ArrayList<SalePlan_view> getList() {
		return list;
	}
	public void setList(ArrayList<SalePlan_view> list) {
		this.list = list;
	}
	
	public void setList(SalePlan_view s, int i) {
		list.set(i, s);
		}
	
	public SalePlan_view getList(int index) {
		return (SalePlan_view)list.get(index);
	}
}
