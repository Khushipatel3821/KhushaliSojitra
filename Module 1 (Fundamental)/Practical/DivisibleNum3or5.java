/*B30. Write a Java program to print numbers between 1 to 100 which are divisible by 3, 5 and by both.*/

package Modul1;

public class DivisibleNum3or5 {
	public static void main(String[] args) {
		int i, n=100; 
		for (i=1; i<=n; i++)
		{
			if(i%3==0 || i%5==0)
			{ 
				System.out.println(i + " ");
			}
		}
	}

}
