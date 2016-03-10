package org.fasttrackit.util;


public class Example {
    public static void main(String[] args) {
        Calc calc = new Calc(3);

        int suma = calc.add(567, 876);
        System.out.println(suma);

        suma = calc.add(3, 50);
        System.out.println(suma);
    }
}

//    private static int add(int a, int b) {
//        return a + b;
//    }
//}

//public class Example {
//    public static void main(String[] args) {
//
//        int suma = Calculator.add(2, 3);
//        System.out.println(suma);
//
//}

