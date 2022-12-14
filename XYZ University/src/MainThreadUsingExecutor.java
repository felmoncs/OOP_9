import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

	public class MainThreadUsingExecutor {
		private Lock objLock = new ReentrantLock();
		private Condition changeUser = objLock.newCondition();
		private Scanner sc;
		public static void main(String[] args) {
			new MainThreadUsingExecutor();
		}
		
		public MainThreadUsingExecutor() {
			sc = new Scanner(System.in);
			ExecutorService es = Executors.newFixedThreadPool(2);
			es.execute(new UserTask("Aldo"));
			es.execute(new UserTask("Bryan"));
			es.shutdown();
			try {
				es.awaitTermination(24L, TimeUnit.HOURS);
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