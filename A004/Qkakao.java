package A004;

public class Qkakao {
	public static void main(String[]args) {
		
		// String input = "(()())()";
		// String input = ")(";
		String input = "()))((()";
		String result = "";

		//올바른 괄호 문자열인지 확인
		boolean isPerfect = checkPerfect(input);
		if(isPerfect) {
			System.out.println(input);
		} else {
			result = calc(input);
		}
		System.out.println(result);
	}

	public static String calc(String input) {

		if("".equals(input)) return "";

		char[] temp = input.toCharArray();
		String u = "";
		String v = "";
		int leftCnt = 0;
		int rightCnt = 0;
		//균형잡힌 문자열로 분리 leftCnt, rightCnt가 같으면 바로 분리
		for(int i = 0; i<temp.length; i++){
			if(temp[i] == '(') {
				leftCnt++;
			} else {
				rightCnt++;
			}
			if(leftCnt == rightCnt)  {
				 //균형잡힌 문자열을 찾으면 분리
				 u = input.substring(0, leftCnt+rightCnt);
				 v = input.substring(leftCnt+rightCnt);
				 break;
			}
		}
		StringBuffer sb = new StringBuffer();
		if(checkPerfect(u)) {
			sb.append(u);
			sb.append(calc(v));

		} else {
			//문자열 u가 올바른 괄호 문자열이 아니라면 아래 과정을 수행한다.
			sb.append("(");
			sb.append(calc(v));
			sb.append(")");
			StringBuffer reverse = new StringBuffer();
			for(int i = 1; i < u.length()-1; i++) {
				if(u.charAt(i) == '(') reverse.append(")");
				else if(u.charAt(i) == ')') reverse.append("(");
			}
			// for(int i = u.length()-2; i > 0; i--) {
			// 	reverse.append(u.charAt(i));
			// }
			sb.append(reverse.toString());
		}
		return sb.toString();
	}

	public static boolean checkPerfect(String input) {

		char[] temp = input.toCharArray();
		int leftCnt = 0;
		int rightCnt = 0;
		
		for(int i = 0; i<temp.length; i++) {
			if(temp[i] == '(') {
				leftCnt++;
			} else {
				rightCnt++;
			}

			if(leftCnt < rightCnt) return false;
		}

		return true;
	}
	
}
