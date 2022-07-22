/*B31. Write a Java program to calculate the sum of two integers and return true if the sum is 
 equal to a third integer.
Input the first number: 5
Input the second number: 10
Input the third number: 15
The result is: true*/

package Modul1;

import java.util.Scanner;

public class ReturnTrue {

	public static void main(String[] args) {
		
		int n1, n2, n3;
		int sum;
		System.out.println("Input the first number:");
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();
		System.out.println("Input the second number:");
		n2 = sc.nextInt();
		System.out.println("Input the third number:");
		n3 = sc.nextInt();
		
		sum = n1 + n2;
		if(sum == n3)
		{
			System.out.println("The result is: True");
		}
		else 
		{
			System.out.println("The result is: False");
		}
	}
}
