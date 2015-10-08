package testes;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.metal.MetalBorders;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class JTableHeaderCheckBox
{
    private static final int MIN_ROW_HEIGHT = 12;
    Object colNames[] = {"Teste" , "Teste3", "Teste3"};
    Object[][] data = {};
    DefaultTableModel dtm;
    JTable table;
    public JScrollPane buildGUI()
    {
        dtm = new DefaultTableModel(data,colNames);
        table = new JTable(dtm);
        for(int x = 0; x < 5; x++)
        {
            dtm.addRow(new Object[]{new Boolean(false), new Boolean(false), new Boolean(false)});
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setRowHeaderView(buildRowHeader(table));

        for(int columnNumber = 0; columnNumber < table.getColumnCount(); columnNumber++){
            TableColumn tc = table.getColumnModel().getColumn(columnNumber);
            tc.setCellEditor(table.getDefaultEditor(Boolean.class));
            tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
            tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener(), "Renato"));
        }
/*
        for(int columnNumber = 0; columnNumber < table.getColumnCount(); columnNumber++){
            TableColumn tc = table.getRo().getColumn(columnNumber);
            tc.setCellEditor(table.getDefaultEditor(Boolean.class));
            tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
            tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener(), String.valueOf(columnNumber)));
        }*/

        JFrame f = new JFrame();
        f.getContentPane().add(sp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        return sp;
    }

    private static JList buildRowHeader(final JTable table) {
    	//TODO Seta o nome nas linhas da coluna 0.
        final Vector<String> headers = new Vector<String>();
        for (int i = 0; i < table.getRowCount(); i++) {
            headers.add(String.valueOf((char) (i + 65)).toUpperCase());
        }

        ListModel lm = new AbstractListModel() {

            public int getSize() {
                return headers.size();
            }

            public Object getElementAt(int index) {
                return headers.get(index);
            }
        };

        final JList rowHeader = new JList(lm);
        //TODO ajuste da configuração da celula, como tamanho, cor ....
        rowHeader.setOpaque(false);
        rowHeader.setFixedCellWidth(20);


        MouseInputAdapter mouseAdapter = new MouseInputAdapter() {
            Cursor oldCursor;
            Cursor RESIZE_CURSOR = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
            int index = -1;
            int oldY = -1;

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                int previ = getLocationToIndex(new Point(e.getX(), e.getY() - 3));
                int nexti = getLocationToIndex(new Point(e.getX(), e.getY() + 3));
                if (previ != -1 && previ != nexti) {
                    if (!isResizeCursor()) {
                        oldCursor = rowHeader.getCursor();
                        rowHeader.setCursor(RESIZE_CURSOR);
                        index = previ;
                    }
                } else if (isResizeCursor()) {
                    rowHeader.setCursor(oldCursor);
                }
            }

            private int getLocationToIndex(Point point) {
                int i = rowHeader.locationToIndex(point);
                if (!rowHeader.getCellBounds(i, i).contains(point)) {
                    i = -1;
                }
                return i;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (isResizeCursor()) {
                    rowHeader.setCursor(oldCursor);
                    index = -1;
                    oldY = -1;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (isResizeCursor() && index != -1) {
                    int y = e.getY();
                    if (oldY != -1) {
                        int inc = y - oldY;
                        int oldRowHeight = table.getRowHeight(index);
                        if (oldRowHeight > 12 || inc > 0) {
                            int rowHeight = Math.max(MIN_ROW_HEIGHT, oldRowHeight + inc);
                            table.setRowHeight(index, rowHeight);
                            if (rowHeader.getModel().getSize() > index + 1) {
                                int rowHeight1 = table.getRowHeight(index + 1) - inc;
                                rowHeight1 = Math.max(12, rowHeight1);
                                table.setRowHeight(index + 1, rowHeight1);
                            }
                        }
                    }
                    oldY = y;
                }
            }

            private boolean isResizeCursor() {
                return rowHeader.getCursor() == RESIZE_CURSOR;
            }
        };
        rowHeader.addMouseListener(mouseAdapter);
        rowHeader.addMouseMotionListener(mouseAdapter);
        rowHeader.addMouseWheelListener(mouseAdapter);

        rowHeader.setCellRenderer(new RowHeaderRenderer(table));
        rowHeader.setBackground(table.getBackground());
        rowHeader.setForeground(table.getForeground());
        return rowHeader;
    }

    static class RowHeaderRenderer extends JLabel implements ListCellRenderer {

        private JTable table;

        RowHeaderRenderer(JTable table) {
            this.table = table;
            JTableHeader header = this.table.getTableHeader();
            setOpaque(true);
            setBorder(new MetalBorders.TableHeaderBorder());
            setHorizontalAlignment(CENTER);
            setForeground(header.getForeground());
            setBackground(header.getBackground());
            setFont(header.getFont());
            setDoubleBuffered(true);
        }

        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            setText((value == null) ? "" : value.toString());
            setPreferredSize(null);
            setPreferredSize(new Dimension((int) getPreferredSize().getWidth(), table.getRowHeight(index)));
            //trick to force repaint on JList (set updateLayoutStateNeeded = true) on BasicListUI
            list.firePropertyChange("cellRenderer", 0, 1);
            return this;
        }
    }

    class MyItemListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();

            if (source instanceof AbstractButton == false) return;
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            for(int x = 0, y = table.getRowCount(); x < y; x++)
            {
                table.setValueAt(new Boolean(checked),x, ((CheckBoxHeader) source).column );
            }
        }
    }
    public static void main (String[] args)
    {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (UnsupportedLookAndFeelException e1) {
                e1.printStackTrace();
            }
        }
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new JTableHeaderCheckBox().buildGUI();
            }
        });
    }
}

class CheckBoxHeader extends JCheckBox
        implements TableCellRenderer, MouseListener {
    protected CheckBoxHeader rendererComponent;
    protected int column;
    protected boolean mousePressed = false;
    protected  String text;

    public CheckBoxHeader(ItemListener itemListener, String text) {
        this.text = text;
        rendererComponent = this;
        rendererComponent.addItemListener(itemListener);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (table != null) {
            JTableHeader header = table.getTableHeader();
            if (header != null) {
                rendererComponent.setFont(header.getFont());
                rendererComponent.setOpaque(true);
                rendererComponent.setHorizontalAlignment(CENTER);
                rendererComponent.setForeground(header.getForeground());
                rendererComponent.setBackground(header.getBackground());
                header.addMouseListener(rendererComponent);
            }
        }

        setColumn(column);
        rendererComponent.setText(text);
        MetalBorders m = new MetalBorders();
        setBorder(new MetalBorders.TableHeaderBorder());
        rendererComponent.setBorderPainted(true);
        return rendererComponent;
    }

    protected void setColumn(int column) {
        this.column = column;
    }
    public int getColumn() {
        return column;
    }
    protected void handleClickEvent(MouseEvent e) {
        if (mousePressed) {
            mousePressed=false;
            JTableHeader header = (JTableHeader)(e.getSource());
            JTable tableView = header.getTable();
            TableColumnModel columnModel = tableView.getColumnModel();
            int viewColumn = columnModel.getColumnIndexAtX(e.getX());
            int column = tableView.convertColumnIndexToModel(viewColumn);

            if (viewColumn == this.column && e.getClickCount() == 1 && column != -1) {
                doClick();
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        handleClickEvent(e);
        ((JTableHeader)e.getSource()).repaint();
    }
    public void mousePressed(MouseEvent e) {
        mousePressed = true;
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}