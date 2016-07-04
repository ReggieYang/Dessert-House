package beans;



public class Commodity_view {
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getCommodity_id() {
			return commodity_id;
		}

		public void setCommodity_id(int commodity_id) {
			this.commodity_id = commodity_id;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}



		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}



		private int id;
		
		private int commodity_id;
		
		private int amount;
		
		private double price;
		
		private String name;


		private String remark;
		
		
	
}
