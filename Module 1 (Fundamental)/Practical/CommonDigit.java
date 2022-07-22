/*B32. Write a Java program that accepts two integer values between 25 to 75 and return true if there is a common digit in both numbers.
Input the first number: 35
Input the second number: 45
Result: true*/

package Modul1;

import java.util.Scanner;

public class CommonDigit {
	public static void main(String[] args) {
		
		int n1=25, n2=75, n3, n4;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the first number:  ");
		n3 = sc.nextInt();
		System.out.println("Input the second number:  ");
		n4 = sc.nextInt();
		 if (n3 > n1 && n3 < n2 && n4 > n1 && n4 < n2)
		 {
			 if (n3 % 10 == n4 % 10 || n3/10 == n4/10)
			 {
				System.out.println("Result: true");  
			 }
			 else 
			 {
				 System.out.println("Result: false");
			 }
		 }
		 else 
		 {
			 System.out.println(" Your enter integer is out of the limit");
		 }
	}

}
