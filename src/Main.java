import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.println(calc(text));
    }

    public static String calc(String input) throws IOException{
        int result = 0;
        int j = 0;
        String[] arrayOfNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);

        String[] operands = input.split("[*\\-+/]");
        String operation = findOperation(input);
        if (operation == null) throw new IOException("Cтрока не является математической операцией");
        if (operands.length > 2) throw new IOException("Формат математической операции не удовлетворяет заданию");
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i].equals(operands[0])) {
                j += 1;
            }
        }

        if (j == 1) {
            switch (findOperation(input)) {
                case "*" :
                    result = Integer.parseInt(operands[0]) * Integer.parseInt(operands[1]);
                    break;
                case "/" :
                    result = Integer.parseInt(operands[0]) / Integer.parseInt(operands[1]);
                    break;
                case "+" :
                    result = Integer.parseInt(operands[0]) + Integer.parseInt(operands[1]);
                    break;
                case "-" :
                    result = Integer.parseInt(operands[0]) - Integer.parseInt(operands[1]);
                    break;
            }
            if (Integer.parseInt(operands[0]) > 10 || Integer.parseInt(operands[1]) > 10) throw new IOException("Значения должы быть не больше 10");
            return String.valueOf(result);
        }
        else {
            switch (findOperation(input)) {
                case "*" :
                    result = map.get(operands[0]) * map.get(operands[1]);
                    break;
                case "/" :
                    result = map.get(operands[0]) / map.get(operands[1]);
                    break;
                case "+" :
                    result = map.get(operands[0]) + map.get(operands[1]);
                    break;
                case "-" :
                    result = map.get(operands[0]) - map.get(operands[1]);
                    break;
            }
            if (result <= 0) throw new IOException("В римской системе нет отрицательных чисел");
            return convertNumToRoman(result);
        }
    }

    static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }

    static String findOperation (String str) {
        if (str.contains("-")) return "-";
        else if (str.contains("+")) return "+";
        else if (str.contains("/")) return "/";
        else if (str.contains("*")) return "*";
        else return null;
    }
}
