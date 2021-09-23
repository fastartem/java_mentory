import java.util.Locale;

public class RomanNumOperations {

    enum Number {
        I,
        II,
        III,
        IV,
        V,
        VI,
        VII,
        VIII,
        IX,
        X
    }

    public static int getArabicNumber(String romanNumber) {
        switch (romanNumber) {
            case ("I"):
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new ArithmeticException("Illegal roman number");
        }
    }

    private static String getRomanNumber(int arabicNumber) {
        switch (arabicNumber) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            default:
                throw new ArithmeticException("Illegal roman number");
        }
    }

    public static String calculate(int op1, int op2, String operator) {
        switch (operator) {
            case ("-"):
                return RomanNumOperations.getRomanNumber(op1 - op2);
            case ("+"):
                return RomanNumOperations.getRomanNumber(op1 + op2);
            case ("*"):
                return RomanNumOperations.getRomanNumber(op1 * op2);
            case ("/"):
                return RomanNumOperations.getRomanNumber(op1 / op2);
            default:
                throw new ArithmeticException("Illegal operation");
        }
    }

    public static Boolean isRoman(String op1, String op2) {
        boolean result = false;

        for (Number num : Number.values()) {
            if (op1.equals(num.toString())) result = true;
        }

        if (result == true) {
            for (Number num : Number.values()) {
                if (op2.equals(num.toString())) return true;
            }
        }

        return false;
    }
}
