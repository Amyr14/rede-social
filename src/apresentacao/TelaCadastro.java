package apresentacao;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import dados.Usuario;

public class TelaCadastro {

    private JPanel telaCadastro;
    private JLabel nomeLabel;
    private JTextField nomeEntrada;
    private JLabel usernameLabel;
    private JTextField usernameEntrada;
    private JLabel senhaLabel;
    private JPasswordField senhaEntrada;
    private JTextField biografiaEntrada;
    private JButton botaoCadastrar;

    public TelaCadastro() {
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame main = MainFrame.getInstancia();
                boolean sucesso = true;
                try {
                    main.cadastrarUsuario(nomeEntrada.getText(), usernameEntrada.getText(),
                            Arrays.toString(senhaEntrada.getPassword()), biografiaEntrada.getText());
                } catch (Exception er) {
                    JOptionPane.showMessageDialog(main, er.getMessage());
                    nomeEntrada.setText("");
                    usernameEntrada.setText("");
                    senhaEntrada.setText("");
                    biografiaEntrada.setText("");
                    sucesso = false;
                }
                if ( sucesso )
                    MainFrame.getInstancia().mostrarTelaLogin();
            }
        });
    }

    public void limparCampos() {
        nomeEntrada.setText("");
        senhaEntrada.setText("");
        biografiaEntrada.setText("");
        usernameEntrada.setText("");
    }

    public JPanel getPainel() {
        return telaCadastro;
    }

}
