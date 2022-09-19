package A003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2525 {

	/**
	 * 0 =< A =< 23
	 * 0 =< B =< 59
	 */
	static int[] result = new int[2];

	public static String calc(int A, int B, int C) {

		//몫
		int tempA = C / 60;
		//나누기
		int tempB = C % 60;

		A = A + tempA;
		B = B + tempB;
		
		if(B >= 60) {
			B = B - 60;
			A++;
		}
		if(A >= 24) {
			A = A - 24;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(A))
		.append(" ")
		.append(String.valueOf(B));

		return sb.toString();
	}
	public static void main(String[]args) throws IOException{

		//입력
		// int A = 23; //시작시간(시간)
		// int B = 48; //시작시간(분)
		// int C = 25; //소요 시간(분)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());

		//출력
		System.out.println(calc(A,B,C));
	}
}
