package apresentacao;
import dados.Usuario;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UsuariosTableModel extends AbstractTableModel {

    private final List<Usuario> usuarios;

    public UsuariosTableModel(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String getColumnName(int column) { return "Usuários"; }

    @Override
    public int getRowCount() { return usuarios.size(); }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Class<?> getColumnClass(int j) {
        return String.class;
    }

    @Override
    public Object getValueAt(int i, int j) { return usuarios.get(i).getUserName(); }

    public void atualizar() {
        fireTableStructureChanged();
    }

}
