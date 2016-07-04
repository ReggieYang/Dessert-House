package model;

import javax.persistence.*;

@Entity
@Table(name="bankcard")
public class BankAccount {
	
	@Id
	private int cid;
	private double balance;
	
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

}
