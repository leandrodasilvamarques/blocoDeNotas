package exceptions;

public class TituloTextoNaoExisteException extends RuntimeException {

    public TituloTextoNaoExisteException(String mensagem){
        super(mensagem);
    }
}
