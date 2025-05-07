public class TemperatureConverterController {
    public Double inputTemperature { get; set; }
    public String conversionType { get; set; }
    public String result { get; set; }

    public TemperatureConverterController() {
        inputTemperature = 0;
        conversionType = 'CtoF'; // Default
        result = '';
    }

    public void convertTemperature() {
        if (conversionType == 'CtoF') {
            Double fahrenheit = (inputTemperature * 9/5) + 32;
            result = inputTemperature + '°C = ' + fahrenheit + '°F';
        } else if (conversionType == 'FtoC') {
            Double celsius = (inputTemperature - 32) * 5/9;
            result = inputTemperature + '°F = ' + celsius + '°C';
        } else {
            result = 'Invalid conversion type selected.';
        }
    }
}
