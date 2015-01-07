package tryit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class NewsReader extends SwingWorker<String, String> {
	
	File newsFile = null;
	long fileSize;

	JTextArea textAreaToFill = null;
	JProgressBar progressBar = null;
	
	NewsReader(File file, JTextArea textArea, JProgressBar pbar){
		
		progressBar = pbar;
		
		if (file.exists()){
			newsFile = file;
			textAreaToFill = textArea;
		} else {
			JOptionPane.showMessageDialog(null, "File ".concat(file.getName()).concat(" not found"));
		}
	}
	
	protected String doInBackground() throws Exception {
		String fileContent = null;
		try (FileReader fr = new FileReader(newsFile);
			BufferedReader br = new BufferedReader(fr);){

			fileSize = newsFile.length(); 
			
			fileContent = new String();
			String currentLine = new String();
			
			while ((currentLine = br.readLine()) != null){
				fileContent = fileContent.concat(currentLine + "\n");
				int read = fileContent.length();
		        int percent =  (int)(((double) read) / ((double) fileSize) * 100.);
                setProgress(percent);
                publish(currentLine);
 			}
            setProgress(100);
            publish("");
			br.close();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

		return fileContent;
	}
	
	protected void process(List<String> fragments) {
	        for (String line : fragments) {
	        	  if (isCancelled()) {
	        	      break;
	        	  }
		      progressBar.setValue(getProgress());
	        }
	  }       
	
	protected void done(){
		try {
			textAreaToFill.setText(get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
