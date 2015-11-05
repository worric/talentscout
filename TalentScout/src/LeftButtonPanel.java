import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;
public class LeftButtonPanel extends JPanel implements CenterPane {
	
	// declare widgets to be used in this pane
	JLabel hej;
	JLabel hej2;
	
	JButton but1;
	JButton but2;
	
	public LeftButtonPanel(String lblName){
		super(new GridLayout(3,1));
		
		// initialize labels
		hej = new JLabel(lblName);
		
		// initialize buttons
		but1 = new JButton("test1");
		but2 = new JButton("test2");
		
		// add action listeners to buttons
		but1.addActionListener(new ButtonListener());
		
		// add the contents to the panel object
		this.add(new JLabel(lblName));
		this.add(but1);
		this.add(but2);
		
		// set the background color of the panel
		this.setBackground(Color.BLUE);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ev) {
			
		}
		
	}

}
