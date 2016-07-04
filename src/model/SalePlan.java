package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="saleplan")
public class SalePlan {
	
	
	
	
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	public List<PlanCommodity> getList() {
		return list;
	}

	public void setList(List<PlanCommodity> list) {
		this.list = list;
	}


	public int getPlan_status() {
		return plan_status;
	}

	public void setPlan_status(int plan_status) {
		this.plan_status = plan_status;
	}


	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int plan_id;
	
	private int store_id;
	
	private String time;
	
	@Column(nullable=false,columnDefinition="INT default 0")
	private int plan_status;
	
	@OneToMany(targetEntity=PlanCommodity.class,fetch=FetchType.EAGER)

	@JoinColumn(name="plan_id" , referencedColumnName="plan_id")
	private List<PlanCommodity> list = new ArrayList<PlanCommodity>();
	

}
