package map;

import java.util.*;

public class Maps {
    /*
    * java.util.Map
    *  - Elementos únicos (key) para cada valor (value)
    *  - HashMap itera os elementos aleatoriamente
    *  - LinkedHashMap itera de acordo com a ordem de inserção ou ordem de acesso
    *  - TreeMap itera de acordo com a ordem natural das chaves ou comparator
    *  - HashMap permite chaves nulas
    *  - LinkedHashMap permite chaves nulas
    *  - TreeMap não permite chaves nulas*/

    public static void main(String[] args) {
        /*
        * Dados os modelos dos carros e seus respectivos consumos na estrada, faça:
        *
        *  - Modelo = gol - consumo = 14.4Km/l
        *  - Modelo = uno - consumo = 15.6Km/l
        *  - Modelo = mobi - consumo = 16.1Km/l
        *  - Modelo = hb20 - consumo = 14.5Km/l
        *  - Modelo = kwid - consumo = 15.6Km/l
        * */

        Map<String, Double> carros = new HashMap<>();
        carros.put("Gol", 14.4);
        carros.put("Uno", 15.6);
        carros.put("Mobi", 16.1);
        carros.put("HB20", 14.5);
        carros.put("Kwid", 15.6);

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos");
        System.out.println(carros);
        System.out.println("Substitue o consumo do Gol por 15.2Km/l");
        carros.replace("Gol", 14.4, 15.2);
        System.out.println(carros);
        System.out.println("Confere se o modelo Tucson está no dicionário: " + carros.containsKey("Tucson"));
        System.out.println("Exibe o consumo do Uno: " + carros.get("Uno"));
        System.out.println("Exibe o terceiro modelo adicionado: ");
        System.out.println("Exibe os modelos: " + carros.keySet());
        System.out.println("Exibe os consumos dos carros: " + carros.values());
        Double consumoEficiente = Collections.max(carros.values());
        Set<Map.Entry<String, Double>> entrySet = carros.entrySet();
        String modeloEficiente = "";
        for (Map.Entry<String, Double> entry: entrySet
        ) {
            if(entry.getValue().equals(consumoEficiente)){
                modeloEficiente = entry.getKey();
            }
        }
        System.out.println("Exibe o modelo mais econômico e o seu consumo: " + modeloEficiente + " = "+ consumoEficiente + "Km/l");
        Double consumoMenosEficiente = Collections.min(carros.values());
        Set<Map.Entry<String, Double>> entrySet2 = carros.entrySet();
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry: entrySet2
             ) {
            if(entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
            }
        }
        System.out.println("Exibe o modelo menos econômico e o seu consumo: " + modeloMenosEficiente +" = "+ consumoMenosEficiente + "Km/l");

        Iterator<Double> iterator = carros.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma+=next;
        }
        System.out.println("Exibe a soma dos consumos: " + soma);
        System.out.println("Exibe a média dos consumos deste dicionário de carros: " + soma/carros.size());
        Iterator<Double> iterator1 = carros.values().iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next.equals(15.6)){
                iterator1.remove();
            }
        }
        System.out.println("Remova os modelos com o consumo igual a 15.6 km/l: ");
        System.out.println(carros);
        Map<String, Double> carros2 = new LinkedHashMap<>(carros);
        System.out.println("Exibe todos os carros na ordem em que foram informados: " + carros2.toString());
        Map<String, Double> carros3 = new TreeMap<>(carros);
        System.out.println("Exibe o dicionário ordenado pelo modelo: " + carros3.toString());
        System.out.println("Apaga o conjunto de carros: " );
        carros3.clear();
        System.out.println(carros3);
        System.out.println("Confere se a listas está vazia: "+ carros3.isEmpty());
    }


}

