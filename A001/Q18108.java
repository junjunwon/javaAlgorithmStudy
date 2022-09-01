package A001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18108 {
	public static void main(String[] args) {
		int result = 0;
		int input = 0;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			input = Integer.parseInt(br.readLine());
		} catch(IOException io) {
			io.getStackTrace();
		}
		
		result = input - 543;

		System.out.println(result);
		
	}
}
