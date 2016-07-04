package beans;

import java.io.Serializable;
import java.util.ArrayList;

import model.PayRecord;


public class PayRecordList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private ArrayList<PayRecord> list;
	
	
	public ArrayList<PayRecord> getList() {
		return list;
	}
	public void setList(ArrayList<PayRecord> list) {
		this.list = list;
	}
	
	public void setList(PayRecord s, int i) {
		list.set(i, s);
		}
	
	public PayRecord getList(int index) {
		return (PayRecord)list.get(index);
	}
	
	
}
