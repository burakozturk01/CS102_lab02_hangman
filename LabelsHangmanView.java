import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * New GUI design to replace HangmanConsoleView
 */
public class LabelsHangmanView extends JPanel implements IHangmanView
{
   // properties
   Hangman ref;

   JLabel numOfIncorrectTries;
   JLabel knownSoFar;
   JLabel usedLetters;
   JLabel gameOver;
   JLabel allLetters;

   boolean hasLost;
   boolean isGameOver;

   // constructors
   public LabelsHangmanView( Hangman ref)
   {
      this.ref = ref;

      setLayout( new BoxLayout( this, BoxLayout.PAGE_AXIS) );
      setBackground( Color.GREEN);
      setPreferredSize( new Dimension( 180, 350) );

      // Creates and adds JLabels to JPanel
      numOfIncorrectTries = new JLabel();
      add( numOfIncorrectTries);

      add( new JLabel(" "));

      knownSoFar = new JLabel();
      add( knownSoFar);

      add( new JLabel(" "));

      usedLetters = new JLabel();
      add( usedLetters);

      add( new JLabel(" "));

      gameOver = new JLabel();
      add( gameOver);

      add( new JLabel(" "));

      add( new JLabel("All letters:"));
      allLetters = new JLabel( ref.getAllLetters());
      add( allLetters);

      updateView( ref);
   }

   // methods
   @Override // Updates the texts
   public void updateView( Hangman ref)
   {
      numOfIncorrectTries.setText( "Incorrect tries: " + ref.getNumOfIncorrectTries());
      knownSoFar.setText( "Known so far:\n" + ref.getKnownSoFar());
      usedLetters.setText( "Used letters: " + ref.getUsedLetters());

      isGameOver = ref.isGameOver();
      hasLost = ref.hasLost();

      if ( !isGameOver)
         gameOver.setText( "Ongoing game");
      else if ( hasLost)
         gameOver.setText( "Game over, you lost :(");
      else
         gameOver.setText( "Game over, you won !!");
   }
}