import java.util.*;

public class Ordenacao {
    public static void main(String[] args) {
        /*
        * Dada as seguintes informações sobre seus gatos, crie uma lista
        * e ordene esta lista exibindo:
        * (nome - idade - cor);
        *
        * Gato 1 = Jon, 18, preto
        * Gato 2 = Simba, 6, tigrado
        * Gato 3 = Jon, 12, amarelo
        * */

        List<Gato> gatos = new ArrayList<>();
        gatos.add(new Gato("Jon", 18, "preto"));
        gatos.add(new Gato("Simba", 6, "tigrado"));
        gatos.add(new Gato("Jon", 12, "amarelo"));

        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println(gatos.toString());

        System.out.println("--\tOrdem aleatória\t--");
        Collections.shuffle(gatos);
        System.out.println(gatos);
        
        System.out.println("--\tOrdem Natural (Nome)\t--");
        Collections.sort(gatos);
        System.out.println(gatos);

        System.out.println("--\tOrdem Idade\t--");
        Collections.sort(gatos, new ComparatorIdade());
        gatos.sort(new ComparatorIdade());
        System.out.println(gatos);

        System.out.println("--\tOrdem cor \t--");
        gatos.sort(new ComparatorCor());
        System.out.println(gatos);

        System.out.println("--\tOrdem nome/Cor/Idade\t--");
        gatos.sort(new ComparatorNomeCorIdade());
        System.out.println(gatos);
    }

    private static class ComparatorNomeCorIdade implements Comparator<Gato> {
        @Override
        public int compare(Gato g1, Gato g2) {
            int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
            if(nome != 0) {
                return nome;
            }

            int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
            if(cor != 0){
                return cor;
            }
            return Integer.compare(g1.getIdade(), g2.getIdade());
        }
    }
}

class ComparatorIdade implements Comparator<Gato>{


    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}
