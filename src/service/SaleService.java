package service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.CommodityList;
import beans.Commodity_view;
import beans.SalePlan_view;
import beans.SaleRecord_view;
import dao.CommodityDao;
import dao.CustomerDao;
import dao.InventoryDao;
import dao.SalePlanDao;
import dao.SaleRecordDao;
import model.Customer;
import model.Inventory;
import model.PlanCommodity;
import model.SaleCommodity;
import model.SalePlan;
import model.SaleRecord;

public class SaleService {
	
	
	
	public SaleRecordDao getSrd() {
		return srd;
	}

	public void setSrd(SaleRecordDao srd) {
		this.srd = srd;
	}

	public SalePlanDao getSpd() {
		return spd;
	}

	public void setSpd(SalePlanDao spd) {
		this.spd = spd;
	}

	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}


	SaleRecordDao srd;
	
	SalePlanDao spd;
	
	CustomerDao cd;
	
	InventoryDao id;
	
	CommodityDao cod;
	
	public CommodityDao getCod() {
		return cod;
	}

	public void setCod(CommodityDao cod) {
		this.cod = cod;
	}

	public InventoryDao getId() {
		return id;
	}

	public void setId(InventoryDao id) {
		this.id = id;
	}

	@SuppressWarnings("unchecked")
	public void createSalePlan(int store_id, String time, ArrayList<PlanCommodity> list,int plan_id){
		SalePlan sp = new SalePlan();
		sp.setStore_id(store_id);
		sp.setTime(time);
		sp.setList(list);
		
		SalePlan sp2 = (SalePlan)spd.get(SalePlan.class, plan_id);
		if(sp2!=null){
		spd.delete(sp2);
		}
		for(int i = 0;i<list.size();i++){
			spd.save(list.get(i));
		}
		spd.save(sp);
		
	}
	
	
	public ArrayList<Commodity_view> getInventory(int sid,String time){
		return id.getInventory(sid,time);
	}
	
	
	@SuppressWarnings("unchecked")
	public void modifySalePlan(int plan_id,int store_id, String time, ArrayList<PlanCommodity> list){
		SalePlan sp = (SalePlan)spd.get(SalePlan.class, plan_id);
		sp.setStore_id(store_id);
		sp.setTime(time);
		sp.setList(list);
		
		for(int i = 0;i<list.size();i++){
			spd.save(list.get(i));
		}
		spd.save(sp);
		
	}
	
	@SuppressWarnings("unchecked")
	public void rejectSalePlan(int plan_id){
		SalePlan sp = (SalePlan)spd.get(SalePlan.class, plan_id);
		sp.setPlan_status(-1);
		spd.update(sp);
	}
	
	@SuppressWarnings("unchecked")
	public void approveSalePlan(int plan_id){
		SalePlan sp = (SalePlan)spd.get(SalePlan.class, plan_id);
		sp.setPlan_status(1);
		spd.update(sp);
		//计划生效
		int store_id = sp.getStore_id();

		spd.executehql("delete from Inventory i where i.store_id="+store_id);
		
		List<PlanCommodity> list = sp.getList();
		for(int i = 0;i<list.size();i++){
			Inventory iv = new Inventory();
			PlanCommodity temp = list.get(i);
			iv.setStore_id(store_id);
			iv.setCommodity_id(temp.getCommodity_id());
			iv.setAmount(temp.getAmount());
			iv.setPrice(temp.getPrice());
			iv.setTime(sp.getTime());
			spd.save(iv);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public String cardSale(int card_id,int store_id, Date time,ArrayList<SaleCommodity> list){
		SaleRecord sp = new SaleRecord();
		sp.setCustomer_id(card_id);
		sp.setStore_id(store_id);
		sp.setTime(time);
		sp.setList(list);
		sp.setSale_status(1);
		
		double sum = 0;
		
		for(int i = 0;i<list.size();i++){
			SaleCommodity temp = list.get(i);
			srd.save(temp);
			int cid = temp.getCommodity_id();
			int amount = temp.getAmount();
			sum = sum + amount*temp.getPrice();
			srd.executehql("update Inventory i set amount=amount-"+amount+"where i.store_id="+store_id+"and commodity_id="+cid);
		}
		srd.save(sp);
		
		Customer c = (Customer)cd.get(Customer.class, card_id);
	
		double sum_new = sum*(1-3*(double)c.getLevel()/100);
		
		if(c.getBalance()<sum_new){
			return "nobalance";
		}
	
		c.setBalance(Double.parseDouble(new DecimalFormat("#.00").format(c.getBalance()-sum_new)));
		c.setCredit(c.getCredit()+sum);
		cd.update(c);
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public void cashSale(int store_id, Date time,ArrayList<SaleCommodity> list){
		SaleRecord sp = new SaleRecord();
		sp.setCustomer_id(0);
		sp.setStore_id(store_id);
		sp.setTime(time);
		sp.setList(list);
		sp.setSale_status(1);
		
		double sum = 0;
		
		for(int i = 0;i<list.size();i++){
			SaleCommodity temp = list.get(i);
			srd.save(temp);
			int cid = temp.getCommodity_id();
			int amount = temp.getAmount();
			sum = sum + amount*temp.getPrice();
			srd.executehql("update Inventory i set amount=amount-"+amount+"where i.store_id="+store_id+"and commodity_id="+cid);
		}
		srd.update(sp);
	}
	
	@SuppressWarnings("unchecked")
	public void completeReserve(int record_id){
		SaleRecord sp = (SaleRecord)srd.get(SaleRecord.class,record_id);
		sp.setSale_status(1);
		srd.update(sp);
	}
	
	@SuppressWarnings("unchecked")
	public String createReserve(int card_id,int store_id, Date time,ArrayList<SaleCommodity> list){
		SaleRecord sp = new SaleRecord();
		sp.setCustomer_id(card_id);
		sp.setStore_id(store_id);
		sp.setTime(time);
		sp.setList(list);
		sp.setSale_status(0);
		
		double sum = 0;
		
		for(int i = 0;i<list.size();i++){
			SaleCommodity temp = list.get(i);
			srd.save(temp);
			int cid = temp.getCommodity_id();
			int amount = temp.getAmount();
			sum = sum + amount*temp.getPrice();
			srd.executehql("update Inventory i set amount=amount-"+amount+"where i.store_id="+store_id+"and commodity_id="+cid);
		}
		
		if(card_id!=0){
		
		Customer c = (Customer)cd.get(Customer.class, card_id);
	
		double sum_new = sum*(1-3*(double)c.getLevel()/100);
		BigDecimal b = new BigDecimal(sum_new);  
		sum_new = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		if(c.getBalance()<sum_new){
			return "nobalance";
		}
		
		srd.save(sp);
		
		c.setBalance(Double.parseDouble(new DecimalFormat("#.00").format(c.getBalance()-sum_new)));
		c.setCredit(c.getCredit()+sum);
		cd.update(c);
		}
		return "success";
	}
	
	
	public SalePlan_view getSalePlan(int id){
		return spd.showCertainPlan(id);
	}
	
	
	@SuppressWarnings("unchecked")
	public void cancelReserve(int record_id){
		SaleRecord sp = (SaleRecord)srd.get(SaleRecord.class, record_id);
		sp.setSale_status(-1);
		List<SaleCommodity> list = ((SaleRecord)srd.get(SaleRecord.class, record_id)).getList();
		int store_id = sp.getStore_id();
		int card_id = sp.getCustomer_id();
		
		double sum = 0;
	
		for(int i = 0;i<list.size();i++){
			SaleCommodity temp = list.get(i);
			srd.save(temp);
			int cid = temp.getCommodity_id();
			int amount = temp.getAmount();
			sum = sum + amount*temp.getPrice();
			srd.executehql("update Inventory i set amount=amount+"+amount+"where i.store_id="+store_id+"and commodity_id="+cid);
		}
		srd.update(sp);
		
		Customer c = (Customer)cd.get(Customer.class, card_id);
	
		double sum_new = sum*(1-3*(double)c.getLevel()/100);
	
		c.setBalance(Double.parseDouble(new DecimalFormat("#.00").format(c.getBalance()+sum_new)));
		
		c.setCredit(c.getCredit()-sum);
		cd.update(c);
	}
	
	
	public ArrayList<SalePlan_view> showPlan(int plan_status){
		
		return spd.showPlan(plan_status);
	}
	
	public ArrayList<SaleRecord_view> showRecord(int sale_status){
		return srd.showRecord(sale_status);
	}
	
	public ArrayList<SaleRecord_view> showAllRecord(int cid) {
		return srd.showAllRecord2(cid);
	}
	
	
	public ArrayList<SalePlan_view> showAllPlan(){
		return spd.showAllPlan();
	}
	
	public CommodityList showCommodity(){
		return cod.showAllCommodity();
	}
	
}
