package entity;

public class Bouquet {
	private Integer id;
	private Integer numOfFlower;
	private Double totalPrice;
	
	public Bouquet() {}

	public Bouquet(Integer numOfFlower, Double totalPrice) {
		super();
		this.numOfFlower = numOfFlower;
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the numOfFlower
	 */
	public Integer getNumOfFlower() {
		return numOfFlower;
	}

	/**
	 * @param numOfFlower the numOfFlower to set
	 */
	public void setNumOfFlower(Integer numOfFlower) {
		this.numOfFlower = numOfFlower;
	}

	/**
	 * @return the totalPrice
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bouqut [id=" + id + ", numOfFlower=" + numOfFlower + ", totalPrice=" + totalPrice + "]";
	}
	
}
