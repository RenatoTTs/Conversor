package lib;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import componentes.spTable;

public class TableCheckBox{

	Map<Integer, Color> rowColor = new HashMap<Integer, Color>();

	public spTable retornarTabela() {

		final DefaultTableModel model = new DefaultTableModel();
		
		ObjetoListaAtualizacao objetoListaAtualizacao = new ObjetoListaAtualizacao();
		
		model.addColumn("Importação");
		model.addColumn("Produtos");
		List<Object[]> descricao = objetoListaAtualizacao.getDescricao();
		
		for (Object[] objects : descricao) {
			model.addRow(objects);
			
		}
		
		spTable table = new spTable(model);
		

		table.getColumnModel().getColumn(0).setMaxWidth(30);
		return table;
	}
	public void setRowColor(int row, Color cor){
		
		rowColor.put(row, cor);
		
	}

}