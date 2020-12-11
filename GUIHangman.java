
import java.awt.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");

		HangmanModel		hangman;
		IHangmanSetup		basicSetup;
		ConsoleHangmanView	consoleView;

		TextFieldControlPanel tfcp;
		NewGameButtonControl ngbc;
		LabelsHangmanView lhv;
		GallowsHangmanView ghv;
		HangmanLetterButtonControls hlbc;

		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);

		consoleView = new ConsoleHangmanView();
		hangman.addView( consoleView);

		tfcp = new TextFieldControlPanel( hangman );

		ngbc = new NewGameButtonControl( hangman );

		lhv = new LabelsHangmanView( hangman );
		hangman.addView( lhv);

		ghv = new GallowsHangmanView( hangman );
		hangman.addView ( ghv);

		hlbc = new HangmanLetterButtonControls ( hangman.getAllLetters(), 13, 2, hangman);

		new SimpleJFrame( "GUIHangman", 	// title
							ghv,			// center
							tfcp, ngbc,		// north, south
							hlbc, lhv );	// east, west

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
