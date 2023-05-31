package entities;

import exceptions.TituloTextoNaoExisteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Anotacao {
    //Atributos
    private LocalDateTime data = LocalDateTime.now();
    private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    private String texto;
    private String titulo;
    private boolean deletar;

    //data e hora ja formatada
    public String getDataEHora() {
        String dataFormatada = data.format(formatoData);
        String horaFormatada = data.format(formatoHora);
        return String.format(" %S\nHora de criação: %S",
                dataFormatada, horaFormatada);
    }

    //Texto da Anotação
    public String getTexto() {
        return texto;
    }

    //recebe o texto da anotação e trata erro de texto vazio
    public void setTexto(String texto) throws TituloTextoNaoExisteException {
        this.texto = texto;

        //exception para quando nenhum Texto for informado
        if (texto.equals("")) {
            throw new TituloTextoNaoExisteException(
                    "Sem conteúdo, digite um texto!");
        }
    }

    //Titulo da Anotação
    public String getTitulo() {
        return titulo;
    }

    //recebe titulo da anotação e trata erro de titulo vazio
    public void setTitulo(String titulo) throws TituloTextoNaoExisteException{
        this.titulo = titulo;

        //exception para quando nenhum titulo for informado
        if (titulo.equals("")) {
            throw new TituloTextoNaoExisteException(
                    "Sem conteúdo, digite um titulo!");
        }
    }

    //getDeletar
    public boolean isDeletar() {
        return deletar;
    }

    //setDeletar
    public void setDeletar(boolean deletar) {
        this.deletar = deletar;
    }
}
