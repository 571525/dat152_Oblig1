package utils;

import java.util.Hashtable;

public class Romanizer {
    private Hashtable<Integer, Character> map = new Hashtable<Integer, Character>(7);

    public Romanizer() {
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
    }


    public String convertDecimalToRoman(int value) throws IllegalArgumentException {
        try {
            int decimal = value;
            if (decimal <= 0)
                throw new IllegalArgumentException();

            if (decimal > 3000)
                throw new IllegalArgumentException();

            String romanNumeral = new String("");
            int base1 = 1000, base2 = 5000;
            while (decimal > 0) {
                Character symbol2, symbol1;

                symbol2 = map.get(base2);
                while (symbol2 != null && decimal >= base2) {
                    decimal -= base2;
                    romanNumeral += symbol2;
                }

                symbol1 = map.get(base1);
                if (symbol1 != null && symbol2 != null && decimal >= base2 - base1) {
                    decimal -= base2 - base1;
                    romanNumeral += symbol1;
                    romanNumeral += symbol2;
                }

                while (symbol1 != null && decimal >= base1) {
                    decimal -= base1;
                    romanNumeral += symbol1;
                }

                symbol2 = map.get(base1 / 10);
                if (symbol1 != null && symbol2 != null && decimal >= base1 - base1 / 10) {
                    decimal -= base1 - base1 / 10;
                    romanNumeral += symbol2;
                    romanNumeral += symbol1;
                }
                base1 /= 10;
                base2 /= 10;
            }

            return romanNumeral;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}