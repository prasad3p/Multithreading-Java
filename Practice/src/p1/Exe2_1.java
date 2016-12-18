package p1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Exe2_1 {

	private static int num;
	private static int tempCount;
	private static int maxCount;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService threadPool = Executors.newWorkStealingPool();
		
		for(int i=0;i<100000;i++){
			
			threadPool.submit(findMaxDiv(i));
			
		}
		
		threadPool.shutdown();
		
		try {
			threadPool.awaitTermination(1,TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Runnable findMaxDiv(int i) {
		// TODO Auto-generated method stub
		for(int j=1; j<=i; j++){
			if((i%j)==0) tempCount++;
		}
		if(tempCount>maxCount)tempCount=maxCount;
		
		
		return null;
	}

	

}
