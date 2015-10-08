package componentes;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class spTable extends JTable{
	private static final long serialVersionUID = 1L;
	Map<Integer, Color> rowColor = new HashMap<Integer, Color>();

     
	public spTable(DefaultTableModel model) {
		super(model);
	}
	@Override
     public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
     {
          Component c = super.prepareRenderer(renderer, row, column);

          if (!isRowSelected(row))
          {
               Color color = rowColor.get( row );
               c.setBackground(color == null ? getBackground() : color);
          }

          return c;
     }
     @Override
		public Class<?> getColumnClass(int column) {
			if (column == 0)
				return Boolean.class;
			return super.getColumnClass(column);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			if (column == 1) {
				return false;
			}
			if(row == 0){
				return false;
			}
			
			if(row == 4){
				return false;
			}
			return true;
		}

     public void setRowColor(int row, Color color)
     {
          rowColor.put(row, color);
     }

}