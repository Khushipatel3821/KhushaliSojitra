package Modul1;

import java.util.Scanner;

public class GreatestNumber {

	public static void main(String[] args) {
		System.out.println("Enter Three integer Number:");
		Scanner sc1 = new Scanner(System.in);
		int num1 = sc1.nextInt();
		Scanner sc2 = new Scanner(System.in);
		int num2 = sc2.nextInt();
		Scanner sc3 = new Scanner(System.in);
		int num3 = sc3.nextInt();
		
		if(num1 > num2)
		{
			if(num1 > num3)
			{
				System.out.println(+num1 + " is Greatest Number.");
	
			}
			else
			{
				System.out.println(+num3 + " is Greatest Number.");
			}
		}
		else 
		{
			if(num2 > num3)
			{
				System.out.println(+num2 + " is Greatest Number.");
			}
			else
			{
				System.out.println(+num3 + " is Greatest Number.");
			}
		}
		
	}
}
