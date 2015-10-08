package teste;

import javax.swing.*;
import javax.swing.table.*;

public class testtt extends JFrame {

	String[][] data = { { "0", "0", "5", "1", "0", "12" }, { "5", "0", "2", "8", "0", "0" },
			{ "50", "5", "0", "8", "0", "0" }, { "8", "0", "0", "0", "5", "0" }, { "0", "0", "8", "9", "0", "10" } };

	Object[] fields = { "aaa", "bbb", "ccc", "ddd", "eee", "fff" };

	public testtt() {
		setSize(500, 135);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);

		DefaultTableModel myModel = new DefaultTableModel(data, fields);
		JTable myTable = new JTable(myModel);
		myTable.setDefaultRenderer(Object.class, new MyTableCellRender());
		JScrollPane x = new JScrollPane(myTable);
		getContentPane().add(x);
		show();
	}

	public static void main(String args[]) {
		testtt t = new testtt();
	}
}