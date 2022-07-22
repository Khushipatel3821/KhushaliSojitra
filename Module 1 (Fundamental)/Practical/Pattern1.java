/*Write a program in Java to display the pattern like right angle triangle with a number.
1
12
123
1234
12345
123456
1234567
12345678 */

package Modul1;

import java.util.Scanner;

public class Pattern1 {
	
	public static void main(String[] args) {
		
		int row,j,n;  // i is for outer loop (row) & j is for num of value in one row
		System.out.println("Enter the number of rows:");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		for (row=1; row<=n; row++)
			
		{
			for (j=1; j<=row; j++)
			{
				System.out.print(j);
			}
			System.out.println(" ");
		}
	}

}
