package sets;

import java.util.*;

public class Ordenacao {

    /*
    * Dadas as seguintes informações sobre séries favoritas
    * crie um conjunto e ordene este conjunto exibindo:
    * (nome - gênero - tempo de episódio)
    *
    * Série 1 = Nome: Game Of Thrones, gênero: fantasia, tempoEpisódio:  60
    * Série 2 = Nome: Dark, gênero: drama, tempoEpisódio: 60
    * Série 3 = That 70's Show, gênero: comédia, tempoEpisódio: 25*/
    public static void main(String[] args) {

        Set<Serie> series = new HashSet<>(){{
            add(new Serie("Game Of Thrones", "fantasia", 60));
            add(new Serie("Dark", "drama", 60));
            add(new Serie("That 70's Show", "comédia", 25));
        }};
        Set<Serie> series2 = new LinkedHashSet<>(){{
            add(new Serie("Game Of Thrones", "fantasia", 60));
            add(new Serie("Dark", "drama", 60));
            add(new Serie("That 70's Show", "comédia", 25));
        }};



        System.out.println("--\tOrdem aleatória\t--");
        for (Serie serie: series) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("--\tOrdem inserção\t--");

        for(Serie serie: series2){
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
        System.out.println("--\tOrdem natural (Tempo episódio)\t--");
        Set<Serie> series3 = new TreeSet<>(series);
        for (Serie serie:series3
             ) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("--\tOrdem Nome/Gênero/Tempo Episódio\t--");
        Set<Serie> series4 = new TreeSet<>(new ComparatorNomeGeneroEpisodio());
        series4.addAll(series);
        for (Serie serie:series4
        ) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("--\tOrdem Gênero\t--");

        Set<Serie> series5 = new TreeSet<>(new ComparatorGenero());
        series5.addAll(series);
        for (Serie serie:series5
        ) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
        System.out.println("--\tOrdem Tempo Episódio\t--");
        Set<Serie> series6 = new TreeSet<>(new ComparatorTempoEpisodio());
        series6.addAll(series);
        for (Serie serie:series6
        ) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }


    }
}
class ComparatorNomeGeneroEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if(nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if(genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatorGenero implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareToIgnoreCase(s2.getGenero());
    }
}

class ComparatorTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}
