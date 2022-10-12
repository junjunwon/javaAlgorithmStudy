package A005;

import java.util.Arrays;

public class QHIndex {

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int reverse[] = new int[citations.length];
        for(int i = 0; i<reverse.length; i++) {
            reverse[i] = citations[reverse.length-1-i];
        }
        for(int i = 0; i<reverse.length; i++) {
            if(reverse[i] == i+1) {
                return i+1;
            }
            if(reverse[i] < i+1) {
                return i;
            }
        }
        return reverse.length;
    }

    public static void main(String[]args){
//        int answer = solution(new int[]{3, 0, 6, 1, 5});
        int answer = solution(new int[]{6,5,5,5,3,2,1,0});
        System.out.println(answer);
    }
}
