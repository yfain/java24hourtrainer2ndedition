package tryit;

public class UserPreferences implements java.io.Serializable {

	public static final long serialVersionUID = 1;
	private String color;
	private String font;
	private int fontSize;
	
	public String getColor() {
		return color;
	}
	
	public String getFont() {
		return font;
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
	public void setColor(String c) {
		color = c;
	}
	
	public void setFont(String f) {
		font = f;
	}
	
	public void setFontSize(int fs) {
		fontSize = fs;
	}
}
