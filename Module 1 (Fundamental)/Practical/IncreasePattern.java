/*B22. Write a program in Java to make such a pattern like right angle triangle with number increased by 1. 
The pattern like:
1
2 3
4 5 6
7 8 9 10 */

package Modul1;

import java.util.Scanner;

public class IncreasePattern {
	public static void main(String[] args) {
		
		int row,j,num, count=1;
		System.out.println("Enter the number of the raws(which you want to enter in pattern): ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
				
				for(row=1; row<=num; row++)
				{
					for(j=1; j<=row; j++)
					{
						System.out.print(count + " " );
						count++;
					}
					System.out.println(" ");
				}
	}

}
