package org.elkin.exercises;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Functional2 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        calculadora(2D, "exponencial");
        diccionarioPalabras("Hola mundo");
        calificar(List.of(4.0, 4.5, 3.0, 2.5, 2.0));
        Map<String, List<Double>> notas = new HashMap<>();
        notas.put("mat", List.of(3.0, 2.0, 4.0));
        notas.put("fis", List.of(2.4, 3.0, 1.0));
        notasEstudiantes(notas);
    }

    public static void calculadora(Double valor, String operacion) {

        Map<String, Function<Double, Double>> operaciones = new HashMap<>();
        UnaryOperator<Double> seno = Math::sin;
        operaciones.put("seno", seno);
        UnaryOperator<Double> coseno = Math::cos;
        operaciones.put("coseno", coseno);
        UnaryOperator<Double> tangente = Math::tan;
        operaciones.put("tangente", tangente);
        UnaryOperator<Double> exponencial = Math::exp;
        operaciones.put("exponencial", exponencial);
        UnaryOperator<Double> logaritmo = Math::log;
        operaciones.put("logaritmo", logaritmo);

        if (operaciones.containsKey(operacion)) {
            IntStream.range(1, valor.intValue() + 1).forEach(x -> System.out.println(x + " = " + operaciones.get(operacion).apply((double) x)));
        }
    }

    public static void diccionarioPalabras(String frase) {
        Map<String, Integer>
                dicPalabras = Stream.of(frase.split(" ")).collect(Collectors.toMap(p -> p, String::length));

        System.out.println(dicPalabras);
    }

    public static void calificar(List<Double> notas) {
        List<String> calificaciones = notas.stream().map(n -> {
            if (n >= 3)
                return "aprobado";
            else
                return "reprobado";
        }).collect(Collectors.toList());

        System.out.println(calificaciones);
    }

    public static void notasEstudiantes(Map<String, List<Double>> notas) {
        Map<String, String> map =
                notas.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toUpperCase(), f -> f.getValue().stream().reduce(Double::max).toString()));
        System.out.println(map);
    }

}
