import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int treeSize, requiredTreeLength, trees[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		treeSize = Integer.parseInt(st.nextToken());
		requiredTreeLength = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		trees = new int[treeSize];
		for(int idx=0; idx<treeSize; idx++) {
			trees[idx] = Integer.parseInt(st.nextToken());
		}
		
		int lo = 0, hi = 1_000_000_000;
		while(lo+1 < hi) {
			int mid = (lo+hi)/2;
			if(check(mid)) lo = mid;
			else hi = mid;
		}
		System.out.println(lo);
	}

	private static boolean check(int mid) {
		long sum = 0;
		for(int idx=0; idx<treeSize; idx++) {
			if(trees[idx] > mid) sum += trees[idx] - mid;
		}
		return sum >= requiredTreeLength;
	}
}