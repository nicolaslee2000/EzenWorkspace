package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test07 {
	public static void main(String[] args) {
		String line = "This order was placed for QT3000! OK?";
	      String pattern = "T+.*";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	      System.out.println(r);
	      System.out.println(m.matches());
	}
}
