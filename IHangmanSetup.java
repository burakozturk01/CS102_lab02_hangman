/**
 * @(#)IHangmanSetup.java
 *
 *
 * @author
 * @version 1.00 2020/12/3
 */


public interface IHangmanSetup {
    String version = "v1.0";

    int getMaxAllowedIncorrectTries();

    char getBlankChar();

    String getCharsToPreserve();

    String getAllLetters();

    String chooseSecretWord();
}