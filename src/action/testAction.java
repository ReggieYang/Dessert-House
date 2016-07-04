package action;



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
import enums.PasswordResult;
import model.Customer;
import model.SaleCommodity;
import service.CustomerService;
import service.PayService;
import service.SaleService;
import service.StaffService;


public class testAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6896743704148376054L;

	// 定义封装请求参数的username和password成员变量
	private String id;
	
	private String time;
	
	
	private String password;
	private String name;
	ApplicationContext appliationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//	ApplicationContext appliationContext;
	private CustomerService cs = (CustomerService)(appliationContext.getBean("CustomerService"));
	private PayService ps = (PayService)(appliationContext.getBean("PayService"));
	private SaleService ss = (SaleService)(appliationContext.getBean("SaleService"));
	private StaffService sts = (StaffService)(appliationContext.getBean("StaffService"));
	private int cid;
	private double amount;
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	private String gender;
	private String age;
	private String address;
	
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	private String store_id;
	
	private String commodity_id;
	
	
	private String cname;
	
	private String price;
	
	private String sid;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = Integer.parseInt(cid);
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = Double.parseDouble(amount);
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getName() {
		return name;
		//return cs.getInfo(Integer.parseInt(ActionContext.getContext().getSession().get("id").toString())).getName();
	}
	public void setName(String name) {
		this.name = name;
	}
	// 定义处理用户请求的execute方法
	public String execute() throws Exception
	{
		PasswordResult pr = cs.verify(Integer.parseInt(getId()), getPassword());
		if(pr.equals(PasswordResult.Valid)){
			ActionContext.getContext().getSession().put("id", getId());
			ActionContext.getContext().getSession().put("error", null);
			ActionContext.getContext().getSession().put("cart", new SaleRecord_view());
			ActionContext.getContext().getSession().put("store_id", 1);
			return "success";
			
		}
		else {
				
			ActionContext.getContext().getSession().put("error", "error");
			return "error";}
	}
	
	public String modifyPersonalInfo(){
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		cs.modifyInfo(customer_id, getName(), getPassword(),getAge(),getAddress(),getGender());
		ActionContext.getContext().getSession().put("cname",getName());
		ActionContext.getContext().getSession().put("customer",cs.getInfo(customer_id));
		return "success";
	}
	
	public String getPayRecord(){
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		PayRecordList prl = new PayRecordList();
		prl.setList(cs.getPayRecord(customer_id));
		ActionContext.getContext().getSession().put("payrecord", prl);
		return "success";
	}
	
	public String pay(){
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		ps.pay(customer_id, getCid(), getAmount());
		ActionContext.getContext().getSession().put("payresult", "支付成功！");
		return "success";
	}
	
	public String setRegister(){
		ActionContext.getContext().getSession().put("currentid", cs.getCurrentId());
		return "success";
	}
	
	public String register(){
		
		ActionContext.getContext().getSession().put("id", cs.Register(getName(), getPassword(),getAddress(),getAge(),getGender()));
		ActionContext.getContext().getSession().put("error", null);
		return "success";
	}
	
	public String getSaleRecord(){
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		ArrayList<SaleRecord_view> list = ss.showAllRecord(customer_id);
		SaleRecordList srl = new SaleRecordList();
		srl.setList(list);
		ActionContext.getContext().getSession().put("salerecord", srl);
		return "success";
	}
	
	public String getCardInfo(){
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		Customer c = cs.getInfo(customer_id);
		if(ActionContext.getContext().getSession().get("cart")==null){
			ActionContext.getContext().getSession().put("cart", new SaleRecord_view());
			ActionContext.getContext().getSession().put("store_id", 1);
		}
		ActionContext.getContext().getSession().put("customer", c);
		ActionContext.getContext().getSession().put("cname", c.getName());
		return "success";
	}

	public String exchangeCredit(){
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		cs.exchangeCredit(customer_id, amount);
		Customer c = cs.getInfo(customer_id);
		ActionContext.getContext().getSession().put("customer", c);
		return "success";
	}
	
	public String makevalidate(){
		if(getAmount()<200){
			return "error";
		}
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		ps.pay(customer_id,getCid(),getAmount());
		cs.validate(customer_id);
		return "success";
	}
	
	
	public String showCommodityList(){
		
		System.out.println(time+"teim");
		if(getSid()==null){
			sid="1";
//			sid = ActionContext.getContext().getSession().get("store_id").toString();
			ActionContext.getContext().getSession().put("colist", ss.getInventory(Integer.parseInt(sid),time));
		}
		else{
			String[] temp = getSid().split("-");
			setSid(temp[0]);
			ActionContext.getContext().getSession().put("store_id", temp[0]);
			ActionContext.getContext().getSession().put("store_name", temp[1]);
			ActionContext.getContext().getSession().put("colist", ss.getInventory(Integer.parseInt(getSid()),time));
		}
		ActionContext.getContext().getSession().put("stlist", sts.getStore());
		return "success";
		
	}
	
	
	
	public String addCart(){

		SaleRecord_view sv = (SaleRecord_view)ActionContext.getContext().getSession().get("cart");
		sv.setStore_id(Integer.parseInt(ActionContext.getContext().getSession().get("store_id").toString()));
		sv.setStore_name(ActionContext.getContext().getSession().get("store_name").toString());
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		sv.setCustomer_id(customer_id);
		
		
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
			cv.setAmount(cv.getAmount()+(int)getAmount());
			sv.getList().set(i, cv);
		}
		
		else{
		
		Commodity_view cv = new Commodity_view();
		cv.setName(cname);
		cv.setCommodity_id(Integer.parseInt(getCommodity_id()));
		cv.setAmount((int)getAmount());
		cv.setPrice(Double.parseDouble(getPrice()));
		sv.getList().add(cv);
		}
		
		ActionContext.getContext().getSession().put("cart", sv);
		
		return "success";
		
	}
	public String getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}
	
	
	public String deleteCommodityfromCart(){
		
		SaleRecord_view sv = (SaleRecord_view)ActionContext.getContext().getSession().get("cart");
		sv.setStore_id(Integer.parseInt(ActionContext.getContext().getSession().get("store_id").toString()));
		sv.setStore_name(ActionContext.getContext().getSession().get("store_name").toString());
		int customer_id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		sv.setCustomer_id(customer_id);	
		
		commodity_id = ServletActionContext.getRequest().getParameter("cid").toString();

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
		
		String result =  ss.createReserve(Integer.parseInt(ActionContext.getContext().getSession().get("id").toString()), 
				Integer.parseInt(ActionContext.getContext().getSession().get("store_id").toString()), new Date(), list);
		
		if(result.equals("success")){
			ActionContext.getContext().getSession().put("cart", new SaleRecord_view());
		}
		
		return result;
		
	}
	
	
	
	public String cancelReserve(){
		String rid = ServletActionContext.getRequest().getParameter("rid");
		ss.cancelReserve(Integer.parseInt(rid));
		return "success";
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String stopCustomer(){
		String cid = ServletActionContext.getRequest().getParameter("cid");
		cs.stopValid(Integer.parseInt(cid));
		Customer c = cs.getInfo(Integer.parseInt(cid));
		ActionContext.getContext().getSession().put("customer", c);
		return "success";
	}
	
}
