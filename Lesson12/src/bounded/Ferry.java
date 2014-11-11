package bounded;

import java.util.List;

public class Ferry {

	public void loadTruck(Truck<? extends Product> truck){ }
	
	public void unloadToDock(List<? extends Product> ferryTrucks, List<? super Product> dockTrucks){
		
      for (Product fprod: ferryTrucks){
    	  dockTrucks.add(fprod);
      }		
	}
}
