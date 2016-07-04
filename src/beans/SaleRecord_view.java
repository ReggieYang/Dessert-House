package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleRecord_view {



		public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getSale_status() {
		return sale_status;
	}

	public void setSale_status(int sale_status) {
		this.sale_status = sale_status;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public List<Commodity_view> getList() {
		return list;
	}

	public void setList(List<Commodity_view> list) {
		this.list = list;
	}

		private int sale_id;
		
		private int store_id;
		
		private String store_name;
		
		private Date time;
		
		private int sale_status;
		
		private int customer_id;
		
		private List<Commodity_view> list = new ArrayList<Commodity_view>();
		

	
	
	
}
