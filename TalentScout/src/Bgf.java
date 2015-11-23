import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//tak for hjælpen robin

public class Bgf extends JFrame {
	
	private Container contentPane = this.getContentPane();
	private final LeftButtonPanel lbp;
	private final TopPanel tpp;
	private final MainWindow mW;
	private final PlayerList pL;
	
	public Bgf(String title){
		super(title);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JTextField tf = new JTextField();
		JTextArea ta = new JTextArea("test");
		JDialog dialog = new JDialog();
		tf.setText("Skrv i mig pl0x");
		BoxLayout bxl = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		panel2.setLayout(bxl);
		JLabel lbl = new JLabel("davs");
		JLabel lblHej = new JLabel("hej");
		JLabel tests = new JLabel("tests");
		
		lbp = new LeftButtonPanel("tests");
		tpp = new TopPanel("HEADING", this);
		mW = new MainWindow("test1","test2");
		pL = new PlayerList();
		
		contentPane.add(BorderLayout.NORTH, tpp);
		contentPane.add(BorderLayout.WEST, lbp);
		contentPane.add(BorderLayout.CENTER, pL);
		
		JButton but1 = new JButton("test2");
		// but1.addActionListener(new ButtonListener(tf));
		JButton but2 = new JButton("test3");
		JButton but3 = new JButton("test4");
		JButton but4 = new JButton("Gem");
		
		// but2.setAlignmentX(CENTER_ALIGNMENT);
		but3.setAlignmentX(CENTER_ALIGNMENT);
		lblHej.setAlignmentX(CENTER_ALIGNMENT);
		
		panel1.setBackground(Color.BLACK);
		panel2.setBackground(Color.WHITE);
		panel3.setBackground(Color.ORANGE);

		
		panel2.add(lblHej);
		panel2.add(but2);
		panel2.add(Box.createVerticalStrut(100));
		panel2.add(but3);
		
		panel3.add(tests);
		panel3.add(ta);
		panel3.add(tf);
		panel3.add(but4);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(800,600);
		//this.pack();
		
		this.setVisible(true);
	}
	
	
	public void setPlayerPane(String p){
		
		contentPane.add(BorderLayout.CENTER, pL);
		this.repaint();
		
	}
	
		
}
