package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import beans.SalePlanList;
import service.SaleService;
import service.StatsService;

public class ManagerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4871629575446991018L;
	
	
	private String month;
	
	
	private int plan_id;
	
	
	
	public int getPlan_id() {
		return plan_id;
	}


	public void setPlan_id(String plan_id) {
		this.plan_id = Integer.parseInt(plan_id);
	}




	ApplicationContext appliationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private StatsService ss = (StatsService)(appliationContext.getBean("StatsService"));
	private SaleService sas = (SaleService)(appliationContext.getBean("SaleService"));

	
	
	
	public String showPlan(){
		SalePlanList spl = new SalePlanList();
		spl.setList(sas.showAllPlan());
		ActionContext.getContext().getSession().put("saleplan", spl);
		return "success";
	}
	
	
	public String approvePlan(){
		sas.approveSalePlan(plan_id);
		return "success";
		
	}

	
	
	public String rejectPlan(){
		sas.rejectSalePlan(plan_id);
		return "success";
	}
	
	
	
	
	public String showStat(){
		ActionContext.getContext().getSession().put("gender", ss.customerGender());
		ActionContext.getContext().getSession().put("valid",ss.customerValid());
		ActionContext.getContext().getSession().put("address",ss.customerAddress());
		ActionContext.getContext().getSession().put("age",ss.customerAge());
		ActionContext.getContext().getSession().put("sale",ss.storeSale());
		ActionContext.getContext().getSession().put("reserve",ss.storeReserve());
		ActionContext.getContext().getSession().put("customersale",ss.customerSale());
		ActionContext.getContext().getSession().put("hot",ss.hotSale());
		
		return "success";
	}
	
	public String showStata(){
		
		if(month!=null){
			ActionContext.getContext().getSession().put("hotd",ss.hotSale(month));
			ActionContext.getContext().getSession().put("reserved",ss.storeReserve(month));
			ActionContext.getContext().getSession().put("saled",ss.storeSale(month));
		}

		else{
			ActionContext.getContext().getSession().put("saled",ss.storeSale());
			ActionContext.getContext().getSession().put("reserved",ss.storeReserve());
			ActionContext.getContext().getSession().put("hotd",ss.hotSale());
		}
		
		return "success";
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}
	
	
}
