import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            String[] expression = getExpression();
            String operator = expression[1];
            int op1, op2;

            // если оба числа римские
            if (RomanNumOperations.isRoman(expression[0], expression[2])) {
                op1 = RomanNumOperations.getArabicNumber(expression[0]);
                op2 = RomanNumOperations.getArabicNumber(expression[2]);
                System.out.println(RomanNumOperations.calculate(op1, op2, operator));
            }
            // если оба числа арабские
            else {
                try {
                    op1 = Integer.parseInt(expression[0]);
                    op2 = Integer.parseInt(expression[2]);

                    if (op1 > 10 || op2 > 10) {
                        throw new ArithmeticException("Operand > 10");
                    }
                    System.out.println(ArabicNumOperations.calculate(op1, op2, operator));
                } catch (NumberFormatException e) {
                    throw new ArithmeticException("Operands mismatch");
                }
            }
        }
    }

    private static String[] getExpression() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String nextLine = in.nextLine();
        String string = (nextLine.replaceAll("\\s{2,}", " ").trim()).toUpperCase(Locale.ROOT);
        String[] expression = string.split("\\s");

        if (expression.length != 3) throw new ArithmeticException("Illegal operands number");

        return expression;
    }
}



