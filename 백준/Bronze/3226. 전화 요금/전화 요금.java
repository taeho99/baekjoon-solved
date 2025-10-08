import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0;
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			String[] hhmm = st.nextToken().split(":");
			int dd = Integer.parseInt(st.nextToken());
			int startTime = Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);

			if (startTime < 7 * 60) {
				if(startTime + dd > 7 * 60) {
					result += ((startTime + dd - (7 * 60)) * 10) + (((7 * 60) - startTime) * 5);
				} else {
					result += dd * 5;
				}
			} else if (startTime < 19 * 60) {
				if(startTime + dd > 19 * 60) {
					result += ((startTime + dd - (19 * 60)) * 5) + (((19 * 60) - startTime) * 10);
				} else {
					result += dd * 10;
				}
			} else {
				result += dd * 5;
			}
		}
		System.out.println(result);
	}
}
