import java.util.Calendar;
import java.util.Date;

public class Karyawan extends Orang {

	protected String location;
	protected int salary;
	protected Calendar calendar;
	
	Calendar start = Calendar.getInstance();
	
	public Karyawan(String name, int age, String address, String email, String location, int salary, Calendar start) {
		super(name, age, address, email);
		// TODO Auto-generated constructor stub
	}

	public Karyawan() {
		// TODO Auto-generated constructor stub
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	@Override
	public void viewData() {
		// TODO Auto-generated method stub
		System.out.println("Location : "+ this.);
		System.out.println("Salary : "+ this.salary);
		System.out.println("Mulai Bekerja : "+ this.start);
		System.out.println("==========================");
	}

}
