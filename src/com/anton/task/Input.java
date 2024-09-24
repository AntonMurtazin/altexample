package com.anton.task;
import java.util.Scanner;
import java.lang.String;



public class Input {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input:");
        String userInput = s.nextLine();
        String[] tokens = userInput.split("\" ");
        if(tokens.length != 2) {
            throw new IllegalArgumentException("Вы ввели некорректное выражение.");
        }
        String value1 = tokens[0].trim().replace("\"","");
        char operation = tokens[1].trim().charAt(0);
        String value2 = tokens[1].trim().substring(1).replace("\"","");
        if (value1.length() > 10 || value2.length() > 10) {
            throw new IllegalArgumentException("Длина строки не должна превышать 10 символов.");
        }

        System.out.println("Output:");
        switch(operation) {
            case '+' -> sum(value1, value2);
            case '-' -> minus(value1, value2);
            case '*' -> num(value1, value2);
            case '/' -> division(value1, value2);
            default -> throw new IllegalArgumentException("Вы ввели некорректную операцию.");
        }

    }

    public static void sum(String value1, String value2) {
        String sum = value1.trim() + value2.trim();
        String result = String.format("\"%s\"", sum);
        System.out.println(result);
    }

    public static void minus(String value1, String value2) {
        String minus = value1.replace(value2.trim(),  "");
        String result = String.format("\"%s\"", minus);
        System.out.println(result);

    }

    public static void num(String value1, String value2) {
        int number = 0;
        try {
            number = Integer.parseInt(value2.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Умножение разрешено только на число.");
        }
        if(number < 1 || number > 10) {
            throw new IllegalArgumentException("Используйте числа от 1 до 10.");
        }
        String nums = value1.repeat(number);
        String result = String.format("\"%s\"", nums);
        if (result.length() > 40) {
            result = result.substring(0, 41) + "...";
        }
        System.out.println(result);
    }

    public static void division(String value1, String value2) {
        int number = 0;
        try {
            number = Integer.parseInt(value2.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Деление разрешено только на число.");
        }
        if(number < 1 || number > 10) {
            throw new IllegalArgumentException("Используйте числа от 1 до 10.");
        }
        int division = value1.length() / number;
        String result = String.format("\"%s\"", value1.substring(0,division));
        System.out.println(result);
    }

}


