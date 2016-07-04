package beans;

import java.io.Serializable;
import java.util.ArrayList;


import model.WorkingRecord;


public class WorkingList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private ArrayList<WorkingRecord> list;
	
	
	public ArrayList<WorkingRecord> getList() {
		return list;
	}
	public void setList(ArrayList<WorkingRecord> list) {
		this.list = list;
	}
	
	public void setList(WorkingRecord w, int i) {
		list.set(i, w);
		}
	
	public WorkingRecord getList(int index) {
		return (WorkingRecord)list.get(index);
	}
	
	
}
