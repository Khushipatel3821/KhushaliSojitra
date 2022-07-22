/*B28. Write a Java program that accepts an integer (n) and computes the value of n+nn+nnn.

Input number: 5
*/
package Modul1;

import java.util.Scanner;

public class IntegerNCompute {
	
	public static void main(String[] args) {
		int n,i;
		System.out.println("(Enter Number of integer)Input Number:");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		System.out.printf("%d + %d%d  + %d%d%d\n", n, n, n, n, n, n);
	}

}
