import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RomanNumOperations {

    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumOperations.RomanNumeral> romanNumerals = RomanNumOperations.RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumOperations.RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static String calculate(int op1, int op2, String operator) {
        switch (operator) {
            case ("-"):
                return RomanNumOperations.arabicToRoman(op1 - op2);
            case ("+"):
                return RomanNumOperations.arabicToRoman(op1 + op2);
            case ("*"):
                return RomanNumOperations.arabicToRoman(op1 * op2);
            case ("/"):
                return RomanNumOperations.arabicToRoman(op1 / op2);
            default:
                throw new ArithmeticException("Illegal operation");
        }
    }

    public static Boolean isRoman(String op1s, String op2s) {
        int op1, op2;

        try {
            op1 = romanToArabic(op1s);
            op2 = romanToArabic(op2s);

            if (op1 > 10 || op2 > 10) {
                throw new ArithmeticException("Operand > 10");
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
