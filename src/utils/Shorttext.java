package utils;

public class Shorttext {
    public static String makeShortText(String longtext) {
        if (longtext.length() < 10) return longtext;
        return longtext.substring(0,10)+"...";
    }
}
