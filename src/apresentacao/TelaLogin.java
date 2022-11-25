package apresentacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import dados.*;

public class TelaLogin {

    private JPanel telaLogin;
    private JLabel usuarioLabel;
    private JTextField usuarioEntrada;
    private JLabel senhaLabel;
    private JPasswordField senhaEntrada;
    private JButton botaoEntrar;
    private JButton botaoCadastrar;

    public TelaLogin() {
        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame main = MainFrame.getInstancia();
                boolean sucesso = true;
                try {
                    main.logarUsuario(usuarioEntrada.getText(), Arrays.toString(senhaEntrada.getPassword()));
                } catch (Exception er) {
                    JOptionPane.showMessageDialog(main, er.getMessage());
                    usuarioEntrada.setText("");
                    senhaEntrada.setText("");
                    sucesso = false;
                }
                if ( sucesso )
                    main.mostrarTelaFeed();
            }
        });
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstancia().mostrarTelaCadastro();
            }
        });
    }

    public JPanel getPainel() {
        return telaLogin;
    }
}
