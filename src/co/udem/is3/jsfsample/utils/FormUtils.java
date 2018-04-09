package co.udem.is3.jsfsample.utils;

public class FormUtils {
	
	public static boolean isAnyMissing(String... fields) {
		for(String field:fields) {
			if(field==null || field.isEmpty())return true;
		}
		return false;
	}

}
