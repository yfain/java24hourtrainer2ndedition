import javafx.application.Application;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TableViewFX extends Application{

   TableView<Order> myTable;

   public static void main(String args[]){
	   launch(args);
   }

   
    public void init(){
    	 myTable = new TableView<>();
    }
   
    public void start(Stage stage) throws Exception {
	// TODO Auto-generated method stub
	
	
}
   
}
