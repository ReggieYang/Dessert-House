package model;

public class WorkingRecord {
	
	private int store_id;
	
	private int waiter_id;
	
	private String waiter_name;
	
	private String store_name;

	public int getWaiter_id() {
		return waiter_id;
	}

	public void setWaiter_id(int waiter_id) {
		this.waiter_id = waiter_id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getWaiter_name() {
		return waiter_name;
	}

	public void setWaiter_name(String waiter_name) {
		this.waiter_name = waiter_name;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

}
