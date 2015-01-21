public class Foundation {
	private double m3; // cubic meters

	public Foundation(double m3) {
		this.m3 = m3;
	}

	public void setM3(double m3) {
		this.m3 = m3;
	}

	@Override
	public String toString() {
		return "Foundation [cubic meters=" + this.m3 + "]";
	}

}
