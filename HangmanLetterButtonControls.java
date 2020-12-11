import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * Subclass to LetterButtonControls for a minor aesthetic problem
 */
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView
{
   // properties

   // constructors
   public HangmanLetterButtonControls( String letters, int rows, int cols, Hangman ref)
   {
      super( letters, rows, cols, ref);
   }

   // methods
   public void updateView( Hangman ref)
   {
      if (ref.isGameOver() ) // Enables all buttons when game is over
         setEnabledAll( true);
      else // Disables pressed button through the game
         setDisabled( ref.getUsedLetters() );
   }
}