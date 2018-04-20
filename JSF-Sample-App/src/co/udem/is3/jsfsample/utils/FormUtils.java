package co.udem.is3.jsfsample.utils;

public class FormUtils {
	
	public static boolean isAnyMissing(String... fields) {
		for(String field:fields) {
			if(field==null || field.isEmpty())return true;
		}
		return false;
	}
	

	  /** Returns the word "copy" in singular or plural. That is, if n is
	   *  1, returns "copy" (for use in phrase "1 copy"), otherwise returns
	   *  "copies" (for use in phrases like "2 copies").
	   */
	  public static String wordForCopies(int n) {
	    if (n == 1) {
	      return("copy");
	    } else {
	      return("copies");
	    }
	  }


}
