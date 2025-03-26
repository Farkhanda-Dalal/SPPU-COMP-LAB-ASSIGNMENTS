public class CalculatorController {
    public Decimal num1 { get; set; }
    public Decimal num2 { get; set; }
    public Decimal result { get; set; }

    public void add() {
        result = num1 + num2;
    }

    public void subtract() {
        result = num1 - num2;
    }

    public void multiply() {
        result = num1 * num2;
    }

    public void divide() {
        if (num2 == 0) {
            ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, 'Cannot divide by zero'));
        } else {
            result = num1 / num2;
        }
    }

    public void square() {
        result = num1 * num1;
    }

    public void power() {
        result = num1.pow(num2.intValue()); // Using Decimal.pow() correctly
    }
}
