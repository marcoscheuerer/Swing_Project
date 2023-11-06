package s27_serialization.gui;

public class Utils {

	/**
	 * Function determines the file extension 
	 * @param name complete filename (with extension)
	 * @return the file extension
	 */
	public static String getFileExtension(String name) {
		int pointIndex = name.lastIndexOf(".");
		
		// no dot found in string
		if (pointIndex == -1) {
			return null;
		}
		
		// without extension, only filename
		if (pointIndex == name.length() - 1) {
			return null;
		}
		
		return name.substring(pointIndex + 1, name.length());
	}
	
}
