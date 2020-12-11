import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * control class for hangman gui game
 */
public class TextFieldControlPanel extends JPanel implements ActionListener
{
   // properties
   Hangman ref;
   JTextField text;
   char[] allLetters;

   // constructors
   public TextFieldControlPanel( Hangman ref)
   {
      this.ref = ref;
      text = new JTextField( "Write letters here");
      text.setPreferredSize( new Dimension( 120, 20) );
      add( text);

      // Extra functionality
      // Extracting all the chars from string to try all of them seperately
      String tmp = ref.getAllLetters();
      allLetters = new char[ tmp.length()];

      for ( int i = 0; i < tmp.length(); i++)
         allLetters[i] = tmp.charAt(i);

      text.addActionListener( this);

      // Extra user-friendliness
      // Low tech ghost-text imitation
      text.addMouseListener( new MouseAdapter() {
         public void mouseClicked( MouseEvent e){
            text.setText("");
         }
      });
   }

   // methods
   // Tries all chars in the given String
   public void actionPerformed( ActionEvent e)
   {
      String tmp2 = text.getText();

      if ( tmp2 != null)
      {
         for ( int i = 0; i < tmp2.length(); i++)
         {
            for ( char letter : allLetters)
            {
               if ( tmp2.charAt(i) == letter)
                  ref.tryThis( letter);
            }
         }
      }

      text.setText("");
   }
}