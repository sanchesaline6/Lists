package sets;

import java.util.*;

public class ExerciciosPropostos {
    /*
    * Crie um conjunto contendo as cores do arco-íris e:
    *  - Exiba todas as cores uma abaixo da outra
    *  - A quantidade de cores que o arco-íris tem
    *  - Exiba as cores em ordem alfabética
    *  - Exiba as cores na ordem inversa da que foi informada
    *  - Exiba todas as cores que começam com a letra V
    *  - Remova todas as cores que não começam com a letra V
    *  - Limpe o conjunto
    *  - Confira se o conjunto está vazio*/

    public static void main(String[] args) {
        Set<String> coresArcoIris = new LinkedHashSet<>();
        coresArcoIris.add("Vermelho");
        coresArcoIris.add("Laranja");
        coresArcoIris.add("Amarelo");
        coresArcoIris.add("Verde");
        coresArcoIris.add("Azul");
        coresArcoIris.add("Anil");
        coresArcoIris.add("Violeta");

        System.out.println("Exiba todas as cores uma abaixo da outra");
        for (String cor:coresArcoIris
             ) {
            System.out.println(cor);
        }
        System.out.println("A quantidade de cores que o arco-íris tem: " + coresArcoIris.size());
        System.out.println("Exibe as cores em ordem alfabética");
        Set<String> coresArcoIris2 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIris2);
        System.out.println("Exibe as cores na ordem inversa da que foi informada");
        List<String> coresArcoIris3 = new ArrayList<>(coresArcoIris);
        Collections.reverse(coresArcoIris3);
        System.out.println(coresArcoIris3);
        System.out.println("Exibe todas as cores que começam com a letra V:");
        for (String cor: coresArcoIris
             ) {
            if(cor.startsWith("V")){
                System.out.println(cor);
            }
        }
        System.out.println("Remove todas as cores que não começam com a letra V");
        coresArcoIris.removeIf(next -> !next.startsWith("V"));
        System.out.println(coresArcoIris);
        System.out.println("Limpe o conjunto");
        coresArcoIris.clear();
        System.out.println("Confira se o conjunto está vazio: " + coresArcoIris.isEmpty());

        /*
         * Crie uma classe LinguagemFavorita que possua os atributos nome,
         * anoDeCriacao e ide. Em seguida, crie um conjunto com 3 linguagens
         * e faça um programa que ordene esse conjunto por:
         *
         *  - Ordem de Inserção
         *  - Ordem Natural (Nome)
         *  - IDE
         *  - Ano de criação e nome
         *  - Nome, ano de criação e IDE
         *  - Ao final, exiba as linguagens no console, uma abaixo da outra*/

        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>();
        linguagens.add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
        linguagens.add(new LinguagemFavorita("Python", 1989, "PyCharm"));
        linguagens.add(new LinguagemFavorita("JavaScript", 1996, "Visual Studio Code"));

        System.out.println("Ordem de Inserção");
        for (LinguagemFavorita linguagem: linguagens
             ) {
            System.out.println(linguagem.getNome() +" - "+ linguagem.getAnoDeCriacao() +" - "+ linguagem.getIde());

        }

        System.out.println("Ordem Natural (Nome)");
        Set<LinguagemFavorita> linguagens2 = new TreeSet<>(linguagens);
        for (LinguagemFavorita linguagem: linguagens2
             ) {
            System.out.println(linguagem.getNome() +" - "+ linguagem.getAnoDeCriacao() +" - "+ linguagem.getIde());
        }

        System.out.println("Ordem de IDE");
        Set<LinguagemFavorita> linguagensIde = new TreeSet<>(new ComparatorIde());
        linguagensIde.addAll(linguagens);
        for (LinguagemFavorita linguagem: linguagensIde
             ) {
            System.out.println(linguagem.getNome() +" - "+ linguagem.getAnoDeCriacao() +" - "+ linguagem.getIde());
        }

        System.out.println("Ordem Ano de Criação e Nome");
        Set<LinguagemFavorita> linguagens3 = new TreeSet<>(new ComparatorAnoCriacaoNome());
        linguagens3.addAll(linguagens);
        for (LinguagemFavorita linguagem: linguagens3
             ) {
            System.out.println(linguagem.getNome() +" - "+ linguagem.getAnoDeCriacao() +" - "+ linguagem.getIde());
        }

        System.out.println("Ordem Nome/Ano de Criação/IDE");
        Set<LinguagemFavorita> linguagens4 = new TreeSet<>(new ComparatorNomeAnoCriacaoIde());
        linguagens4.addAll(linguagens);
        for (LinguagemFavorita linguagem: linguagens4
        ) {
            System.out.println(linguagem.getNome() +" - "+ linguagem.getAnoDeCriacao() +" - "+ linguagem.getIde());
        }
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareTo(o2.getIde());
    }
}
class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int anoDeCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if(anoDeCriacao != 0) return anoDeCriacao;

        return o1.getNome().compareTo(o2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if(nome != 0) return nome;
        int anoCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if(anoCriacao != 0) return anoCriacao;

        return o1.getIde().compareTo(o2.getIde());
    }
}