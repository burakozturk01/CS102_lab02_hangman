import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * Listener class for virtual keyboard
 */
public class HangmanLetterButtonsController implements ActionListener
{
   // properties
   Hangman ref;
   String letters;
   int count;

   // constructors
   public HangmanLetterButtonsController( Hangman ref)
   {
      this.ref = ref;

      letters = ref.getAllLetters();
      count = letters.length();
   }

   // methods
   public void actionPerformed( ActionEvent e)
   {
      // Tries the letter on the pressed button
      char pressed = ( (JButton) e.getSource()).getText().charAt( 0 );
      ref.tryThis( pressed);

      // Disables the button
      ( (JButton) e.getSource()).setEnabled( false);

      // Enables all the button when the game ends
      if ( ref.isGameOver() )
         ( (LetterButtonControls) ( (JButton) e.getSource()).getParent()).setEnabledAll( true);
   }
}