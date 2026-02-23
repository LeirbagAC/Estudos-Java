package estudos.utils;
//Esta linha importa a classe Exception do Java. Curiosamente, esta linha é opcional,
// porque todas as classes do pacote java.lang (como String, System, e Exception) são importadas automaticamente em todos os ficheiros Java.
import java.lang.Exception;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
