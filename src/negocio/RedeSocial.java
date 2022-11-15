package negocio;
import dados.*;
import excessoes.*;

import java.util.List;
import java.util.ArrayList;

public class RedeSocial {

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private Usuario usuarioLogado;

    public void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastrado, SenhaInvalida {
        if ( usuario.getSenha().isEmpty() )
            throw new SenhaInvalida("Senha inválida!");
        else if ( usuarios.contains(usuario) )
            throw new UsuarioJaCadastrado("Username em uso!");
        usuarios.add(usuario);
    }

    public void logar(Usuario usuario) throws UsuarioNaoEncontrado, SenhaIncorreta {
        if ( !usuarios.contains(usuario) )
            throw new UsuarioNaoEncontrado("Usuário não encontrado!");
        else if ( !usuarios.get(usuarios.indexOf(usuario)).getSenha().equals(usuario.getSenha()) )
            throw new SenhaIncorreta("Senha incorreta!");
        usuarioLogado = usuarios.get(usuarios.indexOf(usuario));
    }

    public void postar(Post post) {
        usuarioLogado.postar(post);
    }

    public List<Post> verPosts() throws UsuarioNaoPossuiPosts {
        if ( usuarioLogado.getPosts().isEmpty() )
            throw new UsuarioNaoPossuiPosts("Você não possuí nenhum post!");
        return usuarioLogado.getPosts();
    }

    public List<Post> verFeed() throws FeedVazio {
        if ( usuarioLogado.verFeed().isEmpty() )
            throw new FeedVazio("Seu feed está vazio!");
        return usuarioLogado.verFeed();
    }

    public List<Usuario> verSeguindo() throws SeguindoVazio {
        if ( usuarioLogado.getSeguindo().isEmpty() )
            throw new SeguindoVazio("Você não segue ninguém!");
        return usuarioLogado.getSeguindo();
    }

    public List<Usuario> verUsuarios() throws NenhumUsuarioCadastrado {
        if ( usuarios.isEmpty() )
            throw new NenhumUsuarioCadastrado("Nenhum usuário cadastrado!");
        return usuarios;
    }

    public void seguir(Usuario usuario) {
        usuarioLogado.seguir(usuario);
    }

    public void desseguir(Usuario usuario) {
        usuarioLogado.desseguir(usuario);
    }

    public void favoritar(Post post) {
        usuarioLogado.favoritar(post);
    }

}
