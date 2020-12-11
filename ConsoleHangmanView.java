/**
 * @(#)ConsoleHangmanView.java
 *
 *
 * @author
 * @version 1.00 2020/12/3
 */


public class ConsoleHangmanView implements IHangmanView {

    public ConsoleHangmanView() {}

    public void updateView( Hangman hangman) {
    	if (!hangman.isGameOver())
    	{
			System.out.println( "\nUsed letters: " + hangman.getUsedLetters() );
			System.out.println( "Known letters: " + hangman.getKnownSoFar() );
			System.out.println( "Remaining tries: " + (hangman.getMaxAllowedIncorrectTries() -  hangman.getNumOfIncorrectTries()) + "\n");
    	}

    	else
    	{
    		if ( hangman.hasLost() )
	    		System.out.println( "You lost" );

	    	else
	    		System.out.println( "You won" );
    	}
    }


}