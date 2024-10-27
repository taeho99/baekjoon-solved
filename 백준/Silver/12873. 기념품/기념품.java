import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(1);
            return;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for(int idx=0; idx<=n; idx++) {
            list.add(idx);
        }

        long step = 1, nowIdx=0;
        while(true) {
            nowIdx += step*step*step;
            if(nowIdx > list.size()) nowIdx %= (list.size()-1);
            if(nowIdx == 0) nowIdx = list.size()-1;
            list.remove((int)nowIdx);
            nowIdx--;

            if(nowIdx >= list.size()) nowIdx = 1;

            if(list.size() <= 2) break;
            step++;
        }
        System.out.println(list.get(1));
    }
}