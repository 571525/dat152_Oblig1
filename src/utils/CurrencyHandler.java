package utils;

import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;
import java.text.NumberFormat;

public class CurrencyHandler {

    public static String convertToCorrectCurrency(ResourceBundle current, double inEuros) {

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(current.getLocale());

        if (current.getLocale().equals(new Locale("en"))) {
            double usd = inEuros*1.1;
            return "$"+ numberFormat.format(usd);
        } else if (current.getLocale().equals(new Locale("nb"))){
            double nok = inEuros * 9.87;
            return numberFormat.format(nok) + " kr.";
        }
        return numberFormat.format(inEuros) + " €";
    }
}
