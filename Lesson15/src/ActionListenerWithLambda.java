
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.*;

public class ActionListenerWithLambda {

	        public static void main(String[] args) {
	            JButton oldButton = new JButton("I'm an Old Java Button");
	            JButton newButton = new JButton("I'm brand new Java Button");
	            JTextArea myConsole = new JTextArea("Click a button");

	            //Action Listener with anonymous inner class
	            oldButton.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent ae) {
	                    myConsole.setText("Processing Click with Anonymous Inner Class");
	                }
	            });

	            // Action Listener has one callback method actionPerformed()with lambda expression
	            // Implement it using lambdas
	            newButton.addActionListener(e -> {
	                myConsole.setText("Processing Click with Lambda");
	            });

         
	            JFrame frame = new JFrame("Lambdas in Swing");

	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.add(oldButton, BorderLayout.NORTH);
	            frame.add(newButton, BorderLayout.CENTER);
	            frame.add(myConsole, BorderLayout.SOUTH);

	            frame.setSize(300,400);
	            frame.setVisible(true);


	            new Thread(new Runnable() {
	                public void run() {
	                    System.out.println("Do something in this thread ");
	                }
	            });

	        }
	}
