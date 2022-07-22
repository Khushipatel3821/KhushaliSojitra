/* Write a Java program that takes the user to provide a single character from the alphabet.
Print Vowel or Consonant, depending on the user input. If the user input is not a letter 
(between a and z or A and Z), or is a string of length > 1, print an error message. */
package Modul1;

import java.util.Scanner;

public class VowelConsonant {

	public static void main(String[] args) {
	
		System.out.println("Enter a Character");
		Scanner sc1 = new Scanner(System.in);
		char alphabet = sc1.next().charAt(0);
		
		
		if(alphabet == 'A' || alphabet == 'E' || alphabet == 'I' || alphabet == 'O' || alphabet == 'U' ||
				alphabet == 'a'|| alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u')
		{
			System.out.println("Given Character" +alphabet + " is a VOWEL.");
		}
	/*	else if (alphabet == 'B' ||alphabet == 'C' || alphabet == 'D' || alphabet == 'F' || alphabet == 'G' ||
				alphabet == 'H'|| alphabet == 'J' || alphabet == 'K' || alphabet == 'L' || alphabet == 'M' || 
				alphabet == 'N' || alphabet == 'P' || alphabet == 'Q' || alphabet == 'R' || alphabet == 'S' ||
				alphabet == 'T'|| alphabet == 'V' || alphabet == 'W' || alphabet == 'Z' || alphabet == 'X' ||
				alphabet == 'Y' ||alphabet == 'b' ||alphabet == 'c' || alphabet == 'd' || alphabet == 'f' ||
				alphabet == 'g' ||alphabet == 'h'|| alphabet == 'j' || alphabet == 'k' || alphabet == 'l' || 
				alphabet == 'm' ||alphabet == 'n' || alphabet == 'p' || alphabet == 'q' || alphabet == 'r' ||
				alphabet == 's' ||alphabet == 't'|| alphabet == 'v' || alphabet == 'w' || alphabet == 'z' ||
				alphabet == 'x' ||alphabet == 'y' ) */
		
		else if ((alphabet >= 'a' && alphabet <= 'z') ||(alphabet >= 'A' && alphabet <= 'Z'))
		{
			System.out.println("Given Character" + alphabet + " is a CONSONANT.");
		}
		else 
		{
			System.out.println("Given Character"  +alphabet + " is not alphabetical Character");
		}
	}
}
