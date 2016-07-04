package beans;

import java.util.ArrayList;
import java.util.List;

public class SalePlan_view {

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPlan_status() {
		return plan_status;
	}

	public void setPlan_status(int plan_status) {
		this.plan_status = plan_status;
	}

	public List<Commodity_view> getList() {
		return list;
	}

	public void setList(List<Commodity_view> list) {
		this.list = list;
	}


	private int plan_id;
	
	private int store_id;
	
	private String store_name;
	
	private String time;
	
	private int plan_status;
	
	private List<Commodity_view> list = new ArrayList<Commodity_view>();
	
	
}
