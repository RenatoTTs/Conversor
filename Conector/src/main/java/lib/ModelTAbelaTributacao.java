package lib;

import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModelTAbelaTributacao extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public JTable retornoTabelaTributacao(JTable table, Set<Tributacao> listaTributacao) {

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("");
		model.addColumn("");

		int size = listaTributacao.size();
		
		System.out.println(size);
//		int i = 0;
//		String valueAt = (String)model.getValueAt(i, 1);
			for (Tributacao tributacao : listaTributacao) {
//				if (!valueAt.equals(tributacao.getAlicota())) {
					model.addRow(new Object[] { tributacao.getCodigo(), tributacao.getAlicota() });
//				}
//				i++;
			}

		table = new JTable(model) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		return table;
	}

}
