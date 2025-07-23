import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		float[] price = {350.34f, 230.90f, 190.55f, 125.30f, 180.90f};
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			sb.append(String.format("$%.2f",
				Integer.parseInt(st.nextToken()) * price[0] +
					Integer.parseInt(st.nextToken()) * price[1] +
					Integer.parseInt(st.nextToken()) * price[2] +
					Integer.parseInt(st.nextToken()) * price[3] +
					Integer.parseInt(st.nextToken()) * price[4]
			)).append('\n');
		}
		System.out.print(sb);
	}
}
