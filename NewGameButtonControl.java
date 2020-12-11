

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Button for hangman game
 */
public class NewGameButtonControl extends JButton implements ActionListener, IHangmanView
{
   // properties
   Hangman ref;

   // constructors
   public NewGameButtonControl( Hangman ref)
   {
      this.ref = ref;

      setText( "New Game");

      addActionListener( this);

      updateView( ref);
   }

   // methods
   public void actionPerformed( ActionEvent e)
   {
      ref.initNewGame();
      updateView( ref);
   }

   public void updateView( Hangman ref)
   {
      // With this if condition, button is only activated while game is ongoing
      setEnabled( ref.isGameOver());
   }
}