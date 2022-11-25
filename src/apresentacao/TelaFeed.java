package apresentacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import dados.Post;
import dados.Usuario;

public class TelaFeed {

    private JPanel telaFeed;
    private JButton botaoPerfil;
    private JScrollPane usuariosScroll;
    private JScrollPane postsScroll;
    private JButton botaoSeguir;
    private JScrollPane seguindoScroll;
    private JButton botaoDesseguir;
    private JButton botaoCurtir;
    private JScrollPane favoritosScroll;

    public JPanel getPainel() {
        return telaFeed;
    }

    public TelaFeed () {
        MainFrame main = MainFrame.getInstancia();
        final List<Post> feed = main.verFeed();
        final List<Post> favoritos = main.verFavoritos();
        final List<Usuario> seguindo = main.verSeguindo();
        List<Usuario> usuarios = main.verUsuarios();

        PostsTableModel feedModel = new PostsTableModel(feed);
        PostsTableModel favoritosModel = new PostsTableModel(favoritos);
        UsuariosTableModel usuariosModel = new UsuariosTableModel(usuarios);
        UsuariosTableModel seguindoModel = new UsuariosTableModel(seguindo);
        JTable tabelaPosts = new JTable(feedModel);
        JTable tabelaUsuarios = new JTable(usuariosModel);
        JTable tabelaSeguindo = new JTable(seguindoModel);
        JTable tabelaFavoritos = new JTable(favoritosModel);
        tabelaPosts.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaPosts.setRowHeight(260);
        tabelaFavoritos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaPosts.setRowHeight(260);

        usuariosScroll.setViewportView(tabelaUsuarios);
        postsScroll.setViewportView(tabelaPosts);
        seguindoScroll.setViewportView(tabelaSeguindo);
        favoritosScroll.setViewportView(tabelaFavoritos);

        botaoPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.mostrarTelaPerfil();
            }
        });

        botaoSeguir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelec = tabelaUsuarios.getSelectedRow();
                if ( linhaSelec == -1 )
                    JOptionPane.showMessageDialog(null, "Nenhum usuário selecionado!");
                else {
                    String usernameSelec = (String)tabelaUsuarios.getValueAt(linhaSelec, 0);
                    main.seguir(usernameSelec);
                    seguindoModel.atualizar();
                    feedModel.atualizar();
                }
            }
        });

        botaoDesseguir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelec = tabelaSeguindo.getSelectedRow();
                if ( linhaSelec == -1 )
                    JOptionPane.showMessageDialog(null, "Nenhum usuário selecionado!");
                else {
                    String usernameSelec = (String)tabelaSeguindo.getValueAt(linhaSelec, 0);
                    main.desseguir(usernameSelec);
                    seguindoModel.atualizar();
                    feedModel.atualizar();
                }
            }
        });

        botaoCurtir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelec = tabelaPosts.getSelectedRow();
                if ( linhaSelec == -1 )
                    JOptionPane.showMessageDialog(null, "Nenhum post selecionado!");
                else {
                    main.favoritar(feed.get(linhaSelec));
                    favoritosModel.atualizar();
                }
            }
        });

    }

}
