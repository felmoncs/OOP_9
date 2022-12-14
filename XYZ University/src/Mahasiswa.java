
public class Mahasiswa extends Orang{

	protected int[] year = {2015, 2016, 2017, 2018, 2019, 2020};

	public Mahasiswa(String name, int age, String address, String email, int[] year) {
		super(name, age, address, email);
		// TODO Auto-generated constructor stub
	}

	public Mahasiswa() {
		// TODO Auto-generated constructor stub
	}

	public int[] getYear() {
		return year;
	}

	public void setYear(int[] year) {
		this.year = year;
	}

	@Override
	public void viewData() {
		// TODO Auto-generated method stub
		System.out.println("Tahun Masuk : "+ this.year);
		System.out.println("==========================");
		
		
	}

}
