public class CurrencyConverterController {
    public Decimal amount { get; set; }
    public String fromCurrency { get; set; }
    public String toCurrency { get; set; }
    public String result { get; set; }

    // Hardcoded exchange rates (relative to USD)
    public static Map<String, Decimal> exchangeRates = new Map<String, Decimal>{
        'USD' => 1.0,
        'EUR' => 0.85,
        'INR' => 83.0,
        'GBP' => 0.75,
        'JPY' => 110.0
    };

    public CurrencyConverterController() {
        amount = 0;
        fromCurrency = 'USD';
        toCurrency = 'INR';
        result = '';
    }

    public void convertCurrency() {
        if (fromCurrency == toCurrency) {
            result = 'Converted Amount: ' + amount + ' ' + toCurrency;
            return;
        }

        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            result = 'Error: Unsupported currency selected.';
            return;
        }

        Decimal usdAmount = amount / exchangeRates.get(fromCurrency);
        Decimal convertedAmount = usdAmount * exchangeRates.get(toCurrency);
        result = 'Converted Amount: ' + String.valueOf(convertedAmount.setScale(2)) + ' ' + toCurrency;
    }

    public List<SelectOption> getCurrencyOptions() {
        List<SelectOption> options = new List<SelectOption>();
        for (String curr : exchangeRates.keySet()) {
            options.add(new SelectOption(curr, curr));
        }
        return options;
    }
}
