import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int treeCnt, requireTree;
	static int[] treeHeight;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		treeCnt = Integer.parseInt(st.nextToken());
		requireTree = Integer.parseInt(st.nextToken());

		treeHeight = new int[treeCnt];
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<treeCnt; idx++) {
			treeHeight[idx] = Integer.parseInt(st.nextToken());
		}

		int lo = 0, hi = 1_000_000_000;
		while(lo + 1 < hi) {
			int mid = (lo+hi) / 2;
			if(isOk(mid)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		System.out.println(lo);
	}

	private static boolean isOk(int mid) {
		long sum = 0;
		for (int height : treeHeight) {
			if(height > mid) {
				sum += height - mid;
				if(sum >= requireTree) return true;
			}
		}
		return sum >= requireTree;
	}
}
