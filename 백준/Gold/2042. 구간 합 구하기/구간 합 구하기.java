import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arrSize = Integer.parseInt(st.nextToken());
		int updateCnt = Integer.parseInt(st.nextToken());
		int sumCnt = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[arrSize+1];
		for(int idx=1; idx<=arrSize; idx++) {
			arr[idx] = Long.parseLong(br.readLine());
		}
		
		SegmentTree tree = new SegmentTree(arrSize);
		tree.init(arr, 1, 1, arrSize);
		
		for(int idx=0; idx<(updateCnt+sumCnt); idx++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num1 = Integer.parseInt(st.nextToken());
			long num2 = Long.parseLong(st.nextToken());
			
			if(cmd.equals("1")) {
				long diff = num2 - arr[num1];
				arr[num1] = num2;
				tree.update(1, 1, arrSize, num1, diff);
			} else {
				long result = tree.sum(1, 1, arrSize, num1, (int)num2);
				sb.append(result).append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	static class SegmentTree {
		private long[] tree;
		
		SegmentTree(int n) {
			double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
			long treeNodeCount = Math.round(Math.pow(2, treeHeight));
			tree = new long[Math.toIntExact(treeNodeCount)];
		}
		
		long init(long[] arr, int node, int start, int end) {
			if(start == end) {
				return tree[node] = arr[start];
			} 
			return tree[node] = init(arr, node*2, start, (start+end)/2)
							  + init(arr, node*2+1, (start+end)/2+1, end);
		}
		
		long sum(int node, int start, int end, int left, int right) {
			if(end < left || right < start) return 0;
			else if(left <= start && end <= right) return tree[node];
			else {
				return sum(node*2, start, (start+end)/2, left, right)
					 + sum(node*2+1, (start+end)/2+1, end, left, right);
			}
		}
		
		void update(int node, int start, int end, int index, long diff) {
			if(index < start || end < index) return;
			
			tree[node] += diff;
			
			if(start != end) {
				update(node*2, start, (start+end)/2, index, diff);
				update(node*2+1, (start+end)/2+1, end, index, diff);
			}
		}
	}
}