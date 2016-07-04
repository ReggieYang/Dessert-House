package action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.StaffService;

public class AdminAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ApplicationContext appliationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private StaffService ss = (StaffService)(appliationContext.getBean("StaffService"));

	
	public String showStore(){
		ActionContext.getContext().getSession().put("storelist",ss.getStore() );
		
		return "success";
		
	}
	
	public String showWaiter(){
		ActionContext.getContext().getSession().put("workinglist",ss.getWaiter() );
		return "success";
		
	}
	
	
	public String deleteStore(){
		String store_id = ServletActionContext.getRequest().getParameter("store_id");
		ss.deleteStore(Integer.parseInt(store_id));
		return "success";
	}
	
	
	public String addWaiter(){
		String name = ServletActionContext.getRequest().getParameter("name");
		String type = ServletActionContext.getRequest().getParameter("type");
		ss.Register(name,type);
		return "success";
	}
	
	
	public String addStore(){
		String store_name = ServletActionContext.getRequest().getParameter("store_name");
		String store_address = ServletActionContext.getRequest().getParameter("store_address");
		ss.newStore(store_name, store_address);
		return "success";
	}
	
	public String modifyStore(){
		String store_id = ServletActionContext.getRequest().getParameter("store_id");
		String store_name = ServletActionContext.getRequest().getParameter("store_name");
		String store_address = ServletActionContext.getRequest().getParameter("store_address");
		System.out.println(store_address+"ssss");
		ss.modifyStore(Integer.parseInt(store_id),store_name, store_address);
		return "success";
	}
	
	
	public String modifyWaiter(){
		String store_id = ServletActionContext.getRequest().getParameter("store_id");
		String waiter_id = ServletActionContext.getRequest().getParameter("waiter_id");
		String type = ServletActionContext.getRequest().getParameter("type");
		ss.changeType(Integer.parseInt(waiter_id), type);
		
		String sid = ServletActionContext.getRequest().getParameter("sid");
		
		
		if(sid.equals("0")){
			ss.newWorking(Integer.parseInt(waiter_id), Integer.parseInt(store_id));
		}
		else{
		ss.changeWorkingPlace(Integer.parseInt(waiter_id), Integer.parseInt(store_id));
		}
		return "success";
	}
	
	
	public String deleteWaiter(){
		String waiter_id = ServletActionContext.getRequest().getParameter("waiter_id");
		ss.deleteWaiter(Integer.parseInt(waiter_id));
		return "success";
	}
	
	
}
