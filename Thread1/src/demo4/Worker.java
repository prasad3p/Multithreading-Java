package demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	
	private Random ran = new Random();
	
	private Object lock1= new Object();
	private Object lock2= new Object();
	
	private List<Integer> list1= new ArrayList<Integer>();
	private List<Integer> list2= new ArrayList<Integer>();
	
	public void stageOne(){
		
		synchronized (lock1) {
			
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(ran.nextInt(100));
		}
	}
	
	public void stageTwo(){
		
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(ran.nextInt(100));
		}
	}
	
	public void process(){
		for(int i=0;i<1000;i++)
		{
			stageOne();
			stageTwo();
		}
		
	}
	
	public void main() {
		// TODO Auto-generated method stub
		System.out.println("Starting..");
		long start = System.currentTimeMillis();
		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				process();
				
			}
		});
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				process();
				
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken:"+ (end-start));
		System.out.println("List one size: "+list1.size()+"\nList two size: "+list2.size());
				
		
		
	}

}
