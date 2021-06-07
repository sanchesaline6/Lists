package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciciosStreamApi {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprime todos os elementos da lista de String: ");
        numerosAleatorios.stream()
                .forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros");
        List<Integer> stream = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(stream);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Mostre a média dos números");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares");
        List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numerosAleatorios1.removeIf(i -> i % 2 != 0);
        System.out.println(numerosAleatorios1.toString());

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);


        long count = numerosAleatorios.stream()
                .distinct()
                .count();
        System.out.println("Retirando os números repetidos da lista, quantos números ficam: " + count);

        System.out.println("Mostre o menor valor da lista");
        numerosAleatorios.stream()
                .min((o1, o2) -> o1.compareTo(o2))
                .ifPresent(System.out::println);

        System.out.println("Mostre o maior valor da lista");
        numerosAleatorios.stream()
                .max(((o1, o2) -> o1.compareTo(o2)))
                .ifPresent(System.out::println);

        int sum = numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 != 0)
                .sum();
        System.out.println("Pegue apenas os números ímpares e some: " + sum);
        System.out.println("Mostre a lista na ordem numérica");
        numerosAleatorios.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
        System.out.println("Agrupe os valores ímpares múltiplos de 3 e de 5");
        List<Integer> numerosInteirosLista = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Map<Boolean, List<Integer>> numerosMultiplosde3e5 = numerosInteirosLista.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));

        System.out.println(numerosMultiplosde3e5);


        //dica: collect(Collectors.groupingBy(new Function())





    }
}
