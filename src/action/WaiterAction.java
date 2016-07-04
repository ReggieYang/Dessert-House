package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import beans.Commodity_view;
import beans.PayRecordList;
import beans.SaleRecordList;
import beans.SaleRecord_view;
import model.Customer;
import model.PayRecord;
import model.SaleCommodity;
import model.WorkingRecord;
import service.CustomerService;
import service.SaleService;
import service.StaffService;

public class WaiterAction extends ActionSupport{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ApplicationContext appliationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private StaffService ss = (StaffService)(appliationContext.getBean("StaffService"));
	private SaleService sas = (SaleService)(appliationContext.getBean("SaleService"));
	private CustomerService cs = (CustomerService)(appliationContext.getBean("CustomerService"));
	
	
	
	public String showCommodity(){
		String staff_id = ActionContext.getContext().getSession().get("staff_id").toString();
		WorkingRecord wr = ss.getWaiterInfo(Integer.parseInt(staff_id));
		int store_id = wr.getStore_id();
		ActionContext.getContext().getSession().put("staff_name", wr.getWaiter_name());
		ActionContext.getContext().getSession().put("store_id", store_id);
		ActionContext.getContext().getSession().put("store_name", wr.getStore_name());
		ActionContext.getContext().getSession().put("commodity_list", sas.getInventory(store_id,new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		ActionContext.getContext().getSession().put("cart", new SaleRecord_view());
		return "success";
	}
	
	
	
	
	public String addCart(){

		SaleRecord_view sv = (SaleRecord_view)ActionContext.getContext().getSession().get("cart");
		sv.setStore_id(Integer.parseInt(ActionContext.getContext().getSession().get("store_id").toString()));
		sv.setStore_name(ActionContext.getContext().getSession().get("store_name").toString());
//		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
//		sv.setCustomer_id(customer_id);
		
		
		boolean isExistCommodity = false;
		int i = 0;

		for (; i < sv.getList().size(); i++) {
			if(sv.getList().get(i).getCommodity_id()==Integer.parseInt(getCommodity_id())){
				isExistCommodity = true;
				break;
			}
		}
		
		if(isExistCommodity){
			Commodity_view cv = sv.getList().get(i);
			cv.setAmount(cv.getAmount()+Integer.parseInt(amount));
			sv.getList().set(i, cv);
		}
		
		else{
		
		Commodity_view cv = new Commodity_view();
		cv.setName(cname);
		cv.setCommodity_id(Integer.parseInt(getCommodity_id()));
		cv.setAmount(Integer.parseInt(getAmount()));
		cv.setPrice(Double.parseDouble(getPrice()));
		sv.getList().add(cv);
		}
		
		ActionContext.getContext().getSession().put("cart", sv);
		
		return "success";
		
	}
	
	
	
	public String changeWaiterInfo(){
		String staff_id = ActionContext.getContext().getSession().get("staff_id").toString();
		ss.changeStaff(Integer.parseInt(staff_id), name, password);
		ActionContext.getContext().getSession().put("staff_info", ss.getStaff(Integer.parseInt(staff_id)));
		ActionContext.getContext().getSession().put("staff_name", name);
		return "success";
		
	}
	
	public String getCommodity_id() {
		return commodity_id;
	}




	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}




	public String getPrice() {
		return price;
	}




	public void setPrice(String price) {
		this.price = price;
	}




	public String getAmount() {
		return amount;
	}




	public void setAmount(String amount) {
		this.amount = amount;
	}




	public String getCname() {
		return cname;
	}




	public void setCname(String cname) {
		this.cname = cname;
	}

	private String commodity_id;
	
	private String price;
	
	private String amount;
	
	private String cname;
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}

	private String name;
	
	private String password;
	
	private String customer_id;
	
	public String deleteCommodityfromCart(){
		
		SaleRecord_view sv = (SaleRecord_view)ActionContext.getContext().getSession().get("cart");
		sv.setStore_id(Integer.parseInt(ActionContext.getContext().getSession().get("store_id").toString()));
		sv.setStore_name(ActionContext.getContext().getSession().get("store_name").toString());
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		sv.setCustomer_id(customer_id);
//
//		
		
		commodity_id = ServletActionContext.getRequest().getParameter("cid").toString();
//		int i = 0;
//
		for (int i=0; i < sv.getList().size(); i++) {
			if(sv.getList().get(i).getCommodity_id()==Integer.parseInt(getCommodity_id())){
				sv.getList().remove(i);
				break;
			}
		}
		
		ActionContext.getContext().getSession().put("cart", sv);
		
		return "success";
		
	}
	
	public String payforCart(){
		
		ArrayList<SaleCommodity> list = new ArrayList<SaleCommodity>();
		
		SaleRecord_view sv = (SaleRecord_view)ActionContext.getContext().getSession().get("cart");
		for(int i=0;i<sv.getList().size();i++){
			SaleCommodity sc = new SaleCommodity();
			Commodity_view cv = sv.getList().get(i);
			sc.setPrice(cv.getPrice());
			sc.setCommodity_id(cv.getCommodity_id());
			sc.setAmount(cv.getAmount());
			list.add(sc);
			
		}
		
		
		if(customer_id.equals("0")){
			sas.cashSale(Integer.parseInt(ActionContext.getContext().getSession().get("store_id").toString()), new Date(), list);
			ActionContext.getContext().getSession().put("cart", new SaleRecord_view());
			return "success";
		}
		
		else{
		String result =  sas.cardSale(Integer.parseInt(customer_id), 
				Integer.parseInt(ActionContext.getContext().getSession().get("store_id").toString()), new Date(), list);
		
		
		
		
		if(result.equals("success")){
			ActionContext.getContext().getSession().put("cart", new SaleRecord_view());
		}
		
		return result;
		
		}
		
	}

	
	
	public String getCustomerInfo(){
		if(customer_id!=null){
		Customer c = cs.getInfo(Integer.parseInt(customer_id));
		ActionContext.getContext().getSession().put("customer_info", c);
//		if(c.equals(null)){
//			return "nonexist";
//		}
	}
		
		else{
			ActionContext.getContext().getSession().put("customer_info", null);
		}
		return "success";
	}


	public String getPayRecord(){
		if(customer_id!=null){
		ArrayList<PayRecord> list = cs.getPayRecord(Integer.parseInt(customer_id));
		//ArrayList<PayRecord> list = cs.getPayRecord(1000001);
		if(list==null){
			return "nonexist";
		}
		PayRecordList prl = new PayRecordList();
		prl.setList(list);
		ActionContext.getContext().getSession().put("payrecord", prl);
//		if(list.equals(null)){
//			return "nonexist";
//		}
		}
		return "success";
	}
	
	public String confirmReserve(){
		String rid = ServletActionContext.getRequest().getParameter("rid");
		sas.completeReserve(Integer.parseInt(rid));
		customer_id = ServletActionContext.getRequest().getParameter("cid");
		ArrayList<SaleRecord_view> list = new ArrayList<SaleRecord_view>();
		SaleRecordList srl = new SaleRecordList();
		srl.setList(list);
		ActionContext.getContext().getSession().put("salerecord", srl);
		return "success";
	}
	
	
	

	
	public String getSaleRecord(){
		if(customer_id!=null){
		ArrayList<SaleRecord_view> list = sas.showAllRecord(Integer.parseInt(customer_id));
		if(list==null){
			return "nonexist";
		}
		SaleRecordList srl = new SaleRecordList();
		srl.setList(list);
		ActionContext.getContext().getSession().put("salerecord", srl);
//		if(list.equals(null)){
//			return "nonexist";
//		}
		}
		return "success";
	}

	public String getCustomer_id() {
		return customer_id;
	}




	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	
}
