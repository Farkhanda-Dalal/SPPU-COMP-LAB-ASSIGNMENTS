public class CalculatorController {
    public Decimal num1 { get; set; }
    public Decimal num2 { get; set; }
    public Decimal result { get; set; }

    // Addition
    public void add() {
        result = num1 + num2;
    }

    // Subtraction
    public void subtract() {
        result = num1 - num2;
    }

    // Multiplication
    public void multiply() {
        result = num1 * num2;
    }

    // Division with error handling
    public void divide() {
        if (num2 == 0) {
            ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, 'Cannot divide by zero'));
        } else {
            result = num1 / num2;
        }
    }

    // Power function (num1^num2) using logarithm-based formula
    public void power() {
        if (num1 <= 0 && num2 != Math.floor(num2)) {
            ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, 'Invalid power operation!'));
            return;
        }
        result = Math.exp(num2 * Math.log(num1));
    }

    // Square Root of num1
    public void squareRoot() {
        if (num1 < 0) {
            ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, 'Cannot calculate square root of a negative number'));
        } else {
            result = Math.sqrt(num1);
        }
    }

    // Logarithm base 10 (log10)
    public void logBase10() {
        if (num1 <= 0) {
            ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, 'Logarithm is not defined for zero or negative numbers'));
        } else {
            result = Math.log10(num1);
        }
    }

    // Natural Logarithm (ln, base e)
    public void naturalLog() {
        if (num1 <= 0) {
            ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, 'Natural logarithm is not defined for zero or negative numbers'));
        } else {
            result = Math.log(num1);
        }
    }

    // Sine of num1 (in degrees) - FIXED
    public void sine() {
        result = Math.sin(num1 * (Math.PI / 180));
    }

    // Cosine of num1 (in degrees) - FIXED
    public void cosine() {
        result = Math.cos(num1 * (Math.PI / 180));
    }

    // Tangent of num1 (in degrees) - FIXED
    public void tangent() {
        result = Math.tan(num1 * (Math.PI / 180));
    }
}
