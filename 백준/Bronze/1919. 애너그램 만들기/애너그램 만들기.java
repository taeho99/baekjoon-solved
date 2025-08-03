import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];

		for (char c : s1) {
			freq1[c - 'a']++;
		}

		for (char c : s2) {
			freq2[c - 'a']++;
		}

		int result = 0;
		for(int idx=0; idx<26; idx++) {
			result += Math.abs(freq2[idx] - freq1[idx]);
		}
		System.out.println(result);
	}
}
