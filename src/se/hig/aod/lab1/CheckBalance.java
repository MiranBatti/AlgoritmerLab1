package se.hig.aod.lab1;

import java.util.Scanner;

/**
 * En klass som använder sig av en stack för att kontrollera parentesuttryck.
 * 
 * @author Magnus Blom
 * @author Peter Jenke
 * @author Miran Batti
 * @author Fredrik Lindorf
 * @version 2014-01-16
 */
public class CheckBalance
{
	public static boolean isBalanced (String uttryck)
	{
		Stack<Character> charStack = new ListStack<Character> (); // Skapa en ny
																	// stack
		boolean balanserad = true; // anta att uttrycket är balanserat
		StringBuilder sb = new StringBuilder();
		sb.append(uttryck);

		// Kod enligt algoritmen-beskrivning på s. 4
		while(balanserad && sb.length() != 0) {
			char symbol = sb.charAt(0);
			sb.deleteCharAt(0);
			if(symbol == '(')
				charStack.push((symbol));
			else if(symbol == ')') 
				if(!charStack.isEmpty())
					charStack.pop();
				else
					balanserad = false;
		}
		if(balanserad == true && !charStack.isEmpty())
			balanserad = false;
		charStack.clear();		
		return balanserad;
	}

	public static void main (String[] args)
	{
		Scanner console = new Scanner (System.in);
		for (int i = 0; i < 4; i++)
		{
			System.out.print ("Mata in ett parentesuttryck: ");
			String uttryck = console.next ();
			if (isBalanced (uttryck))
				System.out.println ("Strängen är parentesbalanserad!");
			else
				System.out.println ("Strängen är INTE parentesbalanserad!");
		}
		console.close ();
	}
} // end of class CheckBalance
