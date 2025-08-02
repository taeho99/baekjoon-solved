import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int score = 0, result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(size-- > 0) {
			if (Integer.parseInt(st.nextToken()) == 1) {
				result += ++score;
			} else {
				score = 0;
			}
		}
		System.out.println(result);
	}
}
