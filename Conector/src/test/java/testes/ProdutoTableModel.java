package testes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {  
      
    private final int COL_CHECK = 0;  
    private final int COL_NOME = 1;  
    private final int COL_QUANT = 2;  
      
    private List<String> produtos;  
  
    public ProdutoTableModel() {  
        produtos = new ArrayList<String>();  
    }  
  
    public ProdutoTableModel(List<String> lista) {  
        this();  
        produtos.addAll(lista);  
    }  
  
    public int getRowCount() {          
        return produtos.size();  
    }  
  
    public int getColumnCount() {          
        return 3;  
    }  
  
    @Override  
    public String getColumnName(int column) {          
        if (column == COL_CHECK){  
            return "#";  
        }  
        if (column == COL_NOME) {  
            return "Nome";  
        } else if (column == COL_QUANT) {  
            return "Quant. Disp";  
        }  
        return "";  
    }  
  
    @Override  
    public Class<?> getColumnClass(int columnIndex) {    
        if (columnIndex == COL_CHECK){  
            return Boolean.class;  
        }  
        if (columnIndex == COL_NOME) {  
            return String.class;  
        } else if (columnIndex == COL_QUANT) {  
            return Integer.class;  
        }  
        return super.getColumnClass(columnIndex);  
    }  
  
    public Object getValueAt(int rowIndex, int columnIndex) {  
        
//        if (columnIndex == COL_NOME) {  
//            return p.getNome();  
//        } else if (columnIndex == COL_QUANT) {  
////            return p.getQuant();  
//        }  
        return "";  
    }  
  
    @Override  
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
        return (columnIndex == COL_CHECK);  
    }  
  
    @Override  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
        String p = produtos.get(rowIndex);  
  
        if (columnIndex == COL_CHECK){  
        	
            new Boolean(true);  
        }  
       
  
        fireTableDataChanged();  
    } 
}