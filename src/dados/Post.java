package dados;
import java.util.List;
import java.util.ArrayList;

public class Post {

    private final String caminhoFoto;
    private final String legenda;
    private final String autor;

    public Post(String caminhoFoto, String legenda, String autor) {
        this.caminhoFoto = caminhoFoto;
        this.legenda = legenda;
        this.autor = autor;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public String getAutor() {
        return autor;
    }

    public String getLegenda() {
        return legenda;
    }

}
