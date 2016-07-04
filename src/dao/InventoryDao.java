package dao;

import java.util.ArrayList;

import beans.Commodity_view;

@SuppressWarnings("rawtypes")
public interface InventoryDao extends BaseDao{
		public ArrayList<Commodity_view> getInventory(int store_id,String time);
}
