/*B34. Write a Java program that accepts two double variables and test if both strictly between 0 and 1 and 
 false otherwise.
Input first number: 5
Input second number: 1
false*/

package Modul1;

import java.util.Scanner;

public class doublebtw0or1 {
	
	public static void main(String[] args) {
		
		double num1, num2, i=0.0, j=1.0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Input first number: ");
		num1 = sc.nextDouble();
		System.out.println("Input second number: ");
		num2 = sc.nextDouble();
		
		if (num1 >  i && num1 < j && num2 > i && num2 < j)
		{
			System.out.println("True");
		}
		else 
		{
			System.out.println("False");
		}	
		
	}

}
