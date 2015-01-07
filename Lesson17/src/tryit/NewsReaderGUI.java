package tryit;

import java.io.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class NewsReaderGUI {

    private JTextArea  textAreaLeft = new JTextArea(30,30);
    private JTextArea  textAreaRight = new JTextArea(30,30);
    
	static JProgressBar leftProgressBar;
	static JProgressBar rightProgressBar;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel(new GridBagLayout());
    
    private void displayGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      

        GridBagConstraints c = new GridBagConstraints();

        textAreaLeft.setLineWrap(true);
        textAreaLeft.setWrapStyleWord(true);
        
        JScrollPane scrolltxtLeft = new JScrollPane();
        scrolltxtLeft.setViewportView(textAreaLeft);

        JScrollPane scrolltxtRight = new JScrollPane();
        scrolltxtRight.setViewportView(textAreaRight);
        
        JButton button = new JButton("Get the News");
        
		UIManager.put("ProgressBar.selectionBackground", Color.black);
		UIManager.put("ProgressBar.selectionForeground", Color.white);
		UIManager.put("ProgressBar.foreground", new Color(8, 32, 128));
		
		DefaultBoundedRangeModel model1 = new DefaultBoundedRangeModel(0,0,0,100);
		DefaultBoundedRangeModel model2 = new DefaultBoundedRangeModel(0,0,0,100);	
		
		leftProgressBar = new JProgressBar(model1);
		rightProgressBar = new JProgressBar(model2);
        
        c.insets = new Insets(2,2,2,2);
		c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(button,c);
        
        c.gridy = 1;
        panel.add(scrolltxtLeft,c);      
        
        c.gridx = 1;
        panel.add(scrolltxtRight,c);
        
		addProgressBar(c, 0,2, leftProgressBar);
		addProgressBar(c, 1,2, rightProgressBar);
               
        frame.getContentPane().add(panel, BorderLayout.NORTH);      

        frame.pack();
        frame.setVisible(true);

        button.addActionListener( event ->{
		    new NewsReader(new File("data/left.txt"), 
					   textAreaLeft, leftProgressBar).execute();
			new NewsReader(new File("data/right.txt"), 
					  textAreaRight, rightProgressBar).execute();
        		});
    }
    
	private void addProgressBar(GridBagConstraints c, int gridx, int gridy, JProgressBar progressBar) {

		c.gridx = gridx;
		c.gridy = gridy;
		
		progressBar.setBorderPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setIndeterminate(false);
	    Border border = BorderFactory.createTitledBorder("Reading File");
	    progressBar.setBorder(border);
	    panel.add(progressBar, c);
	}

    public static void main( String[] args) {

        EventQueue.invokeLater(() -> 
                      new NewsReaderGUI().displayGUI());
    }
}
