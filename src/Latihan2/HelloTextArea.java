package Latihan2;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HelloTextArea extends JFrame {
   public HelloTextArea() {
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JLabel labelInputNama = new JLabel("Input Nama:");
	    labelInputNama.setBounds(50, 40, 100, 20); // Adjusted position

	    JTextField textFieldNama = new JTextField();
	    textFieldNama.setBounds(150, 40, 200, 20); // Adjusted position
	    
	    JLabel labelInputNotelepon = new JLabel("Input No Telepon :");
	    labelInputNotelepon.setBounds(50, 80, 100, 20); // Adjusted position

	    JTextField textFieldNotelepon = new JTextField();
	    textFieldNotelepon.setBounds(150, 80, 200, 30); // Adjusted position

	    JButton button = new JButton("klik");
	    button.setBounds(150, 120, 100, 40); // Adjusted position

	    JTextArea txtOutput = new JTextArea(); // Changed from JLabel to JTextArea
	    txtOutput.setBounds(50, 180, 300, 200); // Adjusted position
	    txtOutput.setEditable(false); // TextArea tidak bisa di-edit langsung

	    button.addActionListener(
	      new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          String nama = textFieldNama.getText();
	          String noTelepon = textFieldNotelepon.getText();
	        		  
	          txtOutput.append("Nama: " + nama + "\n"); // Updated to append text
	          txtOutput.append("No Telepon:" + noTelepon + "\n");
	          txtOutput.append("=====================\n");
	          textFieldNama.setText(""); // Clear the text field after input
	          textFieldNotelepon.setText("");
	        }
	      }
	    );

	    
	    this.add(labelInputNama);
	    this.add(textFieldNama);
	    this.add(labelInputNotelepon);
	    this.add(textFieldNotelepon);
	    this.add(button);    
	    this.add(txtOutput); // Added JTextArea to the frame
	    this.setSize(400, 450);
	    this.setLayout(null);
	  }
	 public static void main(String[] args) {
		    javax.swing.SwingUtilities.invokeLater(
		      new Runnable() {
		    	  public void run() {
		              HelloTextArea h = new HelloTextArea(); // Updated class name
		              h.setVisible(true);
		    	  }
		      }
		    ); 
    
            }
        }
