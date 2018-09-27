package utp.alabrudzinska;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;
 
 
public class MyRenderer extends JLabel implements TableCellRenderer  {
 
    public MyRenderer() {
        setOpaque(true); 
    }
 
    public Component getTableCellRendererComponent(JTable table, Object value,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
    	String in = (String) table.getValueAt(row, column);
    	Color c = Color.WHITE;
    	switch(in) {
    	case "PENDING" : c = Color.YELLOW; break;
    	case "RUNNING" : c = Color.BLUE; break;
    	case "ACCOMPLISHED" : c = Color.GREEN; break;
    	case "FAILED" : c = Color.RED; break;
    	}
         setBackground(c);
         setText(in);
 
        return this;
    }
}