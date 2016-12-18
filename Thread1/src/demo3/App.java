package demo3;

public class App {

	private int count=0;
	
	
	public void dowork(){
		Thread t1= new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<10000;i++){count++;}
			}
		});
		
		Thread t2= new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<10000;i++){count++;}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();//Waits for execution of t1 before sysout is executed.
			t2.join();//Waits for execution of t2 before sysout is executed.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("count is:"+count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App a=new App();
		a.dowork();
		
		
	}

}
