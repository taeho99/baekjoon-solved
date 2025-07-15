import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		input = input.replace(",", "");
		input = input.substring(0, input.length() - 1);

		StringTokenizer st = new StringTokenizer(input);
		String prefix = st.nextToken();
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			tmp = tmp.replace("[]", "][");

			int idx;
			for(idx=0; idx<tmp.length(); idx++) {
				if (!Character.isAlphabetic(tmp.charAt(idx))) {
					break;
				}
			}
			sb.append(prefix).append(new StringBuffer(tmp.substring(idx)).reverse()).append(' ').append(tmp, 0, idx).append(';').append('\n');
		}
		System.out.print(sb);
	}
}
