import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane);
        Collections.sort(box);
        if(crane.get(crane.size()-1) < box.get(box.size()-1)) {
            System.out.println(-1);
            return;
        }
        int day = 0;
        while(!box.isEmpty()) {
            day++;
//            int lastBoxPos = box.size() - 1;
            int idx = box.size()-1;
            for(int i=crane.size()-1; i>=0; ) {
                /*if(box.isEmpty()) break;
                for(int j=lastBoxPos; j>=0; j--) {
                    System.out.println("갯수 찌겅봐");

                    if(box.get(j) <= crane.get(i)) {
                        box.remove(j);
                        lastBoxPos = j - 1;
                        break;
                    }
                }*/
                if(idx == -1) break;
                else if (crane.get(i) >= box.get(idx)) {
                    box.remove(idx);
                    i--;
                    idx--;
                } else {
                    idx--;
                }
            }
        }
        System.out.println(day);
    }
}
