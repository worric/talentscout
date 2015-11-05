import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TopPanel extends JPanel implements CenterPane {
	
	private JLabel heading;
	private JButton switcher;
	private Bgf bgf;
	
	public TopPanel(String head, Bgf bgf){
		super();
		this.bgf = bgf;
		
		// initialize variables
		heading = new JLabel(head);
		switcher = new JButton("Switcher");
		
		switcher.addActionListener(new ButtonListener());
		
		// add content to the object
		this.add(switcher);
		this.add(Box.createHorizontalStrut(100));
		this.add(heading);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			bgf.setPlayerPane("p");
			
		}
		
	}

}
