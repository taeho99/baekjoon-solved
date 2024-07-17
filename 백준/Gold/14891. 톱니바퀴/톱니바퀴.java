import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 임태호
 *
 * 1. 8개의 톱니를 갖고 있는 4개의 톱니 바퀴
 * 2. 톱니 바퀴를 총 K번 시계방향(1), 반시계방향(-1) 회전
 * 3-1. 맞닿은 톱니끼리 극이 같으면 나만 회전
 * 3-2. 맞닿은 톱니끼리 극이 다르면 나 회전 + 맞닿은거 반대로 회전
 * 4. 회전하기 전의 톱니를 비교 후 한꺼번에  모든 톱니가 회전
 * 5. 12시 방향 톱니의 점수 합 출력
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Gear[] gears = new Gear[4];
		
		for(int idx=0; idx<4; idx++) {
			gears[idx] = new Gear(br.readLine().trim());
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int numOfGears = Integer.parseInt(st.nextToken()) - 1;
			int rotate = Integer.parseInt(st.nextToken());
			
			int[] rotateArr;
			if(numOfGears % 2 == 0) {
				rotateArr = new int[] {rotate, rotate*-1, rotate, rotate*-1};
			} else {
				rotateArr = new int[] {rotate*-1, rotate, rotate*-1, rotate};
			}
			
			boolean[] isRotate = new boolean[4];
			isRotate[numOfGears] = true;
			switch(numOfGears) {
			case 0:
				if(!Gear.isDiff(gears[0], gears[1])) {
					break;
				}
				isRotate[1] = true;
				if(!Gear.isDiff(gears[1], gears[2])) {
					break;
				}
				isRotate[2] = true;
				if(!Gear.isDiff(gears[2], gears[3])) {
					break;
				}
				isRotate[3] = true;
				break;
			case 1:
				if(!Gear.isDiff(gears[0], gears[1]) && !Gear.isDiff(gears[1], gears[2])) {
					break;
				}
				if(Gear.isDiff(gears[0], gears[1])) {
					isRotate[0] = true;
				}
				if(Gear.isDiff(gears[1], gears[2])) {
					isRotate[2] = true;
				}
				if(!isRotate[2]) break;
				if(Gear.isDiff(gears[2], gears[3])) {
					isRotate[3] = true;
				}
				break;
			case 2:
				if(!Gear.isDiff(gears[1], gears[2]) && !Gear.isDiff(gears[2], gears[3])) {
					break;
				}
				if(Gear.isDiff(gears[1], gears[2])) {
					isRotate[1] = true;
				}
				if(Gear.isDiff(gears[2], gears[3])) {
					isRotate[3] = true;
				}
				if(!isRotate[1]) break;
				if(Gear.isDiff(gears[0], gears[1])) {
					isRotate[0] = true;
				}
				break;
			case 3:
				if(!Gear.isDiff(gears[2], gears[3])) {
					break;
				}
				isRotate[2] = true;
				if(!Gear.isDiff(gears[1], gears[2])) {
					break;
				}
				isRotate[1] = true;
				if(!Gear.isDiff(gears[0], gears[1])) {
					break;
				}
				isRotate[0] = true;
				break;
			}
			
			for(int idx=0; idx<4; idx++) {
				if(isRotate[idx]) {
					if(rotateArr[idx] == 1) {
						gears[idx].rotateRight();
					} else {
						gears[idx].rotateLeft();
					}
				}
			}
		}
		
		int result = 0;
		for(int idx=0; idx<4; idx++) {
			if(gears[idx].num[0] == 1) {
				result += (int) Math.pow(2, idx);
			}
		}
		System.out.println(result);
	}
	
	static class Gear {
		int[] num = new int[8];
		
		Gear(String str) {
			for(int idx=0; idx<8; idx++) {
				num[idx] = str.charAt(idx) - '0';
			}
		}
		
		//시계방향(1)
		void rotateRight() {
			int tmp = num[7];
			for(int idx=7; idx>=1; idx--) {
				num[idx] = num[idx-1];
			}
			num[0] = tmp;
		}
		
		//반시계방향(-1)
		void rotateLeft() {
			int tmp = num[0];
			for(int idx=0; idx<7; idx++) {
				num[idx] = num[idx+1];
			}
			num[7] = tmp;
		}
		
		static boolean isDiff(Gear g1, Gear g2) {
			return g1.num[2] != g2.num[6];
		}
	}

}
