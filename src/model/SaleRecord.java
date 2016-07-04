package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="salerecord")
public class SaleRecord {
	

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	
	public List<SaleCommodity> getList() {
		return list;
	}

	public void setList(List<SaleCommodity> list) {
		this.list = list;
	}


	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sale_id;
	
	private int store_id;
	
	private Date time;
	
	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
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


	private int sale_status;
	
	private int customer_id;
	
	@OneToMany(targetEntity=SaleCommodity.class,fetch=FetchType.EAGER)

	@JoinColumn(name="sale_id" , referencedColumnName="sale_id")
	private List<SaleCommodity> list = new ArrayList<SaleCommodity>();
	

}
