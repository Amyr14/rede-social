package excessoes;

public class UsuarioNaoPossuiPosts extends Exception {
    public UsuarioNaoPossuiPosts(String mensagem) {
        super(mensagem);
    }
}
