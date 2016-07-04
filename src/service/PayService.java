package service;

import java.util.Date;

import dao.BankDao;
import dao.CustomerDao;
import dao.PayRecordDao;
import enums.PayResult;
import model.BankAccount;
import model.Customer;
import model.PayRecord;

public class PayService {
	
	
	public void setBd(BankDao bd) {
		this.bd = bd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public void setPrd(PayRecordDao prd) {
		this.prd = prd;
	}

	public void setLevels(double[] levels) {
		this.levels = levels;
	}

	BankDao bd;
	CustomerDao cd;
	PayRecordDao prd;
	
	double[] levels = {200,500,1000,2000,5000,10000};

	@SuppressWarnings("unchecked")
	public PayResult pay(int customer_id,int card_id,double amount){
		BankAccount ba = bd.find(card_id);
		if(ba==null){
			return PayResult.CardIdError;
		}
		
		
		else{
			ba.setBalance(ba.getBalance()-amount);
			bd.update(ba);
		}
		
		
		Customer c = cd.find(customer_id);
		if(c==null){
			return PayResult.CustomerIdError;
		}
		
		else{
			c.setTotal_amount(c.getTotal_amount()+amount);
			c.setBalance(c.getBalance()+amount);
			int level = 0;
			while(c.getTotal_amount()>levels[level]){
				level++;
			}
			c.setLevel(level);
			if(c.getValid()==-1){
				c.setValid(1);
			}
			cd.update(c);
			PayRecord pr = new PayRecord();
			pr.setCustomer_id(customer_id);
			pr.setCard_id(card_id);
			pr.setAmount(amount);
			pr.setTime(new Date());
			prd.add(pr);
			return PayResult.Success;
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean validate(int id,int card_id,double amount){
		if(amount < 200){
			return false;
		}
		else{
			pay(id, card_id, amount);
			Customer c = cd.find(id);
			c.setValid(1);
			cd.update(c);
			return true;
		}
		
	}
	
	
}
