package lib;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeloTabelaTributacaoSoft extends DefaultTableModel{

	private static final long serialVersionUID = 1L;

	public JTable retornoTabelaTributacao(JTable table,List<TributacaoSoftpharma> listaTributacaoSoft){
	DefaultTableModel model = new DefaultTableModel();
	model.addColumn("");
	model.addColumn("");
	
	
	for (TributacaoSoftpharma tributacao : listaTributacaoSoft) {
		
		model.addRow(new Object[]{tributacao.getCodigo(),tributacao.getTributacao()});
	}
	
	
	table = new JTable(model){
		private static final long serialVersionUID = 1L;


		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	};
	
	table.getColumnModel().getColumn(0).setMaxWidth(30);
	return table;
}}
	

