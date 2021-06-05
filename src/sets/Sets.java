package sets;

import java.util.*;

public class Sets {
    /*
    * java.util.Set
    *  - Não permite elementos duplicados
    *  - Não possui índice
    *  - HashSet não mantém a ordem dos elementos
    *  - LinkedHashSet mantém a ordenação dos elementos
    *  - TreeSet mantém o ordenamento padrão
    *  - HashSet permite no máximo um elemento nulo
    *  - LinkedHashSet permite no máximo um elemento nulo
    *  - TreeSet não permite elementos nulos.*/

    public static void main(String[] args) {
        /*
        * Crie um conjunto e adicione as notas*/
        Set<Double> notas = new HashSet(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));

        System.out.println("Cria um conjunto e adiciona notas");
        System.out.println(notas);

        System.out.println("Exibe a posição da nota 5.0");


        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");


        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");


        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5.0));

        System.out.println("Exibe a terceira nota adicionada: ");


        System.out.println("Exibe a menor nota: " + Collections.min(notas));

        System.out.println("Exibe a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma+= next;
        }
        System.out.println("Exiba a soma das notas: " + soma);
        System.out.println("Exiba a média das notas: " + soma/notas.size());
        System.out.println("Remova a nota 0: " + notas.remove(0.0));
        System.out.println(notas);
        System.out.println("Remova a nota da posição 0: ");
        System.out.println("Remova as notas menores que 7 e exiba a lista");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7){
                iterator1.remove();
            }
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        System.out.println(notas2);

        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto: ");
        notas.clear();
        System.out.println(notas);

        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());

    }
}
