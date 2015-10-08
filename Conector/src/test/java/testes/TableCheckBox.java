package testes;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableCheckBox extends DefaultTableModel {

    private static final long serialVersionUID = 1L;
    private JTable table;

    public TableCheckBox() {
        Object[] columnNames = {"Importação", "Produtos"};
        Object[][] data = {
            {false,"Descrição"},
            {false,"Codigo de Barras"},
            {false,"Valor"},
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    	return Boolean.class;
                    case 1:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
    }
    
}