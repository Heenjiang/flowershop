package entity;

public class Flower {
	private Integer id ;
	private String name;
	private String color;
	private String freshness;
	private Double rhizomelength;
	private Double price;
	private Integer p_id;
	public Flower() {}
	public Flower(Integer id, String name, String color, String freshness, Double rhizomelength, Double price,
			Integer p_id) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.freshness = freshness;
		this.rhizomelength = rhizomelength;
		this.price = price;
		this.p_id = p_id;
	}
	public Flower(String name, String color, String freshness, Double rhizomelength, Double price, Integer p_id) {
		super();
		this.name = name;
		this.color = color;
		this.freshness = freshness;
		this.rhizomelength = rhizomelength;
		this.price = price;
		this.p_id = p_id;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the freshness
	 */
	public String getFreshness() {
		return freshness;
	}
	/**
	 * @param freshness the freshness to set
	 */
	public void setFreshness(String freshness) {
		this.freshness = freshness;
	}
	/**
	 * @return the rhizomelength
	 */
	public Double getRhizomelength() {
		return rhizomelength;
	}
	/**
	 * @param rhizomelength the rhizomelength to set
	 */
	public void setRhizomelength(Double rhizomelength) {
		this.rhizomelength = rhizomelength;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the p_id
	 */
	public Integer getP_id() {
		return p_id;
	}
	/**
	 * @param p_id the p_id to set
	 */
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flower [id=" + id + ", name=" + name + ", color=" + color + ", freshness=" + freshness
				+ ", rhizomelength=" + rhizomelength + ", price=" + price + ", p_id=" + p_id + "]";
	}
	

}
