import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());
		int maxHeight = Integer.MIN_VALUE, maxHeightIdx = -1;
		int maxWidth = Integer.MIN_VALUE, maxWidthIdx = -1;
		int[] len = new int[6];
		for(int idx=0; idx<6; idx++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			len[idx] = Integer.parseInt(st.nextToken());
			if((dir == 1 || dir == 2) && len[idx] > maxHeight) {
				maxHeight = len[idx];
				maxHeightIdx = idx;
			} else if((dir == 3 || dir == 4) && len[idx] > maxWidth) {
				maxWidth = len[idx];
				maxWidthIdx = idx;
			}
		}

		maxHeightIdx += 6;
		maxWidthIdx += 6;
		int cutHeight = Math.abs(len[(maxWidthIdx-1)%6] - len[(maxWidthIdx+1)%6]);
		int cutWidth = Math.abs(len[(maxHeightIdx-1)%6] - len[(maxHeightIdx+1)%6]);
		System.out.println(((maxWidth * maxHeight) - (cutWidth * cutHeight)) * k);
	}
}
