package Model;

public class Booking {
	private String filmName;
	private int office;
	public Booking(String name, int sum) {
		this.filmName = name;
		this.office = sum;
	}
	public void add(int num) {
		this.office =+ num;
	}
	public String getName() {
		return this.filmName;
	}
	public int getOffice() {
		return this.office;
	}
}
