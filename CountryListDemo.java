package lab5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;


public class CountryListDemo {



	    public static void main(String[] args) {

	        // Create Frame
	        JFrame frame = new JFrame("Country List");
	        frame.setSize(400, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new FlowLayout());

	        // Countries array
	        String[] countries = {
	            "USA", "India", "Vietnam", "Canada", "Denmark",
	            "France", "Great Britain", "Japan", "Africa",
	            "Greenland", "Singapore"
	        };

	        // Create JList
	        JList<String> list = new JList<>(countries);

	        // Allow multiple selection
	        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	        // Add ScrollPane (important for JList)
	        JScrollPane scrollPane = new JScrollPane(list);

	        // Add ListSelectionListener
	        list.addListSelectionListener(new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent e) {

	                // Prevent duplicate events
	                if (!e.getValueIsAdjusting()) {
	                    
	                    // Get selected values
	                    java.util.List<String> selected = list.getSelectedValuesList();

	                    // Print to console
	                    System.out.println("Selected Countries: " + selected);
	                }
	            }
	        });

	        // Add to frame
	        frame.add(scrollPane);

	        frame.setVisible(true);
	    }
	
}
