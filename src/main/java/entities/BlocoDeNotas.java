package entities;

import exceptions.TituloTextoNaoExisteException;

import java.util.ArrayList;
import java.util.Scanner;

public class BlocoDeNotas {

    ArrayList<Anotacao> arrayListAnotacao = new ArrayList<>();
    ArrayList<Anotacao> arrayListDeletadas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    //adiciona a anotação no array de anotações
    public void addArrayListAnotacao(Anotacao anotacao) {
        arrayListAnotacao.add(anotacao);
    }

    //busca a anotação pelo titulo
    public Anotacao getNotapeloTitulo(String titulo) {
        for (Anotacao anotacao : arrayListAnotacao) {
            if (anotacao.isDeletar() && anotacao.getTitulo() != null && arrayListAnotacao.size() != 0) {
                if (anotacao.getTitulo().equalsIgnoreCase(titulo)) {
                    return anotacao;
                }
            }
        }
        return null;
    }

    //formata o print da nota
    public String toStringAnotacao(Anotacao nota) {
        String formato = "\nData de criação: " + nota.getDataEHora() + "\nTítulo: "
                + nota.getTitulo() + "\nTexto: " + nota.getTexto() + "\n";

        return String.format(formato, nota);
    }

    //edita anotação e trata erro caso titulo exista ou seja null
    public void editarAnotacao(Anotacao nota) {
        boolean tituloSetado = false;
        boolean textoSetado = false;

        //tratamento caso ja exista uma anotação com esse titulo
        do {
            System.out.print("Novo titulo: ");
            String novoTitulo = scanner.nextLine();
            try {
                Anotacao tituloJaExiteOuNao = getNotapeloTitulo(novoTitulo);

                //se existe uma anotação com esse titulo dara erro
                if (tituloJaExiteOuNao != null) {
                    throw new TituloTextoNaoExisteException(
                            "Esse titulo ja existe;");
                } else if (novoTitulo.equals("")) {
                    throw new TituloTextoNaoExisteException(
                            "Titulo vazio");
                    //substituira o antigo titulo pelo novo caso não exista
                } else {
                    nota.setTitulo(novoTitulo);
                    tituloSetado = true;
                }

            } catch (TituloTextoNaoExisteException ttnee) {
                System.out.println("\nERRO! Tente outro!\n" + ttnee.getMessage());
            }
        } while (!tituloSetado);

        //set texto
        do {

            try {
                System.out.print("Novo texto: ");
                String novoTexto = scanner.nextLine();

                if (novoTexto.equals("") || novoTexto.equals(" ")) {
                    throw new TituloTextoNaoExisteException(
                            "Texto inexistente;\nEscreva algo!"
                    );
                } else {
                    nota.setTexto(novoTexto);
                    textoSetado = true;
                }

            } catch (TituloTextoNaoExisteException ttnee) {
                System.out.println("\nERRO! " + ttnee.getMessage());
            }

        } while (!textoSetado);
    }

    //deleta nota e add na array de excluidos
    public void deletaAnotacao(Anotacao nota) {
        nota.setDeletar(true);
        arrayListDeletadas.add(nota);

    }

    //retorna se a anotação pelo titulo existe ou da erro
    public Anotacao buscaAnotacaoExistente(String titulo) {
        if (arrayListAnotacao.size() != 0) {
            for (Anotacao anotacao : arrayListAnotacao) {
                if (anotacao.isDeletar() && anotacao.getTitulo() != null && arrayListAnotacao != null) {
                    if (anotacao.getTitulo().equalsIgnoreCase(titulo)) {
                        return anotacao;
                    }
                }
            }
        } else {
            throw new TituloTextoNaoExisteException(
                    "Essa anotação não existe;"
            );
        }
        return null;
    }
}