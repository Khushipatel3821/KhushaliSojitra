//B26. Write a Java program to count the letters, spaces, numbers and other characters of an input string.

package Modul1;

import java.util.Scanner;

public class StringCount
{
	
	public static void main(String[] args)
	{
			

		String test = "I am a Khushali. My e-mail id is khushipatel3821@gmail.com .";
		count(test);
	}
	
	public static void count(String x)
	{
		char[] ch = x.toCharArray();
		int letter = 0;
		int space = 0;
		int num = 0;
		int other = 0;
		for(int i = 0; i < x.length(); i++)
		{
			if(Character.isLetter(ch[i]))
			{
				letter ++ ;
			}
			else if(Character.isDigit(ch[i]))
			{
				num ++ ;
			}
			else if(Character.isSpaceChar(ch[i]))
			{
				space ++ ;
			}
			else
			{
				other ++;
			}
		}
		System.out.println("The string is : I am a Khushali. My e-mail id is khushipatel3821@gmail.com .");
		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("other: " + other);
		}
	}
	


