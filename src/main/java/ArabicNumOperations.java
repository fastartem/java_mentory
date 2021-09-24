import java.util.List;

public class ArabicNumOperations {

    public static int calculate(int op1, int op2, String operator) {
        switch (operator) {
            case ("-"):
                return op1 - op2;
            case ("+"):
                return op1 + op2;
            case ("*"):
                return op1 * op2;
            case ("/"):
                return op1 / op2;
            default:
                throw new ArithmeticException("Illegal operation");
        }
    }

}
