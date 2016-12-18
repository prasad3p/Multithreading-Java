/*Subsection 12.1.3 discusses the need for synchronization in multithreaded programs, and it defines a ThreadSafeCounter class with the necessary synchronization. Is this really important? Can you really get errors by using an unsynchronized counter with multiple threads? Write a program to find out. Use the following unsynchronized counter class, which you can include as a nested class in your program:

static class Counter {
    int count;
    void inc() {
        count = count+1;
    }
    int getCount() {
        return count;
    }
}
Write a thread class that will call the inc() method in this class a specified number of times. Create several threads, start them all, and wait for all the threads to terminate. Print the final value of the counter, and see whether it is correct.

Let the user enter the number of threads and the number of times that each thread will increment the counter. You might need a fairly large number of increments to see an error. And of course there can never be any error if you use just one thread. Your program can use join() to wait for a thread to terminate
EXE 1
*/


package p1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class Exe1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter number of threds");
		Scanner scanner = new Scanner(System. in); 
		String input = scanner. nextLine();
		
		System.out.println("Enter number of tasks");
		String input2=scanner.nextLine();
		
		 // create a pool of threads, 10 max jobs will execute in parallel
		ExecutorService threadPool = Executors.newFixedThreadPool(Integer.parseInt(input));
		
		 // submit jobs to be executing by the pool
		for (int i = 0; i < Integer.parseInt(input2); i++) {
		    threadPool.submit(new Runnable() {
		         public void run() {		        	 
		        	 Counter.inc();
		             // some code to run in parallel
		         }
		     });
		 }
		 // once you've submitted your last job to the service it should be shut down
		 threadPool.shutdown();
		 // wait for the threads to finish if necessary
		 try {
			threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Count is "+Counter.count);
		
	}
	static class Counter{
	    static int count;
	    static void inc() {
	        count = count+1;
	    }
	    int getCount() {
	        return count;
	    }
	}

}
