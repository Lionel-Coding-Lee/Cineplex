package Model;

public class Age {
	private String age;
	private int num;
	public Age(String age, int num) {
		this.age = age;
		this.num = num;
	}
	public int getNum(){
		return num;
	}
	public String getAge() {
		return age;
	}
}