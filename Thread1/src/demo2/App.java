package demo2;

import java.util.Scanner;

class runner extends Thread{
	
	public volatile
	boolean rnstate=true;
	
	public void run(){
		
		while(rnstate)
		{
			System.out.println("pp");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public void shutdown(){
		this.rnstate=false;
	}
}


public class App {

	public static void main(String[] args){
		
		runner r=new runner();
		r.start();
		
		System.out.println("Press enter to stop!");
		Scanner s=new Scanner(System.in);
		s.nextLine();
		
		r.shutdown();
		
		
		
	}
	
}
