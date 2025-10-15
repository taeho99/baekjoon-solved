import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dfs();
	}

	private static void dfs() {
		if(sb.length() == N) {
			System.out.println(sb);
			System.exit(0);
		}

		for(int idx=1; idx<=3; idx++) {
			sb.append(idx);
			if(isGood()) {
				dfs();
			}
			sb.deleteCharAt(sb.length()-1);
		}
	}

	private static boolean isGood() {
		int len = sb.length();
		for(int k=1; k<=len/2; k++) {
			String front = sb.substring(len - k * 2, len - k);
			String back = sb.substring(len-k, len);
			if(front.equals(back)) return false;
		}
		return true;
	}
}
