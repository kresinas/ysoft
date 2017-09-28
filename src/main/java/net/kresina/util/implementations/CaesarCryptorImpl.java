package net.kresina.util.implementations;

import net.kresina.util.enums.CryptorName;
import net.kresina.util.interfaces.Cryptor;

public class CaesarCryptorImpl implements Cryptor {

    public static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    public CryptorName getName() {
        return CryptorName.CAESAR;
    }

    public String encrypt(String s) {
        return NOT_IMPLEMENTED_YET;
    }

    public String decrypt(String s) {
        return NOT_IMPLEMENTED_YET;
    }
}
