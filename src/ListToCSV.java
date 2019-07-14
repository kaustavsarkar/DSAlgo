import java.io.File;
import java.text.MessageFormat;
import java.util.Arrays;

public class ListToCSV {
	private static final String DROPDOWN_SELECT_XPATH_FORMAT = "//div[@aria-label=\"{0}\"]";
	public static void main(String[] args) {
		String xpath = MessageFormat.format(DROPDOWN_SELECT_XPATH_FORMAT, "India");
		System.out.println(xpath);
		
	}
}
