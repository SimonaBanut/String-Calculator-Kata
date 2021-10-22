package StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculatorS {

    public static int add(String text) {
        String[] numb = numbs(text);
        List<Integer> numbers = Stream.of(numb).map(Integer::parseInt).collect(Collectors.toList());
        verifNotNegativeNumber(numbers);
        return sum(numbers);
    }

    private static String[] numbs(String text) {
        if (text.isEmpty()){
            return new String[0];
        } else if (text.startsWith("//")){
            return splitusingCustomerDelimiters(text);
        }else {
            return splitusingNewLineandComma(text);
        }
    }

    private static String[] splitusingNewLineandComma(String text) {
           String[] numb = text.split(",|\n");
            return numb ;

    }

    private static String[] splitusingCustomerDelimiters(String text) {
        Matcher m= Pattern.compile("//(.)\n(.*)").matcher(text);
        m.matches();
        String customDelimiter = m.group(1);
        String numbers = m.group(2);
        return numbers.split(Pattern.quote(customDelimiter));
    }

    private static int sum(List<Integer> numbers) {
        int summ = 0;
        for (int i = numbers.size() - 1; i >= 0; i--)
            summ += numbers.get(i) % 1000;
        return summ;
    }

    private static void verifNotNegativeNumber(List<Integer> numbers) {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        numbers.stream().forEach(i -> (i < 0 ? negatives : positives ).add(i));
         if (negatives.size()>0){
            throw new RuntimeException("Negatives not allowed:" + negatives);
        }
    }

    //transfer String in Integer;
    private static int transfInt(String text) {
        return Integer.parseInt(text);
    }
}
