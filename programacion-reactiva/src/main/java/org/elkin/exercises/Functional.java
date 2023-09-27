package org.elkin.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Functional {
    public static void main(String[] args) {
        //
        System.out.println("Factorial 5: " + factorial(5));
        System.out.println("Fibonacci 6: " + fibonacci(6));
        System.out.println("suma n : 5: " + sumaN(5));
        System.out.println("lista " + invertirLista(new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e")), 5));
    }

    private static int factorial(int num) {
        if (num <= 1) {
            return num;
        } else {
            return num * factorial(num - 1);
        }
    }

    private static int fibonacci(int num) {
        if (num == 0 || num == 1) {
            return num;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    public static int sumaN(int n) {
        if (n == 1) return 1;
        else return n + sumaN(n - 1);
    }

    public static List<String> invertirLista(List<String> lista, int l) {
        if (l == 0){
            return lista;
        }
        else {
            lista.add(lista.remove(l-1));
            return invertirLista(lista, l-1);
        }
    }

    public int listaEntreNumeros(int a, int b) {
        if (a == b) return b;
        else return listaEntreNumeros(a + 1, b);
    }

    public int cifras(int n) {
        if (n < 10) return 1;
        else return 1 + cifras(n / 10);
    }

    public double potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente < 0) {
            return potencia(base, exponente + 1) / base;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }

    public int productoRecursivo(int x, int y) {
        if (y == 1) return x;
        else return x + productoRecursivo(x, y - 1);
    }
}
