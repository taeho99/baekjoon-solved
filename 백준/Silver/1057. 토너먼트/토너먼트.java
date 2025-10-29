import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int zimin = Integer.parseInt(st.nextToken());
		int hansu = Integer.parseInt(st.nextToken());
		int cnt = 0;

		while(zimin != hansu) {
			zimin = (zimin+1) / 2;
			hansu = (hansu+1) / 2;
			cnt++;
		}

		System.out.println(cnt);
	}
}
