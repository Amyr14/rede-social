package apresentacao;
import com.sun.tools.javac.Main;
import excessoes.*;
import negocio.*;
import dados.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instancia;
    private TelaLogin telaLogin;
    private TelaCadastro telaCadastro;
    private TelaFeed telaFeed;
    private TelaPerfil telaPerfil;
    private RedeSocial redeSocial;

    private MainFrame() {
        super("Rede Social");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 320);
        setVisible(true);
    }

    public static MainFrame getInstancia() {
        if( instancia == null )
            instancia = new MainFrame();
        return instancia;
    }

    public static void main(String[] args) {
        MainFrame frame = getInstancia();
        frame.redeSocial = new RedeSocial();
        frame.telaLogin = new TelaLogin();
        frame.telaCadastro = new TelaCadastro();
        frame.mostrarTelaLogin();
    }

    public void mostrarTelaLogin() {
        setContentPane(telaLogin.getPainel());
        validate();
    }

    public void mostrarTelaCadastro() {
        setContentPane(telaCadastro.getPainel());
        validate();
    }

    public void mostrarTelaFeed() {
        if ( telaFeed == null )
            telaFeed = new TelaFeed();

        setContentPane(telaFeed.getPainel());
        validate();
    }

    public void mostrarTelaPerfil() {
        if ( telaPerfil == null )
            telaPerfil = new TelaPerfil();

        setContentPane(telaPerfil.getPainel());
        validate();
    }

    public void logarUsuario(String username, String senha) throws UsuarioNaoEncontrado, SenhaIncorreta {
        redeSocial.logar(username, senha);
    }

    public void cadastrarUsuario(String nome, String username, String senha, String biografia) throws UsuarioJaCadastrado, SenhaInvalida {
        redeSocial.cadastrarUsuario(nome, username, senha, biografia);
    }

    public List<Usuario> verUsuarios()  {
        return redeSocial.verUsuarios();
    }

    public List<Usuario> verSeguindo() {
        return redeSocial.verSeguindo();
    }

    public void favoritar(Post post) {
        redeSocial.favoritar(post);
    }

    public void postar(Post post) {
        redeSocial.postar(post);
    }

    public void seguir(String username) {
        redeSocial.seguir(username);
    }

    public void desseguir(String username) {
        redeSocial.desseguir(username);
    }


    public void deslogar() {
        redeSocial.deslogar();
        telaFeed = null;
        telaPerfil = null;
        getInstancia().mostrarTelaLogin();
    }

    public List<Post> verFavoritos() {
        return redeSocial.verFavoritos();
    }

    public List<Post> verPosts() {
        return redeSocial.verPosts();
    }

    public List<Post> verFeed() { return redeSocial.verFeed(); }

    public String verUsernameLogado() {
        return redeSocial.verUsernameLogado();
    }

    public String verBiografia() {
        return redeSocial.verBiografia();
    }

    public String verNome() {
        return redeSocial.verNome();
    }
}

