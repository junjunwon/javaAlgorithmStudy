package A004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2941 {
	public static int solution(String input,String[] temp) {

		for(int i = 0; i < temp.length; i++) {
			if(input.contains(temp[i])) {
				input = input.replace(temp[i], "0");
			}
		}

		return input.length();
	}
	public static void main(String[]args) throws IOException {

		String[] temp = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		// String input = "ljes=njak";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = solution(br.readLine(), temp);

		System.out.println(result);
	}
}