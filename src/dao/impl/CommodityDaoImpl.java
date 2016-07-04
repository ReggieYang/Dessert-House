package dao.impl;



import java.util.ArrayList;
import java.util.List;

import beans.CommodityList;
import dao.CommodityDao;
import model.Commodity;

@SuppressWarnings("rawtypes")
public class CommodityDaoImpl extends BaseDaoImpl implements CommodityDao {

	@SuppressWarnings("unchecked")
	@Override
	public CommodityList showAllCommodity() {
		List l = findAll(Commodity.class);
		ArrayList<Commodity> list = new ArrayList<Commodity>();
		for(int i = 0;i<l.size();i++){
			list.add((Commodity)l.get(i));
		}
		CommodityList cl = new CommodityList();
		cl.setList(list);
		return cl;
	}

	

}
