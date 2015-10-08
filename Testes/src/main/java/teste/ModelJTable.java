package teste;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModelJTable extends JFrame {
  private DefaultTableModel model;

  
  
  
  private JTable table;

  public ModelJTable() {
    super();
    model = new DefaultTableModel();
    model.addColumn("");
    model.addColumn("Last Name");
    model.addColumn("Years");

    Object[] socrates = { true, "", "469-399 B.C." };
    model.addRow(socrates);

    Object[] plato = { true, "", "428-347 B.C." };
    model.addRow(plato);

    Object[] aquinas = { true, "Aquinas", "1225-1274" };
    model.addRow(aquinas);

    Object[] kierkegaard = { true, "Kierkegaard", "1813-1855" };
    model.addRow(kierkegaard);

    Object[] kant = { true, "Kant", "1724-1804" };
    model.addRow(kant);

    Object[] nietzsche = { true, "Nietzsche", "1844-1900" };
    model.addRow(nietzsche);

    Object[] arendt = { true, "Arendt", "1906-1975" };
    model.addRow(arendt);

    table = new JTable(model){
    	
    	 @Override
    		public Class<?> getColumnClass(int column) {
    			if (column == 0)
    				return Boolean.class;
    			return super.getColumnClass(column);
    		}
    	
    	
    };
    

    Container container = getContentPane();
    container.add(new JScrollPane(table), BorderLayout.CENTER);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400, 300);
    setVisible(true);
  } 
  public static void main(String args[]) {
    new ModelJTable();
  }
}
           
         