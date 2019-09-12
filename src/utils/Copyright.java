package utils;

import java.util.Calendar;

public class Copyright {
    private String cpr = "<c>";
    private String HVL = "Høgskolen i Bergen";
    private String startYearRoman;
    private String currentYearRoman;
    private Romanizer romanizer;

    public Copyright() {
        int startyear = 2008;
        romanizer = new Romanizer();
        startYearRoman = romanizer.convertDecimalToRoman(startyear);
    }

    public void printCopyright() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        currentYearRoman = romanizer.convertDecimalToRoman(currentYear);

        System.out.println(cpr + " " + startYearRoman +"-"+currentYearRoman + " "+ HVL);
    }

}
