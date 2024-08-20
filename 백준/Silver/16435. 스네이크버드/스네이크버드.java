import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ.16435 스네이크버드
 *
 * 1. 과일 개수와 스네이크버드 길이, 과일의 높이를 입력받는다.
 * 2. 과일의 높이를 오름차순 정렬한다.
 * 3. 높이가 낮은 과일부터 먹어가며 스네이크버드 길이를 늘린다.
 * 4. 최종 스네이크버드 길이를 출력한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 과일 개수와 스네이크버드 길이, 과일의 높이를 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fruitCnt = Integer.parseInt(st.nextToken());
        int snakeBirdLength = Integer.parseInt(st.nextToken());

        int[] fruits = new int[fruitCnt];
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<fruitCnt; idx++) {
            fruits[idx] = Integer.parseInt(st.nextToken());
        }

        // 2. 과일의 높이를 오름차순 정렬한다.
        Arrays.sort(fruits);

        // 3. 높이가 낮은 과일부터 먹어가며 스네이크버드 길이를 늘린다.
        for (int fruit : fruits) {
            if(snakeBirdLength >= fruit) snakeBirdLength++;
        }
        // 4. 최종 스네이크버드 길이를 출력한다.
        System.out.print(snakeBirdLength);
    }
}
