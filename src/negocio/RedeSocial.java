package negocio;
import dados.*;
import excessoes.*;

import java.util.List;
import java.util.ArrayList;

public class RedeSocial {

    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioLogado;

    public void cadastrarUsuario(String nome, String username, String senha, String biografia) throws UsuarioJaCadastrado, SenhaInvalida {
        if ( senha.isEmpty() )
            throw new SenhaInvalida("Senha inválida!");

        for(Usuario u : usuarios)
            if ( u.getUserName().equals(username) )
                throw new UsuarioJaCadastrado("Username já está em uso!");

        usuarios.add(new Usuario(nome, username, senha, biografia));
    }

    public void logar(String username, String senha) throws UsuarioNaoEncontrado, SenhaIncorreta {
        Usuario usuarioSelecionado = null;

        for(Usuario u : usuarios)
            if( u.getUserName().equals(username) )
                usuarioSelecionado = u;

        if ( usuarioSelecionado == null )
            throw new UsuarioNaoEncontrado("Usuário não cadastrado!");

        else if ( !usuarioSelecionado.getSenha().equals(senha) )
            throw new SenhaIncorreta("Senha incorreta!");

        usuarioLogado = usuarioSelecionado;
    }

    public void postar(Post post) {
        usuarioLogado.postar(post);
    }

    public List<Post> verPosts() {
        return usuarioLogado.getPosts();
    }

    public List<Usuario> verSeguindo() {
        return usuarioLogado.getSeguindo();
    }

    public List<Usuario> verUsuarios()  {
        return usuarios;
    }

    public void seguir(String username) {
        for(Usuario u : usuarios)
            if ( u.getUserName().equals(username) )
                usuarioLogado.seguir(u);
    }

    public void desseguir(String username) {
        for(Usuario u : usuarios)
            if( u.getUserName().equals(username) )
                usuarioLogado.desseguir(u);
    }

    public List<Post> verFeed() {
        return usuarioLogado.getFeed();
    }
    public List<Post> verFavoritos() { return usuarioLogado.getFavoritos(); }

    public String verUsernameLogado() { return usuarioLogado.getUserName(); }

    public String verBiografia() { return usuarioLogado.getBiografia(); }

    public String verNome() { return usuarioLogado.getNome(); }

    public void favoritar(Post post) {
        usuarioLogado.favoritar(post);
    }

    public void deslogar() {
        usuarioLogado = null;
    }

}
