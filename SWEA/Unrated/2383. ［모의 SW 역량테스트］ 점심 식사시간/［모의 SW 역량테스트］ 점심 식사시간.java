import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  SWEA.2383 점심식사시간
 *
 *  1. 맵의 크기와 맵의 정보를 입력받는다.
 *      1-1. 사람은 peopleList에, 계단은 길이와 함께 stairList에 저장
 *  2. 각 사람이 갈 수 있는 계단의 경우의 수를 모두 살펴본다.
 *      2-1. [기저조건] 각 사람이 갈 계단이 결정되면, 사람 데이터를 초기화하고 시뮬레이션한다.
 *  3. 모든 사람의 도착 여부와 내려가는 중 여부, 도착시간과 계단 내려갈 수 있는 시간을 초기화
 *  4. 시간을 증가시키며 시뮬레이션을 돌린다.
 *      4-0. 계단 출구로 사람이 나옴과 동시에 계단 입구로 사람이 들어갈 수 있으니 계단에서 사람이 꺼내는거 먼저 실행
 *      4-1. 아직 계단을 다 내려가지 않은 사람이 있으면
 *          4-1-1. 계단에 있는 사람을 하나씩 꺼내 확인한다.
 *          4-1-2. 그 사람이 아직 계단을 내려가는 중인 시간이면
 *              4-1-2-1. 다시 계단에 사람 넣어주기
 *          4-1-3. 계단을 모두 내려간 시간이면
 *              4-1-3-1. 사람에게 도착 표시하기
 *      4-2. 계단 입구에 사람 넣기.
 *          4-2-1. 계단 출구에 도착했거나 내려가는 중인 사람은 제외
 *          4-2-2. 계단에 공간이 있으면서 사람이 내려갈 수 있는 시간이면
 *              4-2-2-1. 계단에 사람 넣고 내려가는 중 표시해주기
 *          4-2-3. 계단이 꽉 찼는데 사람이 내려갈 수 있는 시간이면
 *              4-2-3-1. 사람이 계단을 내려갈 수 있는 시간 +1 해주기
 *  5. 시뮬레이션 후 경과한 시간 갱신해주기
 *  6. 최종적인 최소 경과 시간 출력하기
 */
public class Solution {
    static int size, minTime;
    static int[][] map;
    static List<People> peopleList;
    static List<Stair> stairList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 맵의 크기와 맵의 정보를 입력받는다.
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            peopleList = new ArrayList<>();
            stairList = new ArrayList<>();
            for(int row=0; row<size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                    // 1-1. 사람은 peopleList에, 계단은 길이와 함께 stairList에 저장
                    if(map[row][col] == 1) {
                        peopleList.add(new People(row, col));
                    } else if(map[row][col] > 1) {
                        stairList.add(new Stair(row, col, map[row][col]));
                    }
                }
            }

            minTime = Integer.MAX_VALUE;
            // 2. 각 사람이 갈 수 있는 계단의 경우의 수를 모두 살펴본다.
            selectStair(0);

            // 6. 최종적인 최소 경과 시간 출력하기
            sb.append(minTime).append('\n');
        }
        System.out.print(sb);
    }

    private static void selectStair(int selectIdx) {
        // 2-1. [기저조건] 각 사람이 갈 계단이 결정되면, 사람 데이터를 초기화하고 시뮬레이션한다.
        if(selectIdx == peopleList.size()) {
            // 3. 모든 사람의 도착 여부와 내려가는 중 여부, 도착시간과 계단 내려갈 수 있는 시간을 초기화
            init();
            // 4. 시간을 증가시키며 시뮬레이션을 돌린다.
            simulation();
            // 5. 시뮬레이션 후 경과한 시간 갱신해주기
            minTime = Math.min(minTime, time);
            return;
        }

        People people = peopleList.get(selectIdx);

        people.stair = 0; // 첫 번째 계단 선택
        selectStair(selectIdx + 1);

        people.stair = 1; // 두 번째 계단 선택
        selectStair(selectIdx + 1);
    }

    private static void init() {
        for (People people : peopleList) {
            people.calcArriveTime();
            people.isArrived = false;
            people.isGoingDown = false;
        }
    }

    static int time;
    private static void simulation() {
        time = 0;
        // 4-0. 계단 출구로 사람이 나옴과 동시에 계단 입구로 사람이 들어갈 수 있으니 계단에서 사람이 꺼내는거 먼저 실행
        // 4-1. 아직 계단을 다 내려가지 않은 사람이 있으면
        while(isRemainPeople()) {
            time++;

            // 4-1-1. 계단에 있는 사람을 하나씩 꺼내 확인한다.
            for (Stair stair : stairList) {
                int nowPeopleCnt = stair.peoples.size();
                for(int idx=0; idx<nowPeopleCnt; idx++) {
                    People people = stair.peoples.poll();
                    if(people == null) break;

                    // 4-1-2. 그 사람이 아직 계단을 내려가는 중인 시간이면
                    if(people.downStairTime + stair.length > time) {
                        // 4-1-2-1. 다시 계단에 사람 넣어주기
                        stair.peoples.add(people);
                    }
                    // 4-1-3. 계단을 모두 내려간 시간이면
                    else {
                        // 4-1-3-1. 사람에게 도착 표시하기
                        people.isArrived = true;
                    }
                }
            }

            // 4-2. 계단 입구에 사람 넣기.
            for (People people : peopleList) {
                // 4-2-1. 계단 출구에 도착했거나 내려가는 중인 사람은 제외
                if(people.isArrived) continue;
                if(people.isGoingDown) continue;

                Stair stair = stairList.get(people.stair);

                // 4-2-2. 계단에 공간이 있으면서 사람이 내려갈 수 있는 시간이면
                if(stair.peoples.size() < 3 && people.downStairTime == time) {
                    // 4-2-2-1. 계단에 사람 넣고 내려가는 중 표시해주기
                    stair.peoples.add(people);
                    people.isGoingDown = true;
                }
                // 4-2-3. 계단이 꽉 찼는데 사람이 내려갈 수 있는 시간이면
                else if(stair.peoples.size() == 3 && people.downStairTime == time) {
                    // 4-2-3-1. 사람이 계단을 내려갈 수 있는 시간 +1 해주기
                    people.downStairTime++;
                }
            }
        }
    }

    static boolean isRemainPeople() {
        for (People people : peopleList) {
            if(!people.isArrived) return true;
        }
        return false;
    }

    static class People implements Comparable<People> {
        int row, col, stair, arriveTime, downStairTime;
        boolean isArrived, isGoingDown;

        public People(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void calcArriveTime() {
            arriveTime = Math.abs(this.row - stairList.get(this.stair).row) + Math.abs(this.col - stairList.get(this.stair).col);
            downStairTime = arriveTime + 1;
        }

        @Override
        public int compareTo(People p) {
            return Integer.compare(this.downStairTime, p.downStairTime);
        }
    }

    static class Stair {
        int row, col, length;
        Queue<People> peoples;

        public Stair(int row, int col, int length) {
            this.row = row;
            this.col = col;
            this.length = length;
            peoples = new PriorityQueue<>();
        }
    }
}