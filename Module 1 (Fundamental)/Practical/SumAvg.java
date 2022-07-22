// Write a program in Java to input 5 numbers from keyboard and find their sum and average using for loop.

package Modul1;

import java.util.Scanner;

public class SumAvg {
	public static void main(String[] args) {
		
		int i;
		double  sum = 0,avg, num = 0;
		System.out.println("Enter 5 number:");
		
		for (i=0 ; i<5; i++)
		{
		Scanner sc = new Scanner(System.in);
		num = sc.nextDouble();
		
		sum = sum + num;
		
		}
		avg = sum / 5;
		
		System.out.println("Sum =" +sum +" Average =" +avg );
		
		
	}
 
}
