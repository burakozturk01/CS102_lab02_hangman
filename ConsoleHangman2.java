import java.util.Scanner;
//import cs102.*;

/**
 * ConsoleHangman2
 *
 * @author
 * @version 1.00 2013/4/7
 */

public class ConsoleHangman2
{
    public static void main( String[] args)
	{
    	Scanner scan = new Scanner( System.in);

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		HangmanModel hangman;
		String  c;
		int     result;

		// PROGRAM CODE
		hangman = new HangmanModel( new BasicSetup() );
		hangman.addView( new ConsoleHangmanView());

		System.out.println( hangman.getKnownSoFar() );

		// allow user to repeatedly enter a letter and tryThis letter
		// then show game status, until gameover. Finally report win/lose.

		// While the game hasn't finished, ask the user for char

		do {
			// Ask for and scan the letter
			System.out.print( "Enter a letter: ");
	      	c = scan.nextLine();

	      	// Check validity and tryThis
	      	if ( c == null || c.isEmpty())
	        	System.out.println( "Empty input is forbidden.");
	      	else
	        	result = hangman.tryThis( c.charAt(0));


		} while ( !hangman.isGameOver() );

		System.out.println( "\nEnd of ConsoleHangman\n" );
	}

} // end of class ConsoleHangman
