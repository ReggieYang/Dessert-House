package action;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import beans.Commodity_view;
import beans.SalePlanList;
import beans.SalePlan_view;

import model.PlanCommodity;
import service.SaleService;
import service.StaffService;

public class HeadWaiterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3548929667008232272L;
	
	
	ApplicationContext appliationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private StaffService ss = (StaffService)(appliationContext.getBean("StaffService"));
	private SaleService sas = (SaleService)(appliationContext.getBean("SaleService"));
	
	
	public double getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = Double.parseDouble(price);
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = Integer.parseInt(amount);
	}


	public int getCommodity_id() {
		return commodity_id;
	}


	public void setCommodity_id(String commodity_id) {
		this.commodity_id = Integer.parseInt(commodity_id);
	}

	private double price;
	
	
	private int amount;
	
	private int commodity_id;
	
	private String cname;
	
	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String showSalePlan(){
		SalePlanList spl = new SalePlanList();
		spl.setList(sas.showAllPlan());
		ActionContext.getContext().getSession().put("saleplan", spl);
		return "success";
		
	}
	
	
	public String showCommodity(){
		ActionContext.getContext().getSession().put("comlist", sas.showCommodity());
		ActionContext.getContext().getSession().put("storelist", ss.getStore());
		return "success";
	}
	

	public String addtoPlan(){
		
		SalePlan_view sv = (SalePlan_view)ActionContext.getContext().getSession().get("cart");
		boolean isExistCommodity = false;
		int i = 0;
		
		if(sv==null){
			sv = new SalePlan_view();
		}
		
		
		for (; i < sv.getList().size(); i++) {
			if(sv.getList().get(i).getCommodity_id()==getCommodity_id()){
				isExistCommodity = true;
				break;
			}
		}
		
		if(isExistCommodity){
			Commodity_view cv = sv.getList().get(i);
			cv.setAmount(cv.getAmount()+(int)getAmount());
			sv.getList().set(i, cv);
		}
		
		else{
		
		Commodity_view cv = new Commodity_view();
		cv.setName(cname);
		cv.setCommodity_id(getCommodity_id());
		cv.setAmount(getAmount());
		cv.setPrice(getPrice());
		sv.getList().add(cv);
		}
		
		ActionContext.getContext().getSession().put("cart", sv);
		
		return "success";
		
	}

	public String submitPlan(){
		SalePlan_view sv = (SalePlan_view)ActionContext.getContext().getSession().get("cart");
		
		List<Commodity_view> temp = sv.getList();
		ArrayList<PlanCommodity> list = new ArrayList<PlanCommodity>();
		for(int i=0;i<temp.size();i++){
			PlanCommodity c = new PlanCommodity();
			c.setCommodity_id(temp.get(i).getCommodity_id());
			c.setAmount(temp.get(i).getAmount());
			c.setPrice(temp.get(i).getPrice());
			list.add(c);
		}
		
		
		String time = ServletActionContext.getRequest().getParameter("time");
		String store_id = ServletActionContext.getRequest().getParameter("store_id");
		
		sas.createSalePlan(Integer.parseInt(store_id), time, list,sv.getPlan_id());
		ActionContext.getContext().getSession().put("cart", new SalePlan_view());
		return "success";
	}
	
	public String deleteCommodity(){
		SalePlan_view sv = (SalePlan_view)ActionContext.getContext().getSession().get("cart");
	
		for (int i=0; i < sv.getList().size(); i++) {
			if(sv.getList().get(i).getCommodity_id()==commodity_id){
				sv.getList().remove(i);
				break;
			}
		}
		
		ActionContext.getContext().getSession().put("cart", sv);
		
		return "success";
		
	}
	
	
	
	public String loadPlan(){
		String plan_id = ServletActionContext.getRequest().getParameter("plan_id");
		SalePlan_view sp = sas.getSalePlan(Integer.parseInt(plan_id));
		ActionContext.getContext().getSession().put("cart", sp);
		return "success";
	}
//	
//	public String payforCart(){
//		
//		ArrayList<SaleCommodity> list = new ArrayList<SaleCommodity>();
//		
//		SaleRecord_view sv = (SaleRecord_view)ActionContext.getContext().getSession().get("cart");
//		for(int i=0;i<sv.getList().size();i++){
//			SaleCommodity sc = new SaleCommodity();
//			Commodity_view cv = sv.getList().get(i);
//			sc.setPrice(cv.getPrice());
//			sc.setCommodity_id(cv.getCommodity_id());
//			sc.setAmount(cv.getAmount());
//			list.add(sc);
//			
//		}
//		
//		String result =  ss.createReserve(Integer.parseInt(ActionContext.getContext().getSession().get("id").toString()), 
//				Integer.parseInt(ActionContext.getContext().getSession().get("store_id").toString()), new Date(), list);
//		
//		if(result.equals("success")){
//			ActionContext.getContext().getSession().put("cart", new SaleRecord_view());
//		}
//		
//		return result;
//		
//	}

}
