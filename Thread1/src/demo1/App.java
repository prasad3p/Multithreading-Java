package demo1;

class runner extends Thread{
	public void run() {
		
		for(int i=0;i<10;i++)
		{
			System.out.println("pp"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class runner2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			System.out.println("pp"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class App {
	
	public static void main(String[] args){
		
		runner r1=new runner();
		runner r2=new runner();
		r1.start();
		r2.start();
		
		
		Thread t1=new Thread(new runner2());
		Thread t2=new Thread(new runner2());
		t1.start();
		t2.start();
		
	}
	

}
