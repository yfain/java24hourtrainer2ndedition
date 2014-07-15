import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class CalculatorEngineMsg implements ActionListener {

   public void actionPerformed(ActionEvent e){
       JOptionPane.showConfirmDialog(null,
               "Something happened...",
               "Just a test",
               JOptionPane.PLAIN_MESSAGE);
   }
}