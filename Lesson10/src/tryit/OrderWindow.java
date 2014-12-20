package tryit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OrderWindow extends JFrame {

	private BikeOrder order;
	private String selectedModel = "";
	private int selectedQuantity;

	public OrderWindow() {

		order = new BikeOrder();
		String[] bikeModels = { "", "Roadmaster", "Diamondblack", 
				                "Mongoose", "Zesty Trail" };

		JPanel windowContent = new JPanel();

		// Set the layout manager for the panel
		GridLayout gl = new GridLayout(3, 2);
		windowContent.setLayout(gl);
		JLabel modelLabel = new JLabel("Select model: ");
		JComboBox model = new JComboBox(bikeModels);

		model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox combo = (JComboBox) event.getSource();
				selectedModel = combo.getSelectedItem().toString();

			}
		});

		JLabel quantityLabel = new JLabel("Quantity: ");
		final JTextField quantity = new JTextField(20);

		JButton buttonOrder = new JButton("Order");
		final JLabel status = new JLabel(""); 
	
		buttonOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				try {
					if (selectedModel == "") {
						status.setText("Please choose model!");
					} else {
						selectedQuantity = Integer.parseInt(quantity.getText()
								.toString());
						order.validateOrder(selectedModel, selectedQuantity);
						status.setText(order.getOrder());
					}
				} catch (NumberFormatException e) {
					status.setText("Quantity must be a number");
				} catch (TooManyBikesException tmbe) {
					status.setText(tmbe.getMessage());
				}
			}
		});

		// Add controls to the panel
		windowContent.add(modelLabel);
		windowContent.add(model);
		windowContent.add(quantityLabel);
		windowContent.add(quantity);
		windowContent.add(buttonOrder);
		windowContent.add(status);

		add(windowContent);

		setTitle("Place your order");
		setSize(450, 180);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new OrderWindow();
	}

}
