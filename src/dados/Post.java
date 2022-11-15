package dados;
import java.util.List;
import java.util.ArrayList;

public class Post {

    private final String caminhoFoto;
    private String legenda;
    private List<Usuario> favoritadoPor = new ArrayList<Usuario>();

    public Post(String caminhoFoto, String legenda) {
        this.caminhoFoto = caminhoFoto;
        this.legenda = legenda;
    }

    public void favoritado(Usuario usuario) {
        favoritadoPor.add(usuario);
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

}
