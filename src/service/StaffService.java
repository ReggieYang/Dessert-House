package service;

import beans.StoreList;
import beans.WorkingList;
import dao.StoreDao;
import dao.StaffDao;
import dao.WorkingDao;
import enums.PasswordResult;
import model.Staff;
import model.Store;
import model.Working;
import model.WorkingRecord;

public class StaffService {
	
	StaffDao sd;
	public void setSd(StaffDao sd) {
		this.sd = sd;
	}

	public void setStd(StoreDao std) {
		this.std = std;
	}

	public void setWd(WorkingDao wd) {
		this.wd = wd;
	}

	StoreDao std;
	WorkingDao wd;
	
	public PasswordResult verify(int id,String pw){
		Staff s = sd.find(id);
		System.out.println(id);
		if(s==null){
			return PasswordResult.IdError;
		}
		
		else if(s.getPassword().equals(pw)){
	//		return PasswordResult.Valid;

			switch(s.getType()) { 
		      case "waiter":  
		          return PasswordResult.Waiter; 
		      case "admin":
		    	  return PasswordResult.Admin;
		      case "head_waiter": 
		          return PasswordResult.HeadWaiter;
		      default: 
		          return PasswordResult.Manager;
		      } 
			
		}
		
		else 
			return PasswordResult.PasswordError;
		
	}
	
	public void deleteStore(int id){
		std.delete(id);
	}
	
	public void changeWorkingPlace(int wid,int sid){
		Working w = new Working();
		w.setStore_id(sid);
		w.setWaiter_id(wid);
		wd.updateWorking(w);
	}
	
	public void Register(String name,String type){
		Staff s = new Staff();
		s.setSid(sd.getMaxId()+1);
		s.setPassword("1");
		s.setName(name);
		s.setType(type);
		sd.add(s);
	}
	
	public WorkingRecord getWaiterInfo(int wid){
		return wd.findWaiterById(wid);
	}
	
	public int getCurrentId(){
		return (sd.getMaxId()+1);
	}
	
	public void deleteWaiter(int id){
		sd.delete(id);
	}
	
	public void newStore(String name,String address){
		Store temp = new Store();
		temp.setName(name);
		temp.setAddress(address);
		std.add(temp);
	}
	
	public StoreList getStore(){
		StoreList list = new StoreList();
		list.setList(std.findAll());
		return list;
	}
	
	public WorkingList getWaiter(){
		WorkingList list = new WorkingList();
		list.setList(wd.findWaiter());
		return list;
	}
	
	public String getType(int id){
		Staff s = sd.find(id);
		return s.getType();
	}
	
	
	public Staff getStaff(int sid){
		return sd.find(sid);
	}
	
	
	@SuppressWarnings("unchecked")
	public void changeStaff(int sid,String name,String password){
		Staff s = sd.find(sid);
		s.setName(name);
		s.setPassword(password);
		sd.update(s);
	}
	
	
	@SuppressWarnings("unchecked")
	public void changeType(int sid,String type){
		System.out.println(sid+type);
		Staff s = sd.find(sid);
		s.setType(type);
		sd.update(s);
	}
	
	public void newWorking(int wid,int sid){
		Working w = new Working();
		w.setStore_id(sid);
		w.setWaiter_id(wid);
		wd.add(w);
	}
	
	
	@SuppressWarnings("unchecked")
	public void modifyStore(int sid,String name,String address){
		Store s = std.findById(sid);
		s.setName(name);
		s.setAddress(address);
		std.update(s);
	}
	
}
