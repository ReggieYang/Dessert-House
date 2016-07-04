package dao.impl;

import java.util.List;

import dao.StatsDao;

@SuppressWarnings("rawtypes")
public class StatsDaoImpl extends BaseDaoImpl implements StatsDao{

	@Override
	public List customerAge() {
		String sql="SELECT sum(CASE when c.age<20 then 1 else 0 end)   AS 'below 20', "+
		  "sum(CASE when c.age>=20 and c.age<30 then 1 else 0 end)   AS '20-30',  "+
		  "sum(CASE when c.age>=30 and c.age<40 then 1 else 0 end)   AS '30-40',  "+
		  "sum(CASE when c.age>=40 and c.age<50 then 1 else 0 end)   AS '40-50',  "+
		  "sum(CASE when c.age>=50 then 1 else 0 end)   AS 'above 50'  "+
		  "FROM customer c";
		return findsql(sql);
	}

	@Override
	public List customerGender() {
		String sql="SELECT case when c.gender=0 then 'Female' else 'Male' end ,COUNT(*) FROM customer c GROUP BY c.gender";
		return findsql(sql);
	}

	@Override
	public List customerAddress() {
		String sql="SELECT c.address,COUNT(*) FROM customer c GROUP BY c.address";
		return findsql(sql);
	}

	@Override
	public List customerValid() {
		String sql="SELECT case when c.valid=1 then 'valid' when c.valid=0 then 'invalid' when c.valid=-2 then 'stop' else 'pause' end,"
				+ "COUNT(*) FROM customer c GROUP BY c.valid";
		return findsql(sql);
	}

	@Override
	public List hotSale() {
		String sql="SELECT SUM(sc.price*sc.amount),c.`name` FROM commodity c,salerecord sr,salecommodity sc "+
			"WHERE sr.sale_status=1 AND sr.sale_id=sc.sale_id "+
			"AND sc.commodity_id=c.commodity_id GROUP BY sc.commodity_id "+
			"ORDER BY SUM(sc.price*sc.amount) DESC LIMIT 0,5";
		return findsql(sql);
	}

	@Override
	public List hotSale(String date) {
		String sql="select SUM(sc.price*sc.amount),c.`name` FROM salerecord sr,"
				+ "salecommodity sc,commodity c WHERE sr.sale_id=sc.sale_id AND sr.sale_status=1"
				+" AND sc.commodity_id=c.commodity_id AND sr.time<'"+date+"-01' AND sr.time>DATE_SUB('"+date+
				"-01' ,INTERVAL 1 MONTH) GROUP BY sc.commodity_id ORDER BY SUM(sc.price*sc.amount) DESC	LIMIT 0,5";
		return findsql(sql);
	}

	@Override
	public List customerSale() {
		String sql="SELECT SUM(sc.price*sc.amount),DATE_FORMAT(sr.time,'%Y-%m') months "+
			"FROM salerecord sr,salecommodity sc WHERE sr.sale_id=sc.sale_id AND sr.sale_status=1 "+
			"GROUP BY months ORDER BY months LIMIT 0,3";
		return findsql(sql);
	}

	@Override
	public List storeSale(String date) {
		String sql="select s.`name`,SUM(sc.price*sc.amount) FROM salerecord sr,"
				+ "salecommodity sc,store s WHERE sr.sale_id=sc.sale_id AND sr.sale_status=1"
				+" AND s.id=sr.store_id AND sr.time>'"+date+"-01' AND sr.time<DATE_ADD('"+date+
				"-01' ,INTERVAL 1 MONTH) GROUP BY sr.store_id";
		return findsql(sql);
	}

	@Override
	public List storeSale() {
		String sql="select s.`name`,SUM(sc.price*sc.amount) FROM salerecord sr,salecommodity sc,store s "+
			"WHERE sr.sale_id=sc.sale_id AND sr.sale_status=1 AND s.id=sr.store_id GROUP BY sr.store_id";
		return findsql(sql);
	}

	@Override
	public List storeReserve(String date) {
		String sql="select s.`name`,SUM(sc.price*sc.amount) FROM salerecord sr,"
				+ "salecommodity sc,store s WHERE sr.sale_id=sc.sale_id AND sr.sale_status=0"
				+" AND s.id=sr.store_id AND sr.time>'"+date+"-01' AND sr.time<DATE_ADD('"+date+
				"-01' ,INTERVAL 1 MONTH) GROUP BY sr.store_id";
		return findsql(sql);
	}

	@Override
	public List storeReserve() {
		String sql="select s.`name`,SUM(sc.price*sc.amount) FROM salerecord sr,salecommodity sc,store s "+
				"WHERE sr.sale_id=sc.sale_id AND sr.sale_status=0 AND s.id=sr.store_id GROUP BY sr.store_id";
		return findsql(sql);
	}

}
