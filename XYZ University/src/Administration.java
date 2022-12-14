import java.util.Calendar;

public class Administration extends Karyawan {

	private String title;
	
	public Administration(String name, int age, String address, String email, Calendar start) {
		super(name, age, address, email, start);
		// TODO Auto-generated constructor stub
	}

	public Administration() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
