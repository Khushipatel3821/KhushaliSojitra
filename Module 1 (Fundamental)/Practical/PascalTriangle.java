/* B24. Write a Java program to display Pascal’s triangle. 
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1 */

package Modul1;

import java.util.Scanner;

class Factorial 
{
public int fact(int i) {
	
	if(i == 0)
	{
		return 1;
	}
	else
	{
		return i * fact(i-1);
	}
}
}

public class PascalTriangle {
	
	public static void main(String[] args) {
		
		int row,j,num;
		System.out.println("Enter number of rows:");
		try (Scanner sc = new Scanner(System.in)) {
			num=sc.nextInt();
		}
		Factorial f = new Factorial();
	
		for (row=0; row<num; row++)
		{
		
			for (j=0; j<=row; j++)
			{
					 System.out.print(f.fact(row)/(f.fact(j)*f.fact(row-j)));
			}
			System.out.println(" ");
		}
	 
	
		}
	}
