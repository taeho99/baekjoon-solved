import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<Long> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		if(n <= 10) System.out.println(n);
		else if(n > 1022) System.out.println("-1");
		else {
			bp(0, 1);
			bp(1, 1);
			bp(2, 1);
			bp(3, 1);
			bp(4, 1);
			bp(5, 1);
			bp(6, 1);
			bp(7, 1);
			bp(8, 1);
			bp(9, 1);
			Collections.sort(list);

			System.out.println(list.get(n));
		}
	}

	public static void bp(long num, int idx) {
		if(idx > 10) return;

		list.add(num);
		for(int i = 0; i < num % 10; i++) {
			bp((num * 10) + i, idx + 1);
		}
	}
}