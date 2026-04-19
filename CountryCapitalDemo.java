package lab5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;

public class CountryCapitalDemo {




	    public static void main(String[] args) {

	        // Create Frame
	        JFrame frame = new JFrame("Country Capitals");
	        frame.setSize(400, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new FlowLayout());

	        // Countries array
	        String[] countries = {
	            "USA", "India", "Vietnam", "Canada", "Denmark",
	            "France", "Great Britain", "Japan", "Africa",
	            "Greenland", "Singapore"
	        };

	        // Map for country -> capital
	        HashMap<String, String> capitals = new HashMap<>();
	        capitals.put("USA", "Washington D.C.");
	        capitals.put("India", "New Delhi");
	        capitals.put("Vietnam", "Hanoi");
	        capitals.put("Canada", "Ottawa");
	        capitals.put("Denmark", "Copenhagen");
	        capitals.put("France", "Paris");
	        capitals.put("Great Britain", "London");
	        capitals.put("Japan", "Tokyo");
	        capitals.put("Africa", "No single capital"); // Continent
	        capitals.put("Greenland", "Nuuk");
	        capitals.put("Singapore", "Singapore");

	        // Create JList
	        JList<String> list = new JList<>(countries);
	        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	        // Add ScrollPane
	        JScrollPane scrollPane = new JScrollPane(list);

	        // Add Listener
	        list.addListSelectionListener(new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent e) {

	                if (!e.getValueIsAdjusting()) {
	                    String selected = list.getSelectedValue();

	                    if (selected != null) {
	                        String capital = capitals.get(selected);
	                        System.out.println("Country: " + selected + " → Capital: " + capital);
	                    }
	                }
	            }
	        });

	        // Add to frame
	        frame.add(scrollPane);

	        frame.setVisible(true);
	    }
	
}
