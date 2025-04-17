import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

	public String solution(int[] numbers) {
		String answer = "";
		List<String> list = new ArrayList<>();
		for (int number : numbers) {
			list.add(String.valueOf(number));
		}

		Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		if (list.get(0).equals("0")) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}

}