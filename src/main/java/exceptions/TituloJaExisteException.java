package exceptions;

public class TituloJaExisteException extends RuntimeException{

    public TituloJaExisteException(String mensagem){
        super(mensagem);
    }
}
