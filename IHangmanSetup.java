
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public interface IHangmanSetup {
    String version = "v1.0";

    int getMaxAllowedIncorrectTries();

    char getBlankChar();

    String getCharsToPreserve();

    String getAllLetters();

    String chooseSecretWord();
}
