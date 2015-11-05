import javax.swing.*;
import java.awt.*;
public class MainWindow extends JPanel implements CenterPane {
	
	public MainWindow(String butText1, String butText2){
		super(new GridLayout(1,3));
		
		JRadioButton but1 = new JRadioButton(butText1);
		but1.setSelected(true);
		
		JRadioButton but2 = new JRadioButton(butText2);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(but1);
		group.add(but2);
		
		JPanel radioPanel = new JPanel(new GridLayout(0,1));
		radioPanel.add(but1);
		radioPanel.add(but2);
		
		this.add(radioPanel);
		this.setBackground(Color.CYAN);
		
	}

}
