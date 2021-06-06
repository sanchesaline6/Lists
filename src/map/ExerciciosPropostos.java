package map;

import java.util.*;

public class ExerciciosPropostos {
    /*
    * Dada a população estimada de alguns estados do NE brasileiro, faça:
    *
    *  - Estado = PE - População = 9.616.621
    *  - Estado = AL - População = 3.351.543
    *  - Estado = CE - População = 9.187.103
    *  - Estado = RN - População = 3.534.265
    *
    * Crie um dicionário e relacione os estados e suas populações
    * Substitua a população do estado do RN por 3.534.165
    * Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277
    * Exiba a população PE
    * Exiba todos os estados e suas populações na ordem que foi informada
    * Exiba os estados e suas populações em ordem alfabética
    * Exiba o estado com a menor população e sua quantidade
    * Exiba o estado com a maior população e sua quantidade
    * Exiba a soma da população desses estados
    * Exiba a média da população deste dicionário de estados
    * Remova os estados com a população menor que 4.000.000
    * Apague o dicionário de estados
    * Confira se o dicionário está vazio*/


    /* Desafio */
    /*
    * Faça um programa que simule o lançamento de dados
    * Lance o dado 100 vezes e armazene
    * Depois mostre quantas vezes cada valor foi inserido
    * */
    public static void main(String[] args) {
        Map<String, Double> estados = new HashMap<>();
        estados.put("PE", 9616621d);
        estados.put("AL", 3351543d);
        estados.put("CE", 9187103d);
        estados.put("RN", 3534265d);

        Map<String, Double> estados1 = new LinkedHashMap<>();
        estados1.put("PE", 9616621d);
        estados1.put("AL", 3351543d);
        estados1.put("CE", 9187103d);
        estados1.put("RN", 3534265d);

        Map<String, Double> estados2 = new TreeMap<>();
        estados2.put("PE", 9616621d);
        estados2.put("AL", 3351543d);
        estados2.put("CE", 9187103d);
        estados2.put("RN", 3534265d);

        System.out.println("Cria um dicionário e relacione os estados e suas populações");
        System.out.println(estados.toString());

        System.out.println("Substitua a população do estado do RN por 3.534.165");
        estados.replace("RN", 3534165d);
        System.out.println(estados.toString());

        System.out.println("Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277");
        if(!estados.containsKey("PB")){
            estados.put("PB", 4039277d);
        }
        System.out.println(estados.toString());
        System.out.println("Exiba a população PE: " + estados.get("PE"));

        System.out.println("Exiba todos os estados e suas populações na ordem que foi informada");
        System.out.println(estados1);

        System.out.println("Exiba os estados e suas populações em ordem alfabética");
        System.out.println(estados2);

        Double menorPopulacao = Collections.min(estados.values());
        Set<Map.Entry<String, Double>> entries = estados.entrySet();
        String estadoMenor = "";
        for (Map.Entry<String, Double> entry:entries
             ) {
            if(entry.getValue().equals(menorPopulacao)){
                estadoMenor = entry.getKey();
            }
        }
        System.out.println("Exibe o estado com a menor população e sua quantidade: " + estadoMenor +" - "+ menorPopulacao);
        Double maiorPopulacao = Collections.max(estados.values());
        Set<Map.Entry<String, Double>> entries1 = estados.entrySet();
        String estadoMaior = "";
        for (Map.Entry<String, Double> entry:entries1
        ) {
            if(entry.getValue().equals(maiorPopulacao)){
                estadoMaior = entry.getKey();
            }
        }
        System.out.println("Exibe o estado com a maior população e sua quantidade: " + estadoMaior + " - " + maiorPopulacao);
        Double soma = 0d;
        Iterator<Double> iterator3 = estados.values().iterator();
        while(iterator3.hasNext()){
            Double next = iterator3.next();
            soma += next;
        }
        System.out.println("Exibe a soma da população desses estados: " + soma);
        System.out.println("Exibe a média da população deste dicionário de estados: " + soma/estados.size());

        System.out.println("Remove os estados com a população menor que 4.000.000");
        Iterator<Double> iterator4 = estados.values().iterator();
        while (iterator4.hasNext()){
            Double next = iterator4.next();
            if(next < 4000000d) iterator4.remove();
        }
        System.out.println(estados);
        System.out.println("Apague o dicionário de estados");
        estados.clear();
        System.out.println(estados);
        System.out.println("Confira se o dicionário está vazio: " + estados.isEmpty());

        /* Desafio */
        /*
         * Faça um programa que simule o lançamento de dados
         * Lance o dado 100 vezes e armazene
         * Depois mostre quantas vezes cada valor foi inserido
         * */

        /*Gera os valores do dado e guarda dentro do array valores*/
        int quantLancamentos = 100;
        List<Integer> valores = new ArrayList<>();
        Random geradorLancamento = new Random();
        for(int i = 0; i < quantLancamentos; i++){
            int number = geradorLancamento.nextInt(6) + 1;
            valores.add(number);
        }

        /*Dentro do dicionário é armazenado o primeiro resultado como key e depois é feito incremento do value conforme
        * o valor vai se repetindo*/
        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores) {
            if (lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            else lancamentos.put(resultado, 1);
        }

        /*Uma interrupção gerada apenas para deixar o sorteio interativo*/
        System.out.print("Jogando");
        //conteúdo do for + try/cath - totalmente opcional
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(3000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*Mostra o resultado dos valores sorteados no dado*/
        System.out.println("\nValor " + " Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }

    }
}
