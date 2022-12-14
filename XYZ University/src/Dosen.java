import java.util.Calendar;

public class Dosen extends Karyawan{

	private int hours, level;
	
	public Dosen(String name, int age, String address, String email, Calendar start) {
		super(name, age, address, email, start);
		// TODO Auto-generated constructor stub
	}

	public Dosen() {
		// TODO Auto-generated constructor stub
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
