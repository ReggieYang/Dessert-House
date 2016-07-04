package beans;

import java.io.Serializable;
import java.util.ArrayList;


import model.Store;


public class StoreList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private ArrayList<Store> list;
	
	
	public ArrayList<Store> getList() {
		return list;
	}
	public void setList(ArrayList<Store> list) {
		this.list = list;
	}
	
	public void setList(Store s, int i) {
		list.set(i, s);
		}
	
	public Store getList(int index) {
		return (Store)list.get(index);
	}
	
	
}
