package lists;

import java.util.*;

public class ExerciciosPropostosListas {
    public static void main(String[] args) {
        /*
        * Faça um programa que receba a temperatura média dos 6
        * primeiros meses do ano e armazene-as em uma lista.
        * Após isto, calcule a média semestral das temperaturas e
        * mostre todas as temperaturas acima desta média, e em que
        * mês elas ocorreram (mostrar o mês por extenso: 1 - Janeiro, 2 - Fevereiro e etc*/

        List<Double> temperaturas = new ArrayList<>();
        temperaturas.add(37.8);
        temperaturas.add(36.7);
        temperaturas.add(39.1);
        temperaturas.add(35.7);
        temperaturas.add(37.2);
        temperaturas.add(38.2);

        System.out.println(temperaturas.toString());
        Iterator<Double> iterator = temperaturas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        Double temperaturaMedia = Double.valueOf(Math.round(soma/temperaturas.size()));
        System.out.println("Calcula a média semestral das temperaturas: " + temperaturaMedia);
        System.out.println("Mostra as temperaturas maiores que a temperatura média e seus determinados meses");
        for (Double temperatura: temperaturas
             ) {
            if(temperatura > temperaturaMedia){
                switch (temperaturas.indexOf(temperatura)+1){
                    case 1:
                        System.out.println(temperatura + " em Janeiro");
                        break;
                    case 2:
                        System.out.println(temperatura + " em Fevereiro");
                        break;
                    case 3:
                        System.out.println(temperatura + " em Março");
                        break;
                    case 4:
                        System.out.println(temperatura + " em Abril");
                        break;
                    case 5:
                        System.out.println(temperatura + " em Maio");
                        break;
                    case 6:
                        System.out.println(temperatura + " em Junho");
                        break;
                    default:
                        System.out.println("Mês não encontrado");
                        break;
                }
            }

        }

        /*
        * Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime
        * As perguntas são:
        *   - Telefonou para a vítima?
        *   - Esteve no local do criem?
        *   - Mora perto da vítima?
        *   - Devia para a vítima?
        *   - Já trabalhou com a vítima?
        *
        * Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita",
        * entre 3 e 4 respostas positivas como "Cúmplice" e 5 como "Assassina". Caso contrário ela
        * será classificada como "Inocente"*/

        List<String> respostas = new ArrayList<>();
        List<String> perguntas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int respostasPositivas = 0;
        perguntas.add("Telefonou para a vítima?");
        perguntas.add("Esteve no local do crime?");
        perguntas.add("Mora perto da vítima?");
        perguntas.add("Devia para a vítima?");
        perguntas.add("Já trabalhou com a vítima?");

        System.out.println("Responda Sim ou Não para as perguntas a seguir...");
        for (String pergunta: perguntas
             ) {
            System.out.println(pergunta);
            respostas.add(sc.nextLine());
        }

        for(String resposta: respostas){
            if(resposta.equalsIgnoreCase("sim")){
                respostasPositivas++;
            }
        }
        if(respostasPositivas == 2){
            System.out.println("Pessoa classificada como Suspeita");
        }
        else
        if(respostasPositivas > 2 && respostasPositivas < 5){
            System.out.println("Pessoa classificada como Cúmplice");
        }
        else
        if(respostasPositivas == 5){
            System.out.println("Pessoa classificada como Assassina");
        }
        else{
            System.out.println("Pessoa classificada como Inocente");
        }

    }
}
