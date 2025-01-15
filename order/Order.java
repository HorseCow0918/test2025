package order;

public class Order {
	private Integer casual;
	private Integer allright;
	private Integer dontknow;
	private Integer sum;

	public Order(Integer casual, Integer allright, Integer dontknow) {
		super();
		this.casual = casual;
		this.allright = allright;
		this.dontknow = dontknow;
		sum = casual * 100 + allright * 80 + dontknow * 90;

		if (sum >= 500) {
			this.sum = (int) (sum * 0.9);
		}
	}

	public Integer getCasual() {
		return casual;
	}

	public void setCasual(Integer casual) {
		this.casual = casual;
	}

	public Integer getAllright() {
		return allright;
	}

	public void setAllright(Integer allright) {
		this.allright = allright;
	}

	public Integer getDontknow() {
		return dontknow;
	}

	public void setDontknow(Integer dontknow) {
		this.dontknow = dontknow;
	}

	public Integer getSum() {
		return sum;
	}
	

}
