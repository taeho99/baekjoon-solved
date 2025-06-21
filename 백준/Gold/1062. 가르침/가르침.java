import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int wordCnt, alphaCnt, resultMax = 0;
	static String[] words;
	static HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'n', 't', 'i', 'c'));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		wordCnt = Integer.parseInt(st.nextToken());
		alphaCnt = Integer.parseInt(st.nextToken());

		words = new String[wordCnt];
		for(int idx=0; idx<wordCnt; idx++) {
			words[idx] = br.readLine();
		}

		if(alphaCnt < 5) {
			System.out.println("0");
			return;
		}

		combination(5, 0);
		System.out.println(resultMax);
	}

	private static void combination(int selectIdx, int at) {
		if (selectIdx == alphaCnt) {
			int readableCnt = 0;
			for (String word : words) {
				if (isReadable(word)) {
					readableCnt++;
				}
			}
			resultMax = Math.max(resultMax, readableCnt);
			return;
		}

		for(int idx=at; idx<26; idx++) {
			char alpha = (char)('a' + idx);
			if (set.contains(alpha)) continue;

			set.add(alpha);
			combination(selectIdx + 1, idx + 1);
			set.remove(alpha);
		}
	}

	private static boolean isReadable(String word) {
		for(int idx=4; idx<word.length() - 4; idx++) {
			if (!set.contains(word.charAt(idx))) {
				return false;
			}
		}
		return true;
	}
}