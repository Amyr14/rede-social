package excessoes;

public class SenhaIncorreta extends Exception{
    public SenhaIncorreta(String mensagem) {
        super(mensagem);
    }
}
