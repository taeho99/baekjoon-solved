import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, result;
	static boolean[] visited;
	static int n, m = 6;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		String s;
		while(!(s = br.readLine()).equals("0")) {
			st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			result = new int[m];
			visited = new boolean[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static void dfs(int depth, int at) {
		if(depth == m) {
			for (int i : result) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=at; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				dfs(depth+1, i+1);
				visited[i] = false;
			}
		}
	}

}
