import java.util.Locale;

public class CesarCipher {
    public static String encrypt(String text, String alphabet, int key) {
        alphabet = alphabet.toLowerCase(Locale.forLanguageTag("UA"));
        char [] alphabetArray = alphabet.toCharArray();
        text = text.toLowerCase(Locale.forLanguageTag("UA"));
        char [] textArray = text.toCharArray();
        int marker = 0;
        // Кодування текстового рядку Цезаревим шифром
        for (int i = 0; i < textArray.length; i++) {
            for (int j = 0; j < alphabetArray.length; j++) {
                if(textArray[i] == alphabetArray[j]) {
                    marker = j;
                    marker = (marker + key) % alphabetArray.length;
                    textArray[i] = alphabetArray[marker];
                    break;
                }
            }
        }
        formatting(textArray);
        text = new String(textArray);
        return text;
    }
    public static String decrypt(String text, String alphabet, int key) {
        alphabet = alphabet.toLowerCase(Locale.forLanguageTag("UA"));
        char [] alphabetArray = alphabet.toCharArray();
        text = text.toLowerCase(Locale.forLanguageTag("UA"));
        char [] textArray = text.toCharArray();
        int marker = 0;
        for (int i = 0; i < textArray.length; i++) {
            for (int j = 0; j < alphabetArray.length; j++) {
                if(textArray[i] == alphabetArray[j]) {
                    marker = j;
                    marker = (marker - key + alphabetArray.length) % alphabetArray.length;
                    textArray[i] = alphabetArray[marker];
                    break;
                }
            }
        }
        formatting(textArray);
        text = new String(textArray);
        return text;
    }
    public static void formatting (char [] textArray) {
        boolean capitalizeNext = false;
        textArray[0] = Character.toUpperCase(textArray[0]);
        for (int i = 1; i < textArray.length; i++) {
            char c = textArray[i];
            if (c == '.' || c == '?' || c == '!') {
                capitalizeNext = true;
            } else if (capitalizeNext && Character.isLetter(c)) {
                textArray[i] = Character.toUpperCase(c);
                capitalizeNext = false;
            }
        }
    }
}
