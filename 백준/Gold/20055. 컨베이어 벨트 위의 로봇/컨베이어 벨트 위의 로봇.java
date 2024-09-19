import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> status = new ArrayList<>();
        List<Boolean> robot = new ArrayList<>();
        for(int idx=1; idx<=2*length; idx++) {
            status.add(Integer.parseInt(st.nextToken()));
            robot.add(false);
        }

        int time = 0;
        int statusZeroCnt = 0;
        while(true) {
            time++;
            // 1. 컨베이어 벨트가 1칸 회전한다.
            Collections.rotate(status, 1);
            Collections.rotate(robot, 1);
            // 1-1. 내리는 위치의 로봇 내려주기
            robot.set(length-1, false);

            // 2. 먼저 올라온 로봇부터 오른쪽으로 1칸 이동한다. (내구도 남아있는 경우에만)
            for(int idx=length-1; idx>=1; idx--) {
                if(robot.get(idx-1) && !robot.get(idx) && status.get(idx) > 0) { // 다음칸 내구도 남음 && 로봇 없음
                    status.set(idx, status.get(idx)-1);
                    robot.set(idx, true);
                    robot.set(idx-1, false);
                    if(status.get(idx) == 0) statusZeroCnt++;
                }
            }
            // 2-1. 내리는 위치에 로봇이 있으면 내리기
            robot.set(length-1, false);

            // 3. 올리는 위치에 로봇을 올린다. (내구도 남아있는 경우에만)
            if(status.get(0) > 0) {
                status.set(0, status.get(0)-1);
                robot.set(0, true);
                if(status.get(0) == 0) statusZeroCnt++;
            }

            // 4. 내구도 0인 블럭이 k개 이상이면 종료
            if(statusZeroCnt >= k) break;
        }
        System.out.println(time);
    }
}