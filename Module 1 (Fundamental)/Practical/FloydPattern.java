/*B23. Write a program in Java to print the Floyd’s Triangle.
1
01
101
0101
10101 */

package Modul1;

import java.util.Scanner;

public class FloydPattern {
	
	public static void main(String[] args) {
		
		int row,j,num;
		System.out.println("Enter number of rows:");
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		
		for (row = 1; row<=num; row++)
		{
			for(j=1; j<=row; j++)
			{
				if(((row+j)%2)==0)
				{
					System.out.print("1");
				}
				else
				{
					System.out.print("0");
				}
			}
			System.out.println(" ");
		}
		
		}

}
