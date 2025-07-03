package org.nisarg;

public class StringCalculator {

    // A string of comma-separated numbers
    public int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }

        String[] nums = numbers.split(",");
        int sum = 0;
        for(String num : nums) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
