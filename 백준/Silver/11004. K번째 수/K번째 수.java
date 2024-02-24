import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        while(N-- > 0) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        System.out.println(arr.get(K-1));
    }
}