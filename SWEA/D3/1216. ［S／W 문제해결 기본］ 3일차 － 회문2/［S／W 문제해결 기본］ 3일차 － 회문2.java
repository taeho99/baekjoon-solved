import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
 
        for(int tc=1; tc<=T; tc++) {
            int t = Integer.parseInt(br.readLine());
            sb.append('#').append(t).append(' ');
 
            char[][] map = new char[100][100];
            for (int row = 0; row < 100; row++) {
                map[row] = br.readLine().toCharArray();
            }
 
            int result = 1;
            
            for(int len=2; len<=100; len++) {
	            for (int row = 0; row < 100; row++) {
	                for (int col = 0; col < 100 - len + 1; col++) {
	                    String word = "";
	                    for (int idx = col; idx < col + len; idx++) {
	                        word += map[row][idx];
	                    }
	                    if (isPalindrome(word)) result = Math.max(result, len);
	                }
	            }
            }
 
            for(int len=2; len<=100; len++) {
	            for(int col=0; col<100; col++) {
	                for(int row=0; row< 100-len+1; row++) {
	                    String word = "";
	                    for(int idx=row; idx<row+len; idx++) {
	                        word += map[idx][col];
	                    }
	                    if(isPalindrome(word)) result = Math.max(result, len);
	                }
	            }
            }
 
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
 
    static boolean isPalindrome(String word) {
        for(int i=0; i<word.length()/2; i++) {
            if(word.charAt(i) != word.charAt(word.length()-1-i))
                return false;
        }
        return true;
    }
}