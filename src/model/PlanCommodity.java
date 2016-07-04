package model;



import javax.persistence.*;

@Entity
@Table(name="plancommodity")
public class PlanCommodity {

	
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






	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int commodity_id;
	
	private int amount;
	

	private double price;
	
	

	
	
}
