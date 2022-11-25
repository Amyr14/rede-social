package apresentacao;
import dados.Post;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class PostsTableModel extends AbstractTableModel {

    private final List<Post> posts;
    private final Class<?>[] classes = { ImageIcon.class, String.class };

    public PostsTableModel(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public int getRowCount() { return posts.size(); }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int i) {
        if ( i == 0 )
            return "Foto";
        return "Legenda";
    }

    @Override
    public Class<?> getColumnClass(int j) {
        return classes[j];
    }

    @Override
    public Object getValueAt(int i, int j) {
        Post post = posts.get(i);
        if (j == 1)
            return post.getAutor() + ": " + post.getLegenda();

        ImageIcon img = null;

        try {
            img = new ImageIcon(ImageIO.read(new File(post.getCaminhoFoto())).getScaledInstance(260, 260, Image.SCALE_SMOOTH));
        } catch(IOException ie) {
            JOptionPane.showMessageDialog(null, ie.getMessage());
        }

        return img;
    }

    public void atualizar() {
        fireTableStructureChanged();
    }

}
