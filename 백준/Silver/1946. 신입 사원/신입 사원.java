import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int size = Integer.parseInt(br.readLine());
			List<int[]> list = new ArrayList<>();
			while(size-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list.add(new int[] {a, b});
			}
			Collections.sort(list, (o1, o2) -> Integer.compare(o1[1], o2[1]));

			int people = 1;
			int maxScore = list.get(0)[0];
			for(int idx=1; idx<list.size(); idx++) {
				int[] now = list.get(idx);
				if(now[0] < maxScore) {
					people++;
					maxScore = now[0];
				}
			}
			sb.append(people).append('\n');
		}
		System.out.print(sb);
	}
}
