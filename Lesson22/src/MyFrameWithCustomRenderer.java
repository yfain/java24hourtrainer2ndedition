import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class MyFrameWithCustomRenderer  extends JFrame implements TableModelListener{

	MyTableModel myTableModel; 
	JTable myTable;

 MyFrameWithCustomRenderer (String winTitle){
  super(winTitle);
  
  myTableModel = new MyTableModel();
  myTable = new JTable(myTableModel );

  //Add the JTable to frame and enable scrolling 
  add(new JScrollPane( myTable));

  // Register an event listener
   myTableModel.addTableModelListener(this);
   
   //Assign the custom cell renderer to the Price column   
   // Get the reference to the fourth column - Price 
   TableColumn column = myTable.getColumnModel().getColumn(3);

  // Create a new cell renderer as an anonymous inner 
  // class and assign it to the column price
  
  column.setCellRenderer(
        new DefaultTableCellRenderer(){ 
    public Component  getTableCellRendererComponent( 
             JTable table, Object value, boolean isSelected, 
                       boolean hasFocus, int row, int col) { 

         JLabel label = (JLabel) super.getTableCellRendererComponent(
               table, value, isSelected, hasFocus, row, col); 

       // right-align the price value   
       label.setHorizontalAlignment(JLabel.RIGHT);
       
       // display stocks that cost more than $100 in red
       if (((Float) value)>100){
          label.setForeground(Color.RED);
       } else{
    	   label.setForeground(Color.BLACK); 
       }
 
       return label; 

      } // end of getTableCellRendererComponent
     }  // end of new DefaultTableCellRenderer
  );    // end of setCellRenderer(...)
   
 }

 public void tableChanged(TableModelEvent e) {
  // Code to process data changes goes here
	 System.out.println("Someone changed the data in JTable!");
 }

 public static void main(String args[]){    
  MyFrameWithCustomRenderer myFrame = new MyFrameWithCustomRenderer( "My Test Window" );

  myFrame.pack();   
  myFrame.setVisible( true );

}  

 class MyTableModel extends AbstractTableModel {
	    // The data for JTable should be here
	
		ArrayList<Order> myData = new ArrayList<Order>();
		String[] orderColNames = { "Order ID",   "Symbol", 
                "Quantity", "Price"};

	   MyTableModel(){
			
			myData.add(new Order(1,"IBM", 100, 135.5f));
			myData.add(new Order(2,"AAPL", 300, 290.12f));
			myData.add(new Order(3,"MSFT", 2000, 8.32f));
			myData.add(new Order(4,"ORCL", 500, 27.8f));
		}
		
	    public int getColumnCount() {
	      return 4;
	    }

	    public int getRowCount() {
	      return myData.size();
	    	
	    }

	    public Object getValueAt(int row, int col) {
	       
	    	switch (col) {
	    	  case 0:   // col 1
	    	    return myData.get(row).orderID;
	    	  case 1:   // col 2
	    		  return myData.get(row).stockSymbol;
	    	  case 2:   // col 3
	    		  return myData.get(row).quantity;
	    	  case 3:   // col 4 
	    		  return myData.get(row).price;
	    	  default:
	    	    return "";
	    	}
	    	
	    }
	    
	    public String getColumnName(int col){
	    	return orderColNames[col];
	    }

	    
	    public boolean isCellEditable(int row, int col) {
	    	  
	    	  if (col ==2){ 
	    	      return true;
	    	  } else {
	    	    return false;
	    	  }
	    	}

	    
	    // Update the model when the use changes the quantity
	    public void setValueAt(Object value, int row, int col){
	    
	     if (col== 2){
	       myData.get(row).quantity=(Integer.valueOf(value.toString()));
         }
	    
		//Notify the world about the change
	      //fireTableDataChanged();
	      
	      TableModelEvent event = new TableModelEvent(this, row, row, col);
	      fireTableChanged(event);
	  }

 }

}