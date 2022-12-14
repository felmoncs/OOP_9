import java.util.*;
import java.util.concurrent.locks.*;

public class MainThread {
	private Lock objLock = new ReentrantLock();
	private Condition changeUser = objLock.newCondition();
	private Scanner sc;
	
	public static void main(String[] args) {
		new MainThread();
	}
	
	public MainThread() {
		sc = new Scanner(System.in);
		UserTask ut1 = new UserTask("Adi");
		UserTask ut2 = new UserTask("Budi");
		Thread t1 = new Thread(ut1);
		Thread t2 = new Thread(ut2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {

			System.out.println(e);
		}
		
		System.out.println("Main Thread Finished\n\n");
		sc.close();
	}

	public class UserTask extends User implements Runnable{
		public UserTask(String nama) {
			super(nama);
		}
		
		public void run() {
			int choice;
			try {
				objLock.lock();
				do {
					System.out.println("1. Current User: " + getName() );
					System.out.println("2. Change User");
					System.out.println("3. Exit");
					System.out.print("Enter Choice >> ");
					choice = sc.nextInt();
					
					switch(choice) {
						case 1:
							System.out.println();
							break;
						case 2:
							if(Thread.activeCount() > 2) {
								System.out.println();
								changeUser.signal();
								changeUser.await();
							} else {
								System.out.println("Can't change user.\n");
							}
							break;
						case 3:
							System.out.println( getName() + " logging out\n");
							changeUser.signal();
							break;
						default:
							System.out.println("Wrong choice!!\n\n");
						}
					} while( choice != 3 );
				} catch(InterruptedException e) {
							System.out.println(e);
				} finally {
					objLock.unlock();
				}
			}
		}
	}