package lists;

import java.util.*;

public class Lists {
    /*
    * java.util.List
    *  - Elementos duplicados e garante ordem de inserção.
    *  - ArrayList deve ser usada onde mais operações de pesquisa são necessárias, enquanto a LinkedList
    *       deve ser usada onde mais operações de inserção e exclusão são necessárias.
    * */

    public static void main(String[] args) {
        /*
        * Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
        *
        *  - Crie uma lista e adicione as sete notas;
        *  - Exiba a posição da nota 5.0;
        *  - Adicione na lista a nota 8.0 na posição 4;
        *  - Substitua a nota 5.0 pela nota 6.0;
        *  - Confira se a nota 5.0 está na lista;
        *  - Exibe todas as notas na ordem em que foram informadas;
        *  - Exibe a terceira nota adicionada;
        *  - Exibe a menor nota;
        *  - Exibe a maior nota;
        *  - Exiba a soma de todas as notas;
        *  - Exiba a média das notas;
        *  - Remova a nota 0.0;
        *  - Remova a nota da posição 0;
        *  - Remova as notas menores que 7 e exiba a lista;
        *  - Apague toda a lista;
        *  - Confira se a lista está vazia;
        * */

        List<Double> notas = new ArrayList(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);
        System.out.println("Posição na lista da nota 5.0: " + notas.indexOf(5));
        notas.add(4, 8.0); // Adiciona na lista a nota 8.0 na posição 4
        System.out.println("Adiciona na lista a nota 8.0 na posição 4");
        System.out.println(notas);
        notas.set(notas.indexOf(5d), 6.0); //Substitui a nota 5.0 pela nota 6.0
        System.out.println("Substitui a nota 5.0 pela nota 6.0");
        System.out.println(notas);
        System.out.println("Verifica se a nota 5.0 está na lista: " + notas.contains(5.0));
        System.out.println("Exibe todas as notas na ordem em que foram informadas");
        for (Double nota : notas) {
            System.out.println(nota);
        }
        System.out.println("Exibe a terceira nota adicionada: " + notas.get(2));
        System.out.println("Exibe a menor nota da lista: " + Collections.min(notas));
        System.out.println("Exibe a maior nota da lista: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma+=next;
        }
        System.out.println("Exibe a soma de todas as notas: " + soma);
        System.out.println("Exibe a média das notas: " + soma/notas.size());
        System.out.println("Remove a nota 0.0");
        notas.remove(0.0);
        System.out.println(notas.toString());
        System.out.println("Remove a nota da posição 0");
        notas.remove(0);
        System.out.println(notas.toString());
        System.out.println("Remova as notas menores que 7 e exiba a lista");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas.toString());
        System.out.println("Apague toda a lista");
        notas.removeAll(notas);
        System.out.println(notas.toString());
        System.out.println("Confere se a lista está vazia: " + notas.isEmpty());

        /*
         * Resolva esses exercícios utilizando os métodos da implementação LinkedList:
         *  - Crie uma lista vazia chamada notas2 e coloque todos os elementos da ArrayList
         *       nessa nova lista
         *  - Mostre a primeira nota da nova lista sem removê-lo:
         *  - Mostre a primeira nota da nova lista removendo-o: */

        LinkedList notas2 = new LinkedList<>();
        notas2.add(7.0);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5.0);
        notas2.add(7.0);
        notas2.add(0.0);
        notas2.add(3.6);

        System.out.println(notas2.toString());
        System.out.println("Mostra a primeira nota da nova lista sem removê-lo: " + notas2.peek());
        System.out.println(notas2.toString());
        System.out.println("Mostra a primeira nota da nova lista e remove-o: " + notas2.poll());
        System.out.println(notas2.toString());


    }
}
