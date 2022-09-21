package A003;

import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 * 2020 KAKAO BLIND RECRUITMENT > 문자열 압축
 */
public class QCompressString {

	public static int compress(String s) {
		 
		int div = (s.split("").length/2); // 4
		int same = 0; //중복이 제거되고 같을떄 +1
		int count = 0; //중복이 단어별로 제거된 수 -> return 최종 length + count 
		int result = 1001; //최대값

		while(div > 0) {

			ArrayList<String> list = getStringArray(s, div); //devide에 따른 string값 배열로 가져오기.
			// for(int i = 0; i<list.size(); i++) {
			int i = 0;
			while(true){
				if(list.size()-1 == i) break;

				if(list.get(i).equals(list.get(i+1)) || list.get(i) == list.get(i+1)) {
					list.remove(i);
					same = same + 1;
				} else {
					if(same > 0) count++;
					same = 0;
					i++;
				}
			}
			StringBuffer sb = new StringBuffer();
			for(String temp : list) {
				sb.append(temp);
			}
			if(same > 0) {
				count++;
				same = 0;
			}
			int tempResult = sb.toString().length() + count;
			System.out.println("tempResult");
			System.out.println(tempResult);
			result = Math.min(tempResult, result);
			
			StringBuffer sb2 = new StringBuffer();
			for(String temp : list) {
				sb2.append(temp).append(" ");
			}
			System.out.println(sb2.toString());

			div = div - 1;
		}


		return result;
	}

	public static ArrayList<String> getStringArray(String s, int devide) {
		
		ArrayList<String> list = new ArrayList<>();
		
		int totalLength = s.split("").length;
		int i = 0;
		String init = s.substring(i, devide);
		int initDiv = devide;
		list.add(init);
		
		while(true) {
	
			i = initDiv + i;
			devide = devide + initDiv;
			//예외처리
			if(devide > totalLength) {
				if(totalLength%initDiv>0) {
					//나머지 값이 있으면
					list.add(s.substring(totalLength-(totalLength%initDiv)));
				}
				break;
			}
			
			list.add(s.substring(i, devide));	
		}
		
		return list;
	}

	public static void main(String[]args) {
		String input = "ababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdab"; //길이 : 8

		int result = compress(input);

		System.out.println(result);
	}
}
