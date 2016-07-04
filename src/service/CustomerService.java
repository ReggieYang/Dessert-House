package service;

import java.util.ArrayList;
import java.util.Date;

import dao.CustomerDao;
import dao.PayRecordDao;
import enums.PasswordResult;

import model.Customer;
import model.PayRecord;

public class CustomerService {

	CustomerDao cd;
	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public PayRecordDao getPrd() {
		return prd;
	}

	public void setPrd(PayRecordDao prd) {
		this.prd = prd;
	}

	PayRecordDao prd;
	
	public PasswordResult verify(int id,String pw){
		Customer c = cd.find(id);
		if(c==null){
			return PasswordResult.IdError;
		}
		else if(c.getPassword().equals(pw)){
			return PasswordResult.Valid;
		}
		
		else return PasswordResult.PasswordError;
		
	}
	
	@SuppressWarnings("unchecked")
	public String Register(String name,String password,String address,String age,String gender){
		Customer c = new Customer();
		c.setId(cd.getMaxId()+1);
		c.setBalance(0);
		c.setName(name);
		c.setPassword(password);
		c.setAddress(address);
		c.setAge(Integer.parseInt(age));
		c.setStart_time(new Date());
		int ge = 0;
		if(gender.equals("Male")){
			ge = 1;
		}
		c.setGender(ge);
		return cd.save(c).toString();
//		cd.add(c);
	}
	
	public int getCurrentId(){
		return (cd.getMaxId()+1);
	}
	
	
	public Customer getInfo(int id){
		return cd.find(id);
	}
	
	@SuppressWarnings("unchecked")
	public void modifyInfo(int id,String name,String password,String age,String address,String gender){
		Customer c = cd.find(id);
		c.setName(name);
		c.setPassword(password);
		c.setAddress(address);
		c.setAge(Integer.parseInt(age));
		int ge = 0;
		if(gender.equals("Male")){
			ge = 1;
		}
		c.setGender(ge);
		cd.update(c);
	}
	
	public ArrayList<PayRecord> getPayRecord(int id){
		ArrayList<PayRecord> list = prd.find(id);
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public void stopValid(int id){
		Customer c = cd.find(id);
		c.setValid(-2);
		cd.update(c);
	}
	

	@SuppressWarnings("unchecked")
	public void validate(int id){
		Customer c = cd.find(id);
		c.setValid(1);
		cd.update(c);
	}
	
	@SuppressWarnings("unchecked")
	public void exchangeCredit(int cid,double amount){
		Customer c = cd.find(cid);
		c.setBalance(c.getBalance()+amount/100);
		c.setCredit(c.getCredit()-amount);
		cd.update(c);
	}
	
	
	
}
