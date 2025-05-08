public class AreaCalculatorController {
    public String selectedShape { get; set; }
    public Decimal input1 { get; set; }
    public Decimal input2 { get; set; }
    public String result { get; set; }

    public AreaCalculatorController() {
        selectedShape = 'Circle';
        result = '';
    }

    public void calculateArea() {
        Decimal area = 0;

        try {
            if (selectedShape == 'Circle') {
                area = Math.PI * input1 * input1;
                result = 'Area of Circle: ' + area.setScale(2);
            } else if (selectedShape == 'Rectangle') {
                area = input1 * input2;
                result = 'Area of Rectangle: ' + area.setScale(2);
            } else if (selectedShape == 'Triangle') {
                area = 0.5 * input1 * input2;
                result = 'Area of Triangle: ' + area.setScale(2);
            } else if (selectedShape == 'Square') {
                area = input1 * input1;
                result = 'Area of Square: ' + area.setScale(2);
            } else {
                result = 'Unknown shape selected.';
            }
        } catch (Exception e) {
            result = 'Error in input. Please enter valid numeric values.';
        }
    }

    public List<SelectOption> getShapeOptions() {
        return new List<SelectOption>{
            new SelectOption('Circle', 'Circle'),
            new SelectOption('Rectangle', 'Rectangle'),
            new SelectOption('Triangle', 'Triangle'),
            new SelectOption('Square', 'Square')
        };
    }

    public Boolean getShowSecondInput() {
        return selectedShape == 'Rectangle' || selectedShape == 'Triangle';
    }

    public String getInput1Label() {
        if (selectedShape == 'Circle') return 'Radius';
        if (selectedShape == 'Rectangle') return 'Length';
        if (selectedShape == 'Triangle') return 'Base';
        if (selectedShape == 'Square') return 'Side';
        return 'Input 1';
    }

    public String getInput2Label() {
        if (selectedShape == 'Rectangle') return 'Breadth';
        if (selectedShape == 'Triangle') return 'Height';
        return 'Input 2';
    }
}
