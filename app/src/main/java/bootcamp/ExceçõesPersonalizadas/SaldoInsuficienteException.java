package bootcamp.ExceçõesPersonalizadas;
import java.lang.Exception;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
