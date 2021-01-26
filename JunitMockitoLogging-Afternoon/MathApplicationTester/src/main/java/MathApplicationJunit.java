public class MathApplicationJunit implements  CalculatorService{

    @Override
    public double add(double number1, double number2) {
        return number1+number2;
    }

    @Override
    public double subtract(double number1, double number2) {
        return number1-number2;
    }

    @Override
    public double multiply(double number1, double number2) {
        return number1*number2;
    }

    @Override
    public double divide(double number1, double number2) throws Exception {
        if (number2==0)
            throw new ArithmeticException("Divide by zero");
        return number1/number2;
    }
}
