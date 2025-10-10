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
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		while(size-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new int[] {start, end});
		}

		Collections.sort(list, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return Integer.compare(o2[1] - o2[0],o1[1] - o1[0]);
			}
			return Integer.compare(o1[1], o2[1]);
		});
		int time = 0, result = 0;
		for (int[] ints : list) {
			if(time <= ints[0]) {
				result++;
				time = ints[1];
			}
		}
		System.out.println(result);
	}
}
