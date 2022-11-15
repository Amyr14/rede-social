package excessoes;

public class UsuarioNaoEncontrado extends Exception {
    public UsuarioNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
