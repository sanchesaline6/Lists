package map;

import java.util.*;

public class Ordenacao {
    /*
    Dadas as seguintes informações sobre os livros e seus autores,
    crie um dicionário e ordene-o

     - Autor = Hawking, Stephen - Título = Uma Breve História do Tempo - Páginas = 256
     - Autor = Duhigg, Charles = Título = O Poder do Hábito - Páginas = 488
     - Autor = Harari, Yuval Noah - Título = 21 Lições para o século 21 - Páginas = 432
    * */

    public static void main(String[] args) {

        Map<String, Livro> livros = new HashMap();
        livros.put("Hawking, Stephen", new Livro("Uma Breve História do Tempo" ,256));
        livros.put("Duhigg, Charles", new Livro("O Poder do Hábito", 488));
        livros.put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 432));

        Map<String, Livro> livros2 = new LinkedHashMap<>();
        livros2.put("Hawking, Stephen", new Livro("Uma Breve História do Tempo" ,256));
        livros2.put("Duhigg, Charles", new Livro("O Poder do Hábito", 488));
        livros2.put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 432));

        Map<String, Livro> livros3 = new TreeMap<>();
        livros3.put("Hawking, Stephen", new Livro("Uma Breve História do Tempo" ,256));
        livros3.put("Duhigg, Charles", new Livro("O Poder do Hábito", 488));
        livros3.put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 432));

        System.out.println("Ordem aleatória");
        System.out.println(livros.toString());
        System.out.println("Ordem de inserção");
        System.out.println(livros2.toString());
        System.out.println("Ordem alfabética de autores");
        System.out.println(livros3.toString());
        System.out.println("Ordem alfabética dos nomes dos livros");
        Set<Map.Entry<String, Livro>> livros4 = new TreeSet<>(new ComparatorNomeLivro());
        livros4.addAll(livros.entrySet());
        System.out.println(livros4);

        System.out.println("Ordem pelo número de páginas");
        Set<Map.Entry<String, Livro>> livros5 = new TreeSet<>(new ComparatorNumeroPaginas());
        livros5.addAll(livros.entrySet());
        System.out.println(livros5);
    }
}

class ComparatorNomeLivro implements Comparator<Map.Entry<String, Livro>>{


    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return o1.getValue().getTitulo().compareTo(o2.getValue().getTitulo());
    }
}

class ComparatorNumeroPaginas implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return Integer.compare(o1.getValue().getNumPaginas(), o2.getValue().getNumPaginas());
    }
}

