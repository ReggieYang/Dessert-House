package service;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.StatsDao;

public class StatsService {
	StatsDao sd;
	
	String[] c = {"#f56954","#00a65a","#f39c12","#00c0ef","#3c8dbc","#d2d6de"};

	public StatsDao getSd() {
		return sd;
	}

	public void setSd(StatsDao sd) {
		this.sd = sd;
	}
	
	
	public String customerAge(){
		return makePie(sd.customerAge());
	}
	
	public String customerGender(){
			return makePie2(sd.customerGender());
		}
	
	public String customerAddress(){
			return makePie2(sd.customerAddress());
		}
	
	public String customerValid(){
		return makePie2(sd.customerValid());
	
	}
	
	public String hotSale(){
		return makeBar(sd.hotSale());
	
	}
	
	public String hotSale(String date){
		return makeBar(sd.hotSale(date));
	}
	
	public String customerSale(){
		return makeBar(sd.customerSale());
	}
	
	public String storeSale(String date){
		return makePie2(sd.storeSale(date));
	}
	
	public String storeSale(){
		return makePie2(sd.storeSale());
		}
	
	public String storeReserve(String date){
		return makePie2(sd.storeReserve(date));
	}
	
	public String storeReserve(){
			return makePie2(sd.storeReserve());
	}
	
	@SuppressWarnings("rawtypes")
	public String makePie2(List l){
		JSONArray ja = new JSONArray();
		for(int i=0;i<l.size();i++){
			Object[] temp = (Object[])l.get(i);
				JSONObject js2 = new JSONObject();
				js2.put("value", temp[1]);
				js2.put("color", c[i]);
				js2.put("label", temp[0]);
				ja.put(js2);
		}
		return ja.toString();
	}
	
	@SuppressWarnings("rawtypes")
	public String makePie(List l){
		String[] t = {"Below 20","20-30","30-40","40-50","Above 50"};

		JSONArray ja = new JSONArray();
		for(int i=0;i<l.size();i++){
			Object[] temp = (Object[])l.get(i);
			for(int j=0;j<temp.length;j++){
				JSONObject js2 = new JSONObject();
				js2.put("value", temp[j]);
				js2.put("color", c[j]);
				js2.put("label", t[j]);
				ja.put(js2);
			}
		}
		return ja.toString();
		}
	

	
	
	@SuppressWarnings("rawtypes")
	public String makeBar(List l){
		JSONObject js = new JSONObject();

		Double[] a = new Double[l.size()];
		String[] b = new String[l.size()];
		for(int i=0;i<l.size();i++){
			
			Object[] temp = (Object[])l.get(i);
			a[i] = Double.parseDouble(temp[0].toString());
			b[i] = temp[1].toString();
		}
		
		JSONArray js3 = new JSONArray();
		JSONObject j1 = new JSONObject();
		j1.put("fillColor", "#9F88FF");
		j1.put("data", a);
		js3.put(j1);
		js.put("labels", b);
		js.put("datasets", js3);
		
		return js.toString();
	}
	
}
