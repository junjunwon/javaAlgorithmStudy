package A005;

import java.util.ArrayList;
import java.util.Arrays;

public class QMockTest {

	public static int calc(int[] one, int[] answers) {
		int cnt = 0;
		int j = 0;
		for(int i = 0; i<answers.length; i++) {
			
			if(j == one.length) {
				j = 0;
			}
			if(one[j] == answers[i]) {
				cnt++;
			}
			j++;
		}

		return cnt;
	}
	public static void main(String[] args) {
		int[] one = {1,2,3,4,5};
		int[] two = {2,1,2,3,2,4,2,5};
		int[] three = {3,3,1,1,2,2,4,4,5,5};
	
//		int[] answers = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,7,8};
		int[] answers = {1,3,2,4,2};

		int[] result = new int[3];
		int[] temp = new int[3];
		ArrayList<Integer> answer = new ArrayList<>();
		result[0] = calc(one, answers);
		result[1] = calc(two, answers);
		result[2] = calc(three, answers);
		for(int i = 0; i<3; i++) {
			temp[i] = result[i];
		}
		Arrays.sort(result);
		int max = result[2];
		for(int i = 0; i<3; i++) {
			if(temp[i] == max) {
				answer.add(i+1);
			}
		}

		for(int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
}
