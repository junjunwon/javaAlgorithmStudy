package A003;

import java.lang.module.*;
public class QCompressNew {
	
	public static String mySubString(String myString, int start, int length) {
		String result = myString.substring(start, Math.min(start + length, myString.length()));
    return result;
	}

	public static int solution(String input) { 

		int result = input.length();
		//divide 1 ~ (size/2)
		//다음 값이 동일한 값일때까지 count++;
		//다음 값이 다른값이면 append(count), 
		for(int i = 1; i <= input.length()/2; i++) {
			StringBuffer sb = new StringBuffer();
			String temp = mySubString(input, 0, i);
			int count = 1;
			for(int j = i; j < input.length(); j+=i) {
				if(temp.equals(mySubString(input, j, i))) {
					count++;
				} else {
					//다음 값이랑 값이 다를 경우
					if(count > 1) sb.append(String.valueOf(count));
					sb.append(temp);
					temp = mySubString(input, j, i);
					count = 1;
				}
			}
			if(count > 1) sb.append(String.valueOf(count));
			sb.append(temp);

			result = Math.min(result, sb.toString().length());
		}

		return result;
	}
	public static void main(String[]args){
		String input = "aaaaaaaaaabbbbbbbbbb"; //길이 : 8

		System.out.println(solution(input));
	}
}
