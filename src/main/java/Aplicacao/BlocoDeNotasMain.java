package Aplicacao;

import entities.Anotacao;
import entities.BlocoDeNotas;
import exceptions.TituloJaExisteException;
import exceptions.TituloTextoNaoExisteException;

import java.util.Scanner;

public class BlocoDeNotasMain {
    public static void main(String[] args) {
        BlocoDeNotas bloco = new BlocoDeNotas();
        Scanner scanner = new Scanner(System.in);
        String escolha;

        do {
            System.out.print("""
                    \n1- Criar anotação;
                    2- Acessar anotação existente;
                    3- Editar uma anotação;
                    4- Excluir uma anotação;
                    5- Finalizar o programa;
                    Escolha:\s""");
            escolha = scanner.nextLine();

            switch (escolha) {

                //cria nova anotação
                case ("1") -> {
                    Anotacao newNota = new Anotacao();

                    //tratamento de erro TituloTextoNaoExisteException para o Titulo
                    do {
                        try {
                            System.out.print("\nTitulo da Nota: ");
                            String titulo = scanner.nextLine();
                            Anotacao tituloJaExiteOuNao = bloco.getNotapeloTitulo(titulo);

                            //tratamento caso ja esxista o titulo passado
                            if (tituloJaExiteOuNao != null) {
                                if (titulo.equals(tituloJaExiteOuNao.getTitulo())) {
                                    throw new TituloJaExisteException("""
                                            Este Titulo Ja existe
                                            Tente outro;
                                            """);
                                }
                                //caso não exista o titulo sera setado
                            } else {
                                newNota.setTitulo(titulo);
                            }
                        } catch (TituloTextoNaoExisteException | TituloJaExisteException ntte) {
                            System.out.println("\nERRO! " + ntte.getMessage());
                        }
                    } while (newNota.getTitulo() == null || newNota.getTitulo().equals(""));

                    //tratamento de erro TituloTextoNaoExisteException
                    //caso o Texto esteja vazio
                    do {
                        try {
                            System.out.print("Texto: ");
                            newNota.setTexto(scanner.nextLine());
                        } catch (TituloTextoNaoExisteException ntte) {
                            System.out.println("\nERRO! " + ntte.getMessage());
                        }

                        //ao setar o titulo e texto essa linha adiciona
                        // essa anotação no arrayListAnotacao no BlocoDeNotas
                        bloco.addArrayListAnotacao(newNota);
                    } while (newNota.getTexto().equals(""));
                }

                //acessar conta existente
                case ("2") -> {
                    String tituloDeBusca;

                    System.out.print("\nDigite o titulo de Busca: ");
                    tituloDeBusca = scanner.nextLine();
                    try {
                        Anotacao buscatitulo = bloco.buscaAnotacaoExistente(tituloDeBusca);

                        //tratamento de erro caso buscatitulo devolva null
                        if (buscatitulo == null) {
                            throw new TituloTextoNaoExisteException(
                                    "Essa anotação não existe;"
                            );
                        } else {
                            System.out.print(bloco.toStringAnotacao(buscatitulo));
                        }

                    } catch (TituloTextoNaoExisteException ttnee) {
                        System.out.println("\nERRO! " + ttnee.getMessage());
                    }
                }

                //edita anotação
                case ("3") -> {

                    System.out.print("\nTitulo da anotação que deseja editar: ");
                    String buscarAnotacaoAEditar = scanner.nextLine();

                    //tratamento caso o titulo a buscar não exista
                    try {
                        Anotacao anotacaoAEditar = bloco.buscaAnotacaoExistente(buscarAnotacaoAEditar);
                        if (anotacaoAEditar != null) {
                            bloco.editarAnotacao(anotacaoAEditar);
                        } else {
                            throw new TituloTextoNaoExisteException(
                                    "Esse titulo não existe!"
                            );
                        }

                    } catch (TituloTextoNaoExisteException ttnee) {
                        System.out.println("\nERRO! " + ttnee.getMessage());
                    }
                }

                //exclui anotação
                case ("4") -> {

                    System.out.print("\nTitulo da anotação que deseja excluir: ");
                    String buscarTituloADeletar = scanner.nextLine();

                    //tratamento caso anotação nao exista
                    try {
                        Anotacao anotacaoAExcluir = bloco.buscaAnotacaoExistente(buscarTituloADeletar);

                        if (anotacaoAExcluir != null) {
                            bloco.deletaAnotacao(anotacaoAExcluir);
                            System.out.print("Anotação excluida.\n");
                        } else {
                            throw new TituloTextoNaoExisteException(
                                    "Titulo não existente;"
                            );
                        }

                    } catch (TituloTextoNaoExisteException ttnee) {
                        System.out.println("\nERRO! " + ttnee.getMessage());
                    }
                }

                //finaliza o programa
                case ("5") -> System.out.println("Saindo...");

                //se seja diferente de todas as opções
                default -> System.out.println("\nEscolha inválida, tente escolher entre 1 e 5!");
            }
        }
        while (!escolha.equals("5"));
        System.out.print("Programa finalizado");
    }
}