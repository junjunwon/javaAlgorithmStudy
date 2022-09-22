package usefulFuncs;

public abstract class StringFuncs {
	
	//javascript substr(startIndex, length) 함수를 위한 custom 
	public static String mySubString(String myString, int start, int length) {
		String result = myString.substring(start, Math.min(start + length, myString.length()));
    return result;
	}
}
