import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        for(int i=0; i<k-1; i++) {
            arr.add(arr.get(i));
        }

        List<Integer> list = new ArrayList<>();
        int left = 0, right = k-1;
        for(int i=left; i<=right; i++) {
            list.add(arr.get(i));
        }
        Set<Integer> set = new HashSet<>(list);

        int max = 0;
        while(right < arr.size() - 1) {
            if(!set.contains(c))
                max = Math.max(max, set.size() + 1);
            else
                max = Math.max(max, set.size());
            list.remove(arr.get(left));
            left++;
            right++;
            list.add(arr.get(right));
            set = new HashSet<>(list);
        }
        if(!set.contains(c))
            max = Math.max(max, set.size() + 1);
        else
            max = Math.max(max, set.size());
        System.out.println(max);
    }
}
