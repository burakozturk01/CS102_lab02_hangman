/**
 * @(#)MySetup.java
 *
 *
 * @author
 * @version 1.00 2020/12/4
 */


public class BasicSetup implements IHangmanSetup
{
	private static String[] words = { "Python", "Zelda", "Interdimensional",
	"Application", "Burak Ozturk", "Potato", "Hyperoptic Vascular Freezer"};

	public int getMaxAllowedIncorrectTries()
	{
		return 6;
	}

	public char	getBlankChar()
	{
		return '*';
	}

	public String getCharsToPreserve()
	{
		return " ";
	}

	public String getAllLetters()
	{
		return "abcdefghijklmnopqrstuvwxyz";
	}

	public String chooseSecretWord()
	{
		int random = (int) (Math.random() * words.length );
		return words[ random];
	}
}