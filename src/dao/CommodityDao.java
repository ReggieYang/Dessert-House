package dao;

import beans.CommodityList;

@SuppressWarnings("rawtypes")
public interface CommodityDao extends BaseDao{

	
	public CommodityList showAllCommodity();
}
