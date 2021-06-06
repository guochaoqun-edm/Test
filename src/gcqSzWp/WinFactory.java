package gcqSzWp;

public class WinFactory {
	
	
	public static Button createButton() {
		return new WinButton();
	}
	
	
	public static Border createBorder() {
		return new winBorder();
	}

}
