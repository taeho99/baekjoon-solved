import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *	SWEA.5658 보물상자비밀번호
 *
 *	1. 회전 횟수는 N/4번 반복
 *	2. 가능한 수를 세트에 넣기
 *	3. 리스트로 바꾸고 오름차순 정렬하기
 */
public class Solution {
	static int size, kIdx;
	static String nums;
	static Set<Integer> set;
	static List<Integer> list;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			kIdx = Integer.parseInt(st.nextToken())-1; // 인덱스므로 -1
			nums = br.readLine();
			
			
			nums = nums + nums;
			
			set = new HashSet<>();
			int quater = size/4;
			for(int rotate=0; rotate<quater; rotate++) {
				for(int dir=0; dir<4; dir++) {
					int num = Integer.parseInt(nums.substring(quater*dir+rotate, quater*(dir+1)+rotate), 16);
					set.add(num);
				}
			}
			
			list = new ArrayList<>(set);
			Collections.sort(list, Comparator.reverseOrder());
			
			sb.append(list.get(kIdx)).append('\n');
		}
		System.out.print(sb);
	}
}