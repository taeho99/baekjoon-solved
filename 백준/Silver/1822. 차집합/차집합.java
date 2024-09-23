import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int aSize = Integer.parseInt(st.nextToken());
		int bSize = Integer.parseInt(st.nextToken());
		
		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		while(aSize-- > 0) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		while(bSize-- > 0) {
			set.remove(Integer.parseInt(st.nextToken()));
		}
		
		if(set.size() == 0) {
			System.out.println("0");
			return;
		}
		
		sb.append(set.size()).append('\n');
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		for (int i : list) {
			sb.append(i).append(' ');
		}
		System.out.print(sb);
	}
}