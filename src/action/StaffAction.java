package action;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import beans.PayRecordList;
import beans.SalePlan_view;
import beans.SaleRecordList;
import beans.SaleRecord_view;
import enums.PasswordResult;
import service.CustomerService;
import service.SaleService;
import service.StaffService;

public class StaffAction extends ActionSupport{
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8018993663464392288L;
	ApplicationContext appliationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private StaffService ss = (StaffService)(appliationContext.getBean("StaffService"));
	private SaleService sas = (SaleService)(appliationContext.getBean("SaleService"));
	private CustomerService cs = (CustomerService)(appliationContext.getBean("CustomerService"));
	
	private int sid;
	
	private String cid;
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = Integer.parseInt(sid);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String password;
	
	private String type;
	
	
	public String setStore(){
		ActionContext.getContext().getSession().put("storelist", ss.getStore());
		return "success";
	}
	
	public String setWaiter(){
		ActionContext.getContext().getSession().put("waiterlist", ss.getWaiter());
		return "success";
	}
	
	
	public String execute() throws Exception
	{
		PasswordResult pr = ss.verify(getSid(), getPassword());	
		String result;
		
		switch(pr){
		case Admin:
			ActionContext.getContext().getSession().put("staff_name", ss.getStaff(getSid()).getName());
			setStore();
			result = "admin";
			break;
		case HeadWaiter:
			ActionContext.getContext().getSession().put("staff_name", ss.getStaff(getSid()).getName());
			ActionContext.getContext().getSession().put("staff_info", ss.getStaff(getSid()));
			ActionContext.getContext().getSession().put("cart",new SalePlan_view());
			result = "headwaiter";
			break;
		case Waiter:
			ActionContext.getContext().getSession().put("staff_info", ss.getStaff(getSid()));
			result = "waiter";
			break;
		case Manager:
			ActionContext.getContext().getSession().put("staff_name", ss.getStaff(getSid()).getName());
			ActionContext.getContext().getSession().put("staff_info", ss.getStaff(getSid()));
			result = "manager";
			break;
		
		default:
			result = "error";
		
		}
		
		
		
		ActionContext.getContext().getSession().put("staff_id", sid);

		return result;	


	}
	
	public String getCustomerInfo(){
		if(cid!=null){
			ActionContext.getContext().getSession().put("cid", cid);
			int customer_id = Integer.parseInt(cid);
			ActionContext.getContext().getSession().put("customer", cs.getInfo(customer_id));
			PayRecordList prl = new PayRecordList();
			prl.setList(cs.getPayRecord(customer_id));
			ActionContext.getContext().getSession().put("payrecord", prl);
			
			
			ArrayList<SaleRecord_view> list = sas.showAllRecord(customer_id);
			SaleRecordList srl = new SaleRecordList();
			srl.setList(list);
			ActionContext.getContext().getSession().put("salerecord", srl);

			return "success";
		}
		else{
			ActionContext.getContext().getSession().put("cid", 0);
			return "success";
		}
	}
	



	
	
}
