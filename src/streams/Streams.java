package streams;

import java.util.*;
import java.util.function.Function;

public class Streams {
    /*
    * Reference Method
    *
    *  - Reference Method é um novo recurso do Java 8 que permite fazer referência a um método
    *   ou construtor de uma classe (de forma funcional) e assim indicar que ele deve ser utilizado
    *   num ponto específico do código, deixando-o mais simples e legível. Para utilizá-lo, basta
    *   informar uma classe ou referência seguida do símbolo "::" e o nome do método sem os parênteses no final.
    *
    * Lambda
    *
    *  - Uma função lambda é uma função sem declaração, isto é, não é necessário colocar um nome, um tipo
    *   de retorno e o modificador de acesso. A ideia é que o método seja declarado no mesmo lugar em que
    *   será usado. As funções lambda em Java tem a sintaxe definida como (argumento) -> (corpo)
    *
    * Streams API
    *
    *   - A Streams API traz uma nova opção para a manipulação de coleções em Java seguindo os princípios
    *   da programação funcional. Combinada com as expressões lambda, ela proporciona uma forma diferente
    *   de lidar com conjuntos de elementos, oferecendo ao desenvolvedor uma maneira simples e concisa de
    *   escrever código que resulta em facilidade de manutenção e paralelização sem efeitos indesejados
    *   em tempo de execução.
    *
    * Classe Anônima
    *
    *  - A classe anônima em Java é uma classe que não recebeu um nome e é tanto declarada e instanciada
    *   em uma única instrução. Você deve considerar o uso de uma classe anônima sempre que você precisa
    *   para criar uma classe que será instaciada apenas uma vez.
    *
    * Functional Interface
    *
    *  - Qualquer interface com um SAM (Single Abstract Method) é uma interface funcional e sua implementação
    *   pode ser tratada como expressão lambda.
    *
    **/

    public static void main(String[] args) {
        /**
         * Dadas as seguintes informações de id e contato, crie um dicionário e
         * ordene este dicionário exibindo (Nome id - Nome contato)
         *
         * id = 1 - Contato = nome: Simon, número: 2222
         * id = 4 - Contato = nome: Cami, número: 5555
         * id = 3 - Contato = nome: Jon, número: 1111
         */

        Map<Integer, Contato> contatos = new HashMap<>();
        contatos.put(1, new Contato("Simon", 2222));
        contatos.put(4, new Contato("Cami", 5555));
        contatos.put(3, new Contato("Jon", 1111));

        Map<Integer, Contato> contatos1 = new LinkedHashMap<>(){{
            put(1, new Contato("Simon", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};

        Map<Integer, Contato> contatos2 = new TreeMap<>(){{
            put(1, new Contato("Simon", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};

        System.out.println("Ordem Aleatória");
        System.out.println(contatos);

        System.out.println("Ordem de Inserção");
        for(Map.Entry<Integer, Contato> contato: contatos1.entrySet()){
            System.out.println(contato.getKey() + " - " + contato.getValue());
        }

        System.out.println("Ordem de ID");
        for(Map.Entry<Integer, Contato> contato: contatos2.entrySet()){
            System.out.println(contato.getKey() + " - " + contato.getValue());
        }

        System.out.println("Ordem Número/Telefone");

        /* Implementação utilizando classe anônima*/
        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
                return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
            }
        });*/

        /*Implementação utilizando Functional Interface*/
        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> contato) {
                        return contato.getValue().getNumero();
                    }
                }));*/

        /* Implementação utilizando lambda*/
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                contato -> contato.getValue().getNumero()
        ));
        set.addAll(contatos.entrySet());
        for(Map.Entry<Integer, Contato> entry: set){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome());
        }

        System.out.println("Ordem nome do contato");
        /*Implementação utilizando classe anônima*/
        /*Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
                return o1.getValue().getNome().compareTo(o2.getValue().getNome());
            }
        });*/
        /*Implementação utilizando lambda*/
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(
                contato -> contato.getValue().getNome()
        ));
        set1.addAll(contatos.entrySet());
        for(Map.Entry<Integer, Contato> entry: set1){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome());
        }

    }
}
