import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int mapSize;
	static int[][] map;
	static Shark shark = null;
	static List<Fish> fishes = new ArrayList<>();
	
	static int[] dRow = {-1, 0, 0, 1};
	static int[] dCol = {0, -1, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		mapSize = Integer.parseInt(br.readLine());
		map = new int[mapSize][mapSize];
		for(int row=0; row<mapSize; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<mapSize; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if(map[row][col] == 0) continue;
				
				if(map[row][col] == 9) {
					shark = new Shark(row, col);
					map[row][col] = 0;
				}
				else fishes.add(new Fish(row, col, map[row][col]));
			}
		}
		
		Collections.sort(fishes);
		
		simulation();
		System.out.println(time);
	}
	
	static int time = 0;
	private static void simulation() {
		// 먹을 수 있는 물고기가 있으면 먹으러 가기
		while(isExistEatableFish()) {
			// 먹을 물고기 선택하기
			Fish targetFish = null;
			PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
				if(o1[2]==o2[2]) {
					if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[2], o2[2]);
			});
			boolean[][] visited = new boolean[mapSize][mapSize];
			
			queue.add(new int[] {shark.row, shark.col, 0});
			visited[shark.row][shark.col] = true;
			
			while(!queue.isEmpty()) {
				int[] poll = queue.poll();
				
				if(map[poll[0]][poll[1]] != 0 && map[poll[0]][poll[1]] < shark.size) {
					targetFish = new Fish(poll[0], poll[1], map[poll[0]][poll[1]]);
					time += poll[2];
					break;
				}
				
				for(int dir=0; dir<4; dir++) {
					int nRow = poll[0] + dRow[dir];
					int nCol = poll[1] + dCol[dir];
					
					if(nRow < 0 || nRow >= mapSize || nCol < 0 || nCol >= mapSize) continue;
					if(map[nRow][nCol] > shark.size) continue;
					if(visited[nRow][nCol]) continue;
					
					queue.add(new int[] {nRow, nCol, poll[2] + 1});
					visited[nRow][nCol] = true;
				}
			}
			
			if(targetFish == null) break;
			
			map[targetFish.row][targetFish.col] = 0;
			shark.row = targetFish.row;
			shark.col = targetFish.col;
			shark.ateCnt++;
			if(shark.ateCnt == shark.size) {
				shark.size++;
				shark.ateCnt = 0;
			}
			
		}
	}

	private static boolean isExistEatableFish() {
		for (Fish fish : fishes) {
			if(fish.size < shark.size) return true; 
		}
		return false;
	}

	static class Shark {
		int row, col, size, ateCnt;

		public Shark(int row, int col) {
			this.row = row;
			this.col = col;
			this.size = 2;
			this.ateCnt = 0;
		}
		
		int getDistance(Fish fish) {
			return Math.abs(this.row - fish.row)+ Math.abs(this.col - fish.col); 
		}
	}
	
	static class Fish implements Comparable<Fish> {
		int row, col, size;

		public Fish(int row, int col, int size) {
			this.row = row;
			this.col = col;
			this.size = size;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.row == o.row) return Integer.compare(this.col, o.col); 
			return Integer.compare(this.row, o.row);
		}

		@Override
		public String toString() {
			return "(" + row + ", " + col + ", " + size + ")";
		}
		
	}
}