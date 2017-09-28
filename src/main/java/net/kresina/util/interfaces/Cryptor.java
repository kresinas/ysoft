package net.kresina.util.interfaces;

import net.kresina.util.enums.CryptorName;

public interface Cryptor {

    CryptorName getName(); // not really used
    String encrypt(String s);
    String decrypt(String s);
}
