import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *	BOJ.1786 찾기
 *
 *	1. original 문자열과 target 문자열을 입력
 *	
 */
public class Main {
	static int resultCnt;
	static int[] pi;
	static String original, target;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		original = br.readLine();
		target = br.readLine();
		pi = new int[target.length()];
		
		makeTable();
		KMP();
		
		sb.insert(0, resultCnt+"\n");
		System.out.print(sb);
	}

	private static void makeTable() {
		int prefix = 0;
		for(int suffix=1; suffix<target.length(); suffix++) {
			// 접두사와 접미사 불일치하면
			while(prefix > 0 && target.charAt(prefix) != target.charAt(suffix)) {
				// 접두사 포인터를 직전 일치하는 곳까지 이동시키기
				prefix = pi[prefix-1];
			}
			
			if(target.charAt(prefix) == target.charAt(suffix)) {
				prefix++;
				pi[suffix] = prefix;
			}
		}
	}
	
	private static void KMP() {
		int prefix = 0;
		for(int suffix=0; suffix<original.length(); suffix++) {
			while(prefix > 0 && target.charAt(prefix) != original.charAt(suffix)) {
				prefix = pi[prefix-1];
			}
			
			if(target.charAt(prefix) == original.charAt(suffix)) {
				if(prefix + 1 == target.length()) {
					sb.append(suffix - prefix + 1).append(' ');
					resultCnt++;
					prefix = pi[prefix];
				} else {
					prefix++;
				}
			}
		}
	}
}