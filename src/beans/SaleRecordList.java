package beans;

import java.util.ArrayList;

import beans.SaleRecord_view;

public class SaleRecordList {
	/**
	 * 
	 */

	private ArrayList<SaleRecord_view> list;
	
	
	public ArrayList<SaleRecord_view> getList() {
		return list;
	}
	public void setList(ArrayList<SaleRecord_view> list) {
		this.list = list;
	}
	
	public void setList(SaleRecord_view s, int i) {
		list.set(i, s);
		}
	
	public SaleRecord_view getList(int index) {
		return (SaleRecord_view)list.get(index);
	}
}
