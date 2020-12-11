import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Displaying hanging man
 */
public class GallowsHangmanView extends JPanel implements IHangmanView
{
   // properties
   Hangman ref;

   // constructors
   public GallowsHangmanView( Hangman ref)
   {
      this.ref = ref;

      setBackground( Color.WHITE);
      setPreferredSize( new Dimension( 200, 350) );
   }

   // methods
   @Override
   public void paintComponent( Graphics g)
   {
      super.paintComponent(g);

      int tries = ref.getNumOfIncorrectTries();

      // Drawing the gallows
      g.drawRect( 39, 23, 60, 12);
      g.fill3DRect( 39, 23, 60, 12, false);
      g.drawRect( 39, 35, 10, 164);
      g.fill3DRect( 39, 35, 10, 164, false);
      g.drawRect( 8, 199, 152, 21);
      g.fill3DRect( 8, 199, 152, 21, false);
      g.drawRect( 96, 35, 3, 18);
      g.fill3DRect( 96, 35, 3, 18, false);

      // Drawing hangman in a very unpractical but working nonetheless way
      if ( tries >= 1) {
         g.drawOval( 80, 52, 33, 37);
         if ( tries >= 2) {
            g.drawLine( 97, 89, 97, 118);
            if ( tries >= 3) {
               g.drawLine( 97, 95, 75, 101);
               if ( tries >= 4) {
                  g.drawLine( 97, 95, 118, 100);
                  if ( tries >= 5) {
                     g.drawLine( 97, 118, 78, 155);
                     if ( tries >= 6) {
                        g.drawLine( 97, 118, 118, 156);
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public void updateView( Hangman ref)
   {
      repaint();
   }
}