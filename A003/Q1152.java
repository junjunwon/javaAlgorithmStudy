package A003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Q1152 {
	/**
	 * 예외 처리로 인해 9분 21초 소요
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[]args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int result = input.length;
		if(input.length > 0 && "".equals(input[0])) {
			result = result -1;
		}
		System.out.println(result);

		//토크나이저 방법
		String test = "abc d e df";
		StringTokenizer st = new StringTokenizer(test, " ");
		System.out.println(st.countTokens());
	}
}