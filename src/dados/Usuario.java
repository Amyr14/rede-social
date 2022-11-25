package dados;
import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private String userName;
    private String nome;
    private String biografia;
    private String senha;
    private final List<Post> posts = new ArrayList<>();
    private final List<Post> favoritos = new ArrayList<>();
    private final List<Post> feed = new ArrayList<>();
    private final List<Usuario> seguindo = new ArrayList<>();
    private final List<Usuario> seguidores = new ArrayList<>();

    public Usuario(String nome, String userName, String senha, String biografia) {
        this.nome = nome;
        this.userName = userName;
        this.senha = senha;
        this.biografia = biografia;
    }

    public Usuario(String userName, String senha) {
        this("", userName, senha, "");
    }

    public void postar(Post post) {
        posts.add(post);
        for (Usuario u : seguidores)
            u.addFeed(post);
    }

    public void seguir(Usuario usuario) {
        seguindo.add(usuario);
        feed.addAll(usuario.getPosts());
        usuario.addSeguidor(this);
    }

    public void desseguir(Usuario usuario) {
        seguindo.remove(usuario);
        feed.removeAll(usuario.getPosts());
        usuario.removSeguidor(this);
    }

    public void favoritar(Post post) {
        favoritos.add(post);
    }

    public void addFeed(Post post) {
        feed.add(post);
    }

    public void addSeguidor(Usuario usuario) {
        seguidores.add(usuario);
    }

    public void removSeguidor(Usuario usuario) {
        seguidores.remove(usuario);
    }

    public List<Usuario> getSeguindo() {
        return seguindo;
    }

    @Override
    public boolean equals(Object o) {
        Usuario usuario = (Usuario) o;
        return userName.equals(usuario.getUserName());
    }

    public String getUserName() {
        return userName;
    }

    public String getNome() {
        return nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getSenha() {
        return senha;
    }

    public List<Post> getFavoritos() {
        return favoritos;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Post> getFeed() {
        return feed;
    }
}
