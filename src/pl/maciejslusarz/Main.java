package pl.maciejslusarz;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println(" KALKULATOR AUTORSTWA Maciej Slusarz, prosze o wyrozumiałość ");
        System.out.println("=============================================================");
        double currentValue = 0.0;
        while (true) {
            Scanner input = new Scanner(System.in);
            int repeats = 0;
            double a, b = 0;
            String select = "nothing";
            String[] options = {"quit", "add", "subtract", "multiply", "divide", "rest", "sinus", "cosinus", "power", "sqrt"};
            while (!Arrays.asList(options).contains(select)) {
                if (repeats > 0) {
                    System.out.println("!!! To był zły wybór, ale możesz spróbować jeszcze raz !!!");
                }
                if (currentValue > 0 || currentValue < 0) {
                    System.out.println("---- Ostatnia wartość zachowana w pamięci: " + currentValue + " ----");
                }
                System.out.println("===================================================");

                System.out.println("Co chciałbyś zrobić?");
                System.out.println("quit - Wyjście z programu");
                System.out.println("add - Dodaj dwie liczby");
                System.out.println("subtract - Odejmij od siebie dwie liczby");
                System.out.println("multiply - Pomnóż przez siebie dwie liczby");
                System.out.println("divide - Podziel przez siebie dwie liczby");
                System.out.println("rest - Calculate resztę z dzielenia wybranych liczb");
                System.out.println("sinus - Obliczenie sinusoidy");
                System.out.println("cosinus - Obliczenie cosinusoidy");
                System.out.println("power - Obliczenie potęgi");
                System.out.println("sqrt - Pierwiastek kwadratowy");
                System.out.println("===================================================");
                System.out.print("Wybierz rozsądnie: ");
                select = input.nextLine();
                repeats++;
            }

            Calculate calculated;

            if (select.equals("quit")) {
                System.exit(0);
            }

            if (currentValue > 0 || currentValue < 0) {
                System.out.print("Czy chciałbyś operować działaniem na liczbie z pamięci? (tak/nie): ");
                if (input.next().equals("tak")) {
                    a = currentValue;
                } else {
                    System.out.print("Wprowadź liczbę: ");
                    a = Double.parseDouble(input.next());
                }
            } else {
                System.out.print("Wprowadź liczbę: ");
                a = Double.parseDouble(input.next());
            }

            switch (select) {
                case "add":
                case "subtract":
                case "multiply":
                case "divide":
                case "rest":
                case "power":
                    System.out.print("Wprowadź drugą liczbę: ");
                    b = Float.parseFloat(input.next());
                    calculated = new Calculate(a, b);
                    break;
                default:
                    calculated = new Calculate(a);
                    break;
            }

            switch (select) {
                case "add":
                    currentValue = calculated.add();
                    System.out.println(a + " + " + b + " = " + currentValue);
                    break;
                case "subtract":
                    currentValue = calculated.subtract();
                    System.out.println(a + " - " + b + " = " + currentValue);
                    break;
                case "multiply":
                    currentValue = calculated.multiply();
                    System.out.println(a + " * " + b + " = " + currentValue);
                    break;
                case "divide":
                    currentValue = calculated.divide();
                    System.out.println(a + " / " + b + " = " + currentValue);
                    break;
                case "rest":
                    currentValue = calculated.rest();
                    System.out.println(a + " mod " + b + " = " + currentValue);
                    break;
                case "sinus":
                    currentValue = calculated.sinus();
                    System.out.println("sin(" + a + ") = " + currentValue);
                    break;
                case "cosinus":
                    currentValue = calculated.cosinus();
                    System.out.println("cos(" + a + ") = " + currentValue);
                    break;
                case "power":
                    currentValue = calculated.power();
                    System.out.println(a + "^" + b + " = " + currentValue);
                    break;
                case "sqrt":
                    currentValue = calculated.sqrt();
                    System.out.println("\u221A" + a + " = " + currentValue);
                    break;
            }
        }
    }
}