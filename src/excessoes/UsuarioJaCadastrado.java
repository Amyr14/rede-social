package excessoes;

public class UsuarioJaCadastrado extends Exception {
    public UsuarioJaCadastrado(String mensagem) {
        super(mensagem);
    }
}
