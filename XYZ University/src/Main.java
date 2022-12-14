import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector<Orang> vec = new Vector<>();
	
	Random rand = new Random();
	
	public Main() {
		// TODO Auto-generated constructor stub
		int choose = 0;
		
		do{
			System.out.println("1. Insert");
			System.out.println("2. View");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			System.out.print("Choose: ");
			try {
				choose = scan.nextInt(); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				scan.nextLine();
				choose = 0;
			}scan.nextLine();
			
			switch(choose){
			
			case 1:
				menu1();
				break;
			case 2:
				menu2();
				break;
			case 3:
				menu3();
				break;
			case 4:
				menu4();
				break;
			}
			
		}while(choose != 5);
		
	}

	public Mahasiswa newData(){
		String name, address, email;
		int age;
		int[] year = {2015, 2016, 2017, 2018, 2019, 2020};
		
		System.out.print("Insert Name : ");
		name = scan.nextLine();
		System.out.print("Insert Age : ");
		age = scan.nextInt(); scan.nextLine();
		System.out.print("Insert Address : ");
		address = scan.nextLine();
		System.out.println("Insert Email : ");
		email = scan.nextLine();
		System.out.print("Insert Tahun Masuk : ");
		year = scan.nextInt();
		
		return new Mahasiswa(name, age, address, email, year);
		
	}
	
	public Karyawan dataBaru() {
		String name, address, email;
		int age, salary = 0;
		String location = null;
		Calendar calendar;
		Calendar start = Calendar.getInstance();
		
		System.out.print("Insert Name : ");
		name = scan.nextLine();
		System.out.print("Insert Age : ");
		age = scan.nextInt(); scan.nextLine();
		System.out.print("Insert Address : ");
		address = scan.nextLine();
		System.out.println("Insert Email : ");
		email = scan.nextLine();
		
		System.out.print("Insert Location : ");
		location = scan.nextLine();
		System.out.print("Insert salary : ");
		salary = scan.nextInt(); scan.nextLine();
		System.out.println("Insert Start Work : ");
		start = scan.next();
		
		
		return new Karyawan(name, age, address, email, location, salary, start);
		
	}
	
	public void menu1(){
		// insert data
		vec.add(newData());
		vec.add(dataBaru());
		
		System.out.println("Insert Success");
		
	}
	
	public void menu2(){

		int count = 1;
		
		for (Orang orang : vec) {
			//post increment
			System.out.println(count++);
			Orang.viewData();
			
		}
	}
	
	public int getIndex(){
		menu2();
		int choose = 0;
		do{
			System.out.print("Choose [1-"+vec.size()+"]: ");
			choose = scan.nextInt(); scan.nextLine();
		
		}while(choose < 1 || choose > vec.size());
		
		return choose-1;
	}
	
	public void menu4(){
		if (vec.isEmpty()) {
			System.out.println("Data kosong");
			scan.nextLine();
			return;
		}
		
		vec.remove(getIndex());
		System.out.println("Delete Success");	
	}
	
	public void menu3(){
		// update
		vec.set(getIndex(), newData(), dataBaru());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
