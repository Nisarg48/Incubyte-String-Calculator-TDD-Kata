package org.nisarg;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // A string of comma-separated numbers
    public int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }

        String[] nums = numbers.split("[\n,]");
        int sum = 0;
        List<String> negativeNumbers = new ArrayList<String>();

        for(String num : nums) {
            int n = Integer.parseInt(num);
            if(n < 0) {
                negativeNumbers.add(num);
            }
            else {
                if(n < 1000) {
                    sum += n;
                }
            }
        }

        if(!negativeNumbers.isEmpty()) {
            throw new RuntimeException("negative numbers not allowed " + negativeNumbers);
        }

        return sum;
    }

    // A String with Delimiter and Numbers
    public int DelimiterWithNumbers(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";
        String inputNumbers = numbers;

        if(numbers.startsWith("//")) {
            String[] input = numbers.split("\n");
            if(input.length < 2) {
                throw new IllegalArgumentException("Invalid Input.");
            }

            delimiter = input[0].substring(2);
            inputNumbers = input[1];
        }
        int sum = 0;
        String[] nums = inputNumbers.split(delimiter);

        for(String num : nums) {
            if(!num.trim().isEmpty()) {
                sum += Integer.parseInt(num);
            }
        }

        return sum;
    }

    public int DelimiterWithAnyLength(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";
        String inputNumbers = numbers;

        if(numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//\\[(.+)]\\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                delimiter = matcher.group(1);
                inputNumbers = matcher.group(2);
            }
            else {
                throw new IllegalArgumentException("Invalid Input.");
            }
        }

        int sum = 0;
        String[] nums = inputNumbers.split(Pattern.quote(delimiter));

        for(String num : nums) {
            if(!num.trim().isEmpty()) {
                sum += Integer.parseInt(num);
            }
        }
        return sum;
    }

    public int addWithMultipleCustomDelimiter(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // default
        String inputNumbers = numbers;

        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(\\[(.+?)])+\\n(.*)", Pattern.DOTALL).matcher(numbers);
            if (matcher.find()) {
                String delimiterPart = numbers.substring(2, numbers.indexOf("\n"));
                inputNumbers = numbers.substring(numbers.indexOf("\n") + 1);

                Matcher delimMatcher = Pattern.compile("\\[(.+?)\\]").matcher(delimiterPart);
                List<String> delimList = new ArrayList<>();

                while (delimMatcher.find()) {
                    delimList.add(Pattern.quote(delimMatcher.group(1)));
                }

                delimiter = String.join("|", delimList);
            } else {
                throw new IllegalArgumentException("Invalid input.");
            }
        }

        int sum = 0;
        String[] nums = inputNumbers.split(delimiter);

        for (String num : nums) {
            if (!num.trim().isEmpty()) {
                sum += Integer.parseInt(num.trim());
            }
        }

        return sum;
    }
}
