package beans;

import java.io.Serializable;
import java.util.ArrayList;

import model.Commodity;


public class CommodityList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private ArrayList<Commodity> list;
	
	
	public ArrayList<Commodity> getList() {
		return list;
	}
	public void setList(ArrayList<Commodity> list) {
		this.list = list;
	}
	
	public void setList(Commodity s, int i) {
		list.set(i, s);
		}
	
	public Commodity getList(int index) {
		return (Commodity)list.get(index);
	}
	
	
}
