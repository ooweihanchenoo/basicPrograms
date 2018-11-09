import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIclass
  extends JFrame implements ActionListener {
  private JLabel label;     // Label for hourly salary
  private JTextField tField1;  // Displays hourly salary 
  private JButton button1;
  
  /* Constructor creates GUI components and adds GUI components
   using a GridBagLayout. */
  
  GUIclass
    (){
    // Used to specify GUI component layout
    GridBagConstraints layoutConst = null;
    
    // Set frame's title
    setTitle("GUI Class");
    
    label = new JLabel("PLEASE ENTER SOMETHING:");
    
    tField1 = new JTextField(15);
    tField1.setEditable(true);
    //tField1.addActionListener(this);
    
    button1 = new JButton("Enter");
    button1.addActionListener(this);
    
    
    // Use a GridBagLayout
    setLayout(new GridBagLayout());
    layoutConst = new GridBagConstraints();
    
    // Specify component's grid location
    layoutConst.gridx = 0;
    layoutConst.gridy = 0;
    
    // 10 pixels of padding around component
    layoutConst.insets = new Insets(10, 10, 10, 10);
    
    // Add component using the specified constraints
    add(label, layoutConst);
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 1;
    layoutConst.gridy = 1;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(tField1, layoutConst);
    
    layoutConst.gridx = 0;
    layoutConst.gridy = 2;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(button1, layoutConst);
  }
  
  /* Method is automatically called when an event 
   occurs (e.g, Enter key is pressed) */
  @Override
  public void actionPerformed(ActionEvent event) {
    String userInput = ""; // User specified hourly wage
    // Get user's wage input
    userInput = tField1.getText();
    
    // Display calculated salary
    JOptionPane.showMessageDialog(null, userInput, "About", JOptionPane.INFORMATION_MESSAGE);
    
    
    return;
  }
  
  /* Creates a SalaryCalculatorFrame and makes it visible */
  public static void main(String[] args) {
    // Creates SalaryLabelFrame and its components
    GUIclass
      myFrame = new GUIclass
      ();
    
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.pack();
    myFrame.setVisible(true);
    
    return;
  }
}
