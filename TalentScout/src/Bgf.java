import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bgf extends JFrame {
	
	public Bgf(String title){
		super(title);
	}
	
	public void go(){
		JFrame frame = new JFrame();
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JTextField tf = new JTextField();
		JTextArea ta = new JTextArea("mug");
		JDialog dialog = new JDialog();
		tf.setText("Skrv i mig pl0x");
		BoxLayout bxl = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		panel2.setLayout(bxl);
		JLabel lbl = new JLabel("davs");
		JLabel lblHej = new JLabel("hej");
		JLabel tests = new JLabel("tests");
		
		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.WEST, panel2);
		frame.getContentPane().add(BorderLayout.CENTER, panel3);
		
		JButton but1 = new JButton("skod");
		but1.addActionListener(new ButtonListener(tf));
		JButton but2 = new JButton("skod");
		JButton but3 = new JButton("lort");
		JButton but4 = new JButton("Gem");
		
		// but2.setAlignmentX(CENTER_ALIGNMENT);
		but3.setAlignmentX(CENTER_ALIGNMENT);
		lblHej.setAlignmentX(CENTER_ALIGNMENT);
		
		panel1.setBackground(Color.BLACK);
		panel2.setBackground(Color.WHITE);
		panel3.setBackground(Color.ORANGE);

		panel1.add(but1);
		panel1.add(Box.createHorizontalStrut(30));
		panel2.add(lblHej);
		panel2.add(but2);
		panel2.add(Box.createVerticalStrut(100));
		panel2.add(but3);
		panel1.add(lbl);
		panel3.add(tests);
		panel3.add(ta);
		panel3.add(tf);
		panel3.add(but4);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(800,600);
		
		frame.setVisible(true);
		
	}
	
	public class ButtonListener implements ActionListener {
		
		JButton button;
		JTextField tf;
		
		public ButtonListener(JButton button){
			this.button = button;
		}
		
		public ButtonListener(JTextField tf){
			this.tf = tf;
		}

		public void actionPerformed(ActionEvent e) {
			tf.setText("hejsa hejsa");
			
			
			
		}
		
	}
	
	public class GemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
