package apresentacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import dados.Post;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelaPerfil {
    private JPanel telaPerfil;
    private JLabel nomeLabel;
    private JLabel usernameLabel;
    private JLabel bioLabel;
    private JScrollPane postsScroll;
    private JButton botaoDeslogar;
    private JButton botaoPostar;
    private JButton botaoFeed;
    private JButton botaoSelecionarImagem;
    private JTextField legendaEntrada;
    private JLabel selecImagemLabel;
    private JFileChooser chooser = new JFileChooser();
    private String caminhoFoto;

    public TelaPerfil() {
        MainFrame main = MainFrame.getInstancia();
        final List<Post> posts = main.verPosts();
        nomeLabel.setText("Nome: " + main.verNome());
        bioLabel.setText("Biografia: " + main.verBiografia());
        usernameLabel.setText("Username: " + main.verUsernameLogado());
        PostsTableModel postsModel = new PostsTableModel(posts);
        JTable tabelaPosts = new JTable(postsModel);
        tabelaPosts.setRowHeight(260);
        tabelaPosts.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        postsScroll.setViewportView(tabelaPosts);

        botaoPostar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( caminhoFoto == null )
                    JOptionPane.showMessageDialog(null, "Nenhuma foto selecionada!");
                else {
                    main.postar(new Post(caminhoFoto, legendaEntrada.getText(), main.verUsernameLogado()));
                    postsModel.atualizar();
                    caminhoFoto = null;
                    legendaEntrada.setText("");
                }
            }
        });

        botaoFeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.mostrarTelaFeed();
            }
        });

        botaoDeslogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.deslogar();
            }
        });

        botaoSelecionarImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "jpg");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                    caminhoFoto = chooser.getSelectedFile().toString();
            }
        });
    }

    public JPanel getPainel() {
        return telaPerfil;
    }
}
