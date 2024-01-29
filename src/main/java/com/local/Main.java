package com.local;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Jaider"));
        personas.add(new Persona("Andres"));

        personas.sort((l, r) -> r.nombre.compareTo(l.nombre));

        for (Persona persona : personas) {
            System.out.println(persona.nombre);
        }

        Runnable myRunnable = () -> System.out.println("Ejecutando...");
        Thread thread = new Thread(myRunnable);
        thread.start();

        // CREANDO UNA LAMBDA PERSONALIZADA
        int a = 5;
        int b = 7;
        PersonalFunction<Integer> personalFunction = (var1, var2) -> System.out.println(var1 + var2);
        personalFunction.sumador(a, b);

        // STREAM API
        Integer[] list = { 1, 4, 5, 23, 5 };
        List<Integer> listNum = Arrays.asList(list);
        // ArrayList<Integer> arrList = new ArrayList<>(listNum);

        // Convertir a stream
        Stream<Integer> streamMethod = listNum.stream(); // Forma 1
        Stream<Integer> streamDirecto = Stream.of(list); // Forma 2

        Optional<Integer> suma = listNum.stream().reduce((ar1, ar2) -> ar1 + ar2);
        // suma.ifPresent(resultado -> System.out.println("Suma: " + resultado));

        // INVOCACION PEREZOSA
        // Aqui no se ejecuta ya que solo se invocara para la ejecucion de la operacion
        // terminal
        List<String> lista1 = Arrays.asList("abc1", "abc2", "abc3");
        Stream<String> stream = lista1.stream().filter(valor -> {
            System.out.println("Procesando elemento: " + valor);
            return valor.contains("2");
        });

        // Count es una operacion terminal por lo que el metodo filter se mostrara 3
        // veces.
        List<String> lista2 = Arrays.asList("abc1", "abc2", "abc3");
        long contador = lista2.stream().filter(valor -> {
            System.out.println("Procesando elemento: " + valor);
            return valor.contains("2");
        }).count();

        // OPTIONAL CLASS
        String valorDado = null;
        Optional<String> optionalValor = Optional.ofNullable(valorDado);

        // Verificar si el valor está presente y realizar una acción
        optionalValor.ifPresent(valor -> System.out.println("Valor presente: " + valor));

        // Obtener el valor o proporcionar uno alternativo
        String valorOAlternativa = optionalValor.orElse("Valor predeterminado");
        System.out.println("Valor obtenido: " + valorOAlternativa);

        // Obtener el valor o lanzar una excepción
        String valor = optionalValor.orElseThrow(() -> new RuntimeException("No hay valor presente"));
        System.out.println("Valor obtenido (lanzando excepción si está ausente): " + valor);
    }
}