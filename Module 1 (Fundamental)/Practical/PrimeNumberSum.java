// B33. Write a Java program to compute the sum of the first 100 prime numbers.

package Modul1;

public class PrimeNumberSum {
	public static void main(String[] args) {
		
		int n1, sum=0,i;
		for(n1=1; n1<=100; n1++)
		{
			int count =0;
			for(i=2; i<=n1/2; i++)
			{
				if(n1%i ==0)
				{
					count++;
					break;
				}
			}
				if (count ==0 && n1 !=1)
				{
					sum = sum + n1;
				}
				
			
		}
		System.out.println("The sum of the first 100 prime number:" +sum);
		
	}

}
