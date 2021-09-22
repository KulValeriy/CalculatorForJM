package Calc;


import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите арифметическую операцию");
        Scanner scanner = new Scanner(System.in);
        String str1;
        String str2;
        String operator;
        String input;
        int int1;
        int int2;

        while (!(input = scanner.nextLine()).equals("")) {
            String[] parts = Convert.inputToData(input);
            Valid.isInputDataValid(parts);
            str1 = parts[0];
            operator = parts[1];
            str2 = parts[2];

            if (Valid.isArabian(str1, str2)) {
                int1 = Integer.parseInt(str1);
                int2 = Integer.parseInt(str2);
                System.out.println(operation(int1, operator, int2));
            } else if (Valid.isRoman(str1, str2)) {
                Map <String, Integer> romanNumbers = IntData.getRomanToArabicMap();
                int1 = romanNumbers.get(str1);
                int2 = romanNumbers.get(str2);
                int result = operation(int1, operator, int2);
                System.out.println(Convert.toRoman(result));
            } else {
                throw new RuntimeException("\nВведенные значения не соответствуют условиям.\n" +
                        "Калькулятор умеет работать только с арабскими или римскими цифрами одновременно в диапазоне от 1 до 10 включительно.\n" +
                        "Введите арабские или римские цифры");
            }
        }
    }

    public static int operation(int a, String s, int b) {
        switch (s) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new RuntimeException("\nВведенный операнд не соответствует условиям.\n" +
                        "Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.\n" +
                        "Введите: -, +, *, /");
        }
    }
}
