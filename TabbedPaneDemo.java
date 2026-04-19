package lab5;
import javax.swing.*;
import java.awt.*;

public class TabbedPaneDemo {




	    public static void main(String[] args) {

	        // Create Frame
	        JFrame frame = new JFrame("Tabbed Pane Demo");
	        frame.setSize(400, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Create TabbedPane
	        JTabbedPane tabbedPane = new JTabbedPane();

	        // Create Panels for each tab
	        JPanel redPanel = new JPanel();
	        redPanel.setBackground(Color.RED);

	        JPanel bluePanel = new JPanel();
	        bluePanel.setBackground(Color.BLUE);

	        JPanel greenPanel = new JPanel();
	        greenPanel.setBackground(Color.GREEN);

	        // Add tabs
	        tabbedPane.addTab("RED", redPanel);
	        tabbedPane.addTab("BLUE", bluePanel);
	        tabbedPane.addTab("GREEN", greenPanel);

	        // Add tabbed pane to frame
	        frame.add(tabbedPane);

	        // Make visible
	        frame.setVisible(true);
	    }
	
}
