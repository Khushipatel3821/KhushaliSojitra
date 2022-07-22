//Write a Java program that takes a year from user and print whether that year is a leap year or not.

package Modul1;

import java.util.Scanner;

public class LipYear {
	public static void main(String[] args) {
		
		System.out.println("Enter Any Year:");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int remind = year % 4;
		if (remind == 0)
		{
			System.out.println("This year is lip-year.");
		}
		else 
		{
			System.out.println("This year is not lip-year.");
		}
		
	}

}
