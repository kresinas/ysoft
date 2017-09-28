package net.kresina.util.implementations;

import net.kresina.util.enums.CryptorName;
import net.kresina.util.interfaces.Cryptor;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MorseCryptorImpl implements Cryptor {

    public static final String TEXT_DELIMITER = "";

    public static final String MORSE_DELIMITER = " ";

    public static String[] alpha = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " " };

    public static String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "|" };

    public static Map<String, String> AtoM= new HashMap<String, String>();
    public static Map<String, String> MtoA= new HashMap<String, String>();

    {
        for (int a = 0; a < alpha.length; a++) {
            AtoM.put(alpha[a], morse[a]);
            MtoA.put(morse[a], alpha[a]);
        }
    }

    public CryptorName getName() {
        return CryptorName.MORSE;
    }

    public String encrypt(String s) {
        return process(s, AtoM, TEXT_DELIMITER, MORSE_DELIMITER);
    }

    public String decrypt(String s) {
        return process(s, MtoA, MORSE_DELIMITER, TEXT_DELIMITER);
    }

    private String process(String message, Map<String, String> mapper, String delimiter, String resultDelimiter) {
        message = message.toLowerCase(Locale.getDefault());
        String[] split = message.split(delimiter);

        StringBuffer ret = new StringBuffer();
        for (String token : split) {
            ret.append(resultDelimiter);
            ret.append(mapper.get(token) == null ? token : mapper.get(token));
        }
        return ret.toString();
    }
}
