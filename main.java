import java.awt.Dimension;
import java.awt.event.ActionEvent;
// ww  w . ja va2s  . c om
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class main {
  public static void main(String[] args) {
    JScrollPane sPane = new JScrollPane();
    sPane.setPreferredSize(new Dimension(1000, 850));
    JButton button = new JButton(new AbstractAction("Hahaha lol gonque") {
      public void actionPerformed(ActionEvent arg0) {
        DefaultTableModel model = new DefaultTableModel(new Integer[][] {
            {},{},{},{},{},{},{},{},{},{},{0,1},{1,0}}, new String[] { "A", "B","C","D","E" });
        JTable table = new JTable(model);
        sPane.getViewport().add(table);
      }
    });
    
    
    
    JPanel panel = new JPanel();
    panel.add(sPane);
    panel.add(button);
    JOptionPane.showMessageDialog(null, panel);

  }
}
