/* 
 * Without multithreading.
*/


package p1;

public class Exe2_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxCount=0;
		int tempCount=0;
		int num=0;
		
		for(int i=10000; i>=1; i--){
			
			for(int j=1; j<=i; j++)
				if(i%j==0)tempCount++;
			
			if(tempCount>maxCount){
				maxCount=tempCount;
				num=i;
			}
			tempCount=0;
		}
		
		System.out.println("Number is:"+num);
		System.out.println("Count is:"+maxCount);

	}

}
