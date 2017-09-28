package net.kresina.util.enums;

public enum CryptorName {

    MORSE("MorseCryptorImpl"), CAESAR("CaesarCryptorImpl");

    private String text;

    CryptorName(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

}
