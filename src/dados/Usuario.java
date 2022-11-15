package dados;
import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private String userName;
    private String nome;
    private String biografia;
    private String senha;
    private List<Post> posts = new ArrayList<Post>();
    private List<Post> favoritos = new ArrayList<Post>();
    private List<Usuario> seguindo = new ArrayList<Usuario>();

    public Usuario(String userName, String senha) {
        this.userName = userName;
        this.senha = senha;
    }

    public void postar(Post post) {
        posts.add(post);
    }

    public void seguir(Usuario usuario) {
        seguindo.add(usuario);
    }

    public void desseguir(Usuario usuario) {
        seguindo.remove(usuario);
    }

    public List<Post> verFeed() {
        List<Post> feed = new ArrayList<Post>();
        for(Usuario usuario : seguindo)
            for(Post post : usuario.getPosts())
                feed.add(post);
        return feed;
    }


    public void favoritar(Post post) {
        favoritos.add(post);
        post.favoritado(this);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Usuario> getSeguindo() {
        return seguindo;
    }

    @Override
    public boolean equals(Object o) {
        Usuario usuario = (Usuario)o;
        return userName.equals(usuario.getUserName());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
