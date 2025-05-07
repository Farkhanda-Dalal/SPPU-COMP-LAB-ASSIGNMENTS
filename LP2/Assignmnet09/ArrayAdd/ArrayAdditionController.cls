public class ArrayAdditionController {
    public String inputArray1 { get; set; }
    public String inputArray2 { get; set; }
    public String result { get; set; }

    public ArrayAdditionController() {
        inputArray1 = '';
        inputArray2 = '';
        result = '';
    }

    public void addArrays() {
        try {
            List<String> arr1Str = inputArray1.split(',');
            List<String> arr2Str = inputArray2.split(',');
            Integer len = Math.min(arr1Str.size(), arr2Str.size());

            List<Integer> resultArray = new List<Integer>();

            for (Integer i = 0; i < len; i++) {
                Integer num1 = Integer.valueOf(arr1Str[i].trim());
                Integer num2 = Integer.valueOf(arr2Str[i].trim());
                resultArray.add(num1 + num2);
            }

            result = 'Result: ' + String.join(resultArray, ', ');
        } catch (Exception e) {
            result = 'Error: Please enter valid comma-separated numbers.';
        }
    }
}
