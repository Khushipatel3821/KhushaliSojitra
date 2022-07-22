/*B25. Write a Java program that reads a positive integer and count the number of digits the number.
Input an integer number less than ten billion: 125463
Number of digits in the number: 6
*/
package Modul1;

import java.util.Scanner;

public class IntegerRead {
	
	public static void main(String[] args) {
	int num , count =0;
	System.out.println("Input an integer number less than ten billion: ");
	Scanner sc = new Scanner(System.in);
	num = sc.nextInt();
	
	while (num > 0)
	{
		count++;
		num = num/10;
	}
	System.out.println("Number of Digits in the number :" + count);
	
	}
}
