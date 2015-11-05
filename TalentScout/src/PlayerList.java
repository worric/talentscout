import java.awt.Dimension;

import javax.swing.*;
public class PlayerList extends JPanel {
	
	public PlayerList(){
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		Object[][] data = {
		        {"Kathy", "Smith",
		         "Snowboarding", new Integer(5), new Boolean(false)},
		        {"John", "Doe",
		         "Rowing", new Integer(3), new Boolean(true)},
		        {"Sue", "Black",
		         "Knitting", new Integer(2), new Boolean(false)},
		        {"Jane", "White",
		         "Speed reading", new Integer(20), new Boolean(true)},
		        {"Joe", "Brown",
		         "Pool", new Integer(10), new Boolean(false)}
		        };
		JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		JScrollPane jsp = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		this.add(jsp);
	}

}
