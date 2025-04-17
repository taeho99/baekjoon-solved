import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, s, result = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<n; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		System.out.print(s == 0 ? result - 1 : result);
	}

	static void dfs(int sum, int depth) {
		if (depth == n) {
			if (sum == s) {
				result++;
			}
			return;
		}

		dfs(sum + arr[depth], depth + 1);
		dfs(sum, depth + 1);
	}
}