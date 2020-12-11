import java.util.Scanner;
//import cs102.*;

/**
 * ConsoleHangman
 *
 * @author
 * @version 1.00 2013/4/7
 */

public class ConsoleHangman
{
    public static void main( String[] args)
	{
    	Scanner scan = new Scanner( System.in);

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		Hangman hangman;
		String  c;
		int     result;

		// PROGRAM CODE
		hangman = new Hangman( new BasicSetup() );

		System.out.println( hangman.getKnownSoFar() );

		// ToDo - allow user to repeatedly enter a letter and tryThis letter
		//		  then show game status, until gameover. Finally report win/lose.

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

	        System.out.println( "Used letters: " + hangman.getUsedLetters() );
	      	System.out.println( "Known letters: " + hangman.getKnownSoFar() );
	      	System.out.println( "Remaining tries: " + (hangman.getMaxAllowedIncorrectTries() -  hangman.getNumOfIncorrectTries()));
		} while ( !hangman.isGameOver() );

		if ( hangman.hasLost() )
	    	System.out.println( "You lost" );

	    else
	    	System.out.println( "You won" );


		System.out.println( "\nEnd of ConsoleHangman\n" );
	}

} // end of class ConsoleHangman
