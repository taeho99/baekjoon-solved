import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  BOJ.17135 캐슬디펜스
 *
 *  1. 성이 있는 칸(M개 열)에서 궁수 3명의 위치를 조합으로 찾기
 *  2. 3명 궁수 모두 현재 턴에서 맵에 있는 적 중 가장 가까운 거리의 적 구하기(거리가 같으면 왼쪽부터)
 */
public class Main {
    static int rowSize, colSize, attackDist, result;
    static int[][] map;
    static Archer[] archers;
    static List<Enemy> enemies;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        attackDist = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];
        enemies = new ArrayList<>();
        for(int row=0; row<rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<colSize; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if(map[row][col] == 1) enemies.add(new Enemy(row, col));
            }
        }

        Collections.sort(enemies, (o1, o2) -> Integer.compare(o1.col, o2.col));
        archers = new Archer[3];
        combination(0, 0);
        
        System.out.println(result);
    }

    private static void combination(int elementIdx, int selectIdx) {
        if(selectIdx == 3) {
            init();
//            System.out.println(Arrays.toString(archers));
            result = Math.max(result, simulation());
//            System.out.println("==============");
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
    private static int simulation() {
        lastEnemyMoveCnt = 0;
        int dieEnemyCnt = 0;

        while(isRemainEnemy()) {
//            System.out.println("test");
            //1. 죽일 수 있는 적 모두 죽이기
            for (Archer archer : archers) {
                archer.removeEnemy();
            }

            
            //2. 적 한칸씩 내리기
            for (Enemy enemy : enemies) {
            	if(!enemy.isDie && enemy.isAttack) {
            		enemy.isDie = true;
            		 dieEnemyCnt++;
            	}
                enemy.row++;
            }
//            System.out.println(enemies);
//            System.out.println(isRemainEnemy());
            lastEnemyMoveCnt++;
        }
//        System.out.println(dieEnemyCnt);

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

        void removeEnemy() {
            Enemy targetEnemy = null;
            int minDist = Integer.MAX_VALUE;
            for (Enemy enemy : enemies) {
            	if(enemy.isDie || enemy.row >= rowSize) continue;
            	
                int dist = getDistance(enemy);
                if(dist > attackDist) continue;

                if(dist < minDist) {
                	minDist = dist;
                    targetEnemy = enemy;
                }
            }

            if(targetEnemy != null) {
                targetEnemy.isAttack = true;
            }
//            System.out.println(col + " " + targetEnemy);
        }

        @Override
        public String toString() {
            return "{" +
                    "col=" + col +
                    '}';
        }
    }

    static class Enemy {
        int row, col;
        boolean isDie, isAttack;

        public Enemy(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
        	
            return "Enemy{" +
                    "row=" + row +
                    ", col=" + col +
                    ", isAttack=" + isAttack +
                    ", isDie=" + isDie +
                    '}';
        	
        }
    }
}