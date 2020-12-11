import java.util.ArrayList;

/**
 * @(#)HangmanModel.java
 *
 *
 * @author
 * @version 1.00 2020/12/3
 */


public class HangmanModel extends Hangman {

	// properties
    ArrayList<IHangmanView> views;

    // constructor
    public HangmanModel(IHangmanSetup setup) {
    	this.setup = setup;
        this.initNewGame();
    	views = new ArrayList<IHangmanView>();
    }

    // methods
    public void addView( IHangmanView view) { views.add(view); }

    public void update()
    {
    	for ( int i = 0; i < views.size(); i++)
    		views.get(i).updateView(this);
    }

    // Overridden methods

    // update(); statement before every return statement
    @Override
    public int tryThis(char letter) {
    	if (isGameOver()) { return -1; }

    	else if (existsIn(usedLetters, letter)) { update(); return -2; }

    	else if (charsToPreserve.indexOf(letter) >= 0) { update(); return -4; }

    	else if (!existsIn(allLetters, letter)) { update(); return -3; }

    	else
    	{
            int timesFound = 0;

            for(int i = 0; i < secretWord.length(); ++i) {
                if (Character.toUpperCase(secretWord.charAt(i)) == Character.toUpperCase(letter))
                {
                    knownSoFar.setCharAt(i, secretWord.charAt(i));
                    ++timesFound;
                }
            }

            usedLetters.append(letter);
            if (timesFound == 0) {
                ++numberOfIncorrectTries;
            }

            if (hasLost()) {
                knownSoFar = secretWord;
            }

            update();
            return timesFound;
    	}
    }

	@Override
    public void initNewGame() {
        maxAllowedIncorrectTries = setup.getMaxAllowedIncorrectTries();

        blankChar = setup.getBlankChar();

        charsToPreserve = setup.getCharsToPreserve();

        allLetters = new StringBuffer( setup.getAllLetters());

        secretWord = new StringBuffer( setup.chooseSecretWord());

        knownSoFar = new StringBuffer();

        for(int i = 0; i < secretWord.length(); ++i)
        {
            if (charsToPreserve.indexOf( secretWord.charAt(i) ) >= 0 )
            {
                knownSoFar.append( secretWord.charAt(i) );
           	}
            else
            {
                knownSoFar.append( blankChar);
            }
        }

        usedLetters = new StringBuffer();

        numberOfIncorrectTries = 0;

        update(); //Only change
    }

	// Added again because super is private
    private boolean existsIn(StringBuffer s, char c) {
        for(int i = 0; i < s.length(); ++i)
            if (Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(c)) return true;
		return false;
	}
}