package p1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class Exe2_1 {

	private static int num;
	private static int maxCount;
	private static int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService threadPool = Executors.newWorkStealingPool();
		
		for(int i=0;i<10000;i++){
			count=i;
			threadPool.submit(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					findMaxDiv(count);
					
				}
			});
		}
		
		threadPool.shutdown();
		
		try {
			threadPool.awaitTermination(1,TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Max div number:"+num);
		System.out.println("Div count is:"+maxCount);
		
	}
	public static void findMaxDiv(int threadCount){
		
			// TODO Auto-generated method stub
		Object lock = new Object();
		int tempCount=0;
		for(int j=1; j<=threadCount; j++){
			if((threadCount%j)==0) tempCount++;
		}
		synchronized (lock) {
			if(tempCount>maxCount){
				tempCount=maxCount;
				num=threadCount;
			}	
		}
		
		
	}

	

}
