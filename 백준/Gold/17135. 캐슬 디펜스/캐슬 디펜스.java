import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  BOJ.17135 캐슬디펜스
 *
 *  1. 맵의 크기와 공격 가능 거리, 적의 위치 입력
 *  	1-1. 적의 위치를 리스트에 추가
 *  2. 왼쪽 적부터 선택해야 하므로 column 기준 오름차순 정렬
 *  3. 궁수 3명의 위치, 조합으로 뽑아서 archers에 넣기
 *  	3-1. 적 위치와 정보 초기화 후 시뮬레이션 결과(제거한 적의 수)를 갱신
 *  4. 시뮬레이션
 * 		4-1. 죽일 수 있는 적이 남아있으면 (적의 row < rowSize)
 * 			4-1-1. 궁수가 이번 턴에 공격할 적 표시 (enemy의 isAttack을 true로)
 * 			4-1-2. 아직 죽지 않았는데 죽을 예정인 적을 죽이고(enemy의 isDie를 true로) 죽은 적의 수 카운팅
 * 			4-1-3. 적들 한칸 아래로 이동시키기
 * 			4-1-4. 적이 이번 시뮬레이션에서 몇 칸 이동했는지 기록 (적 정보 초기화때 사용)
 * 	5. 궁수가 공격할 적 표시 removeEnemy()
 * 		5-1. 적이 이미 죽었거나 격자판을 나갔으면 제외
 * 		5-2. 적이 공격 가능 거리보다 멀리 있으면 제외
 * 		5-3. 가장 가까운 적 고르기
 * 		5-4. 고른 적이 null이 아니면 공격 예정 표시하기
 * 	6. 제거할 수 있는 최대 적의 수 출력하기
 */
public class Main {
    static int rowSize, colSize, attackDist, result;
    static int[][] map;
    static Archer[] archers;
    static List<Enemy> enemies;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 맵의 크기와 공격 가능 거리, 적의 위치 입력
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        attackDist = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];
        enemies = new ArrayList<>();
        for(int row=0; row<rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<colSize; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                // 1-1. 적의 위치를 리스트에 추가
                if(map[row][col] == 1) enemies.add(new Enemy(row, col));
            }
        }

        // 2. 왼쪽 적부터 선택해야 하므로 column 기준 오름차순 정렬
        Collections.sort(enemies, (o1, o2) -> Integer.compare(o1.col, o2.col));
        
        archers = new Archer[3];
        // 3. 궁수 3명의 위치, 조합으로 뽑아서 archers에 넣기
        combination(0, 0);
        
        // 6. 제거할 수 있는 최대 적의 수 출력하기
        System.out.println(result);
    }

    private static void combination(int elementIdx, int selectIdx) {
        if(selectIdx == 3) {
        	// 3-1. 적 위치와 정보 초기화 후 시뮬레이션 결과(제거한 적의 수)를 갱신
            init();
            result = Math.max(result, simulation());
            return;
        }
        if(elementIdx == colSize) {
            return;
        }

        archers[selectIdx] = new Archer(elementIdx);
        combination(elementIdx + 1, selectIdx + 1);

        archers[selectIdx] = null;
        combination(elementIdx + 1, selectIdx);
    }

    static int lastEnemyMoveCnt;
    // 4. 시뮬레이션
    private static int simulation() {
        lastEnemyMoveCnt = 0;
        int dieEnemyCnt = 0;

        // 4-1. 죽일 수 있는 적이 남아있으면 (적의 row < rowSize)
        while(isRemainEnemy()) {
        	// 4-1-1. 궁수가 이번 턴에 공격할 적 표시 (enemy의 isAttack을 true로)
            for (Archer archer : archers) {
                archer.removeEnemy();
            }
            
            for (Enemy enemy : enemies) {
            	// 4-1-2. 아직 죽지 않았는데 죽을 예정인 적을 죽이고(enemy의 isDie를 true로) 죽은 적의 수 카운팅
            	if(!enemy.isDie && enemy.isAttack) {
            		enemy.isDie = true;
            		dieEnemyCnt++;
            	}
            	// 4-1-3. 적들 한칸 아래로 이동시키기
                enemy.row++;
            }
            
            // 4-1-4. 적이 이번 시뮬레이션에서 몇 칸 이동했는지 기록 (적 정보 초기화때 사용)
            lastEnemyMoveCnt++;
        }

        return dieEnemyCnt;
    }


    private static boolean isRemainEnemy() {
        for (Enemy enemy : enemies) {
            if(enemy.row < rowSize) return true;
        }
        return false;
    }

    private static void init() {
        for (Enemy enemy : enemies) {
            enemy.row -= lastEnemyMoveCnt;
            enemy.isDie = false;
            enemy.isAttack = false;
        }
    }

    static class Archer {
        int col;

        public Archer(int col) {
            this.col = col;
        }

        int getDistance(Enemy enemy) {
            return Math.abs(rowSize - enemy.row) + Math.abs(this.col - enemy.col);
        }

        // 5. 궁수가 공격할 적 표시 removeEnemy()
        void removeEnemy() {
            Enemy targetEnemy = null;
            int minDist = Integer.MAX_VALUE;
            
            for (Enemy enemy : enemies) {
            	// 5-1. 적이 이미 죽었거나 격자판을 나갔으면 제외
            	if(enemy.isDie || enemy.row >= rowSize) continue;
            	
            	// 5-2. 적이 공격 가능 거리보다 멀리 있으면 제외
                int dist = getDistance(enemy);
                if(dist > attackDist) continue;

                // 5-3. 가장 가까운 적 고르기
                if(dist < minDist) {
                	minDist = dist;
                    targetEnemy = enemy;
                }
            }

            // 5-4. 고른 적이 null이 아니면 공격 예정 표시하기
            if(targetEnemy != null) {
                targetEnemy.isAttack = true;
            }
        }
    }

    static class Enemy {
        int row, col;
        boolean isDie, isAttack;

        public Enemy(int row, int col) {
            this.row = row;
            this.col = col;
            this.isDie = false;
            this.isAttack = false;
        }
    }
}