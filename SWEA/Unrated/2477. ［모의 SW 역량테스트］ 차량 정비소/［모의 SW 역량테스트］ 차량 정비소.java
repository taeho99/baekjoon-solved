import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *	SWEA.2477 차량정비소
 *
 *	1. 창구, 고객, 찾으려는 창구 번호 등 데이터를 입력받는다.
 *		1-1. 접수 창구 처리 시간 입력 및 초기화
 *		1-2. 정비 창구 처리 시간 입력 및 및초기화
 *		1-3. 고객 도착 시간 입력 및 초기화
 *	2. 시뮬레이션 로직
 *		2-1. 접수 창구 대기열 PQ 초기화
 *			2-1-1. 도착시간 빠른 순. 도착시간 동일하면 고객 번호 작은 순
 *		2-2. 정비 창구 대기열 PQ 초기화
 *			2-1-2. 접수 끝난 시간 순. 접수 끝난 시간이 동일하면 접수 창구 번호가 작은 순 
 *		2-3. time=0 부터 시뮬레이션 시작. 모든 고객이 정비를 마칠 때까지 반복
 *			2-3-1. 정비 창구에서 정비 끝난 고객 빼주기
 *			2-3-2. 접수 창구에서 접수 끝난 고객 빼주고 정비 창구 대기열에 줄 세우기
 *			2-3-3. 정비소에 도착한 고객 접수 대기열에 줄 세우기
 *			2-3-4. 비어있는 접수 창구에 고객 넣기
 *			2-3-5. 비어있는 정비 창구에 고객 넣기
 *			2-3-6. 접수 창구에 있는 고객의 접수 경과 시간 1 증가시키기
 *			2-3-7. 정비 창구에 있는 고객의 접수 경과 시간 1 증가시키기
 *	3. 고객 배열을 순회
 *		3-1. 고객이 이용한 접수 창구 번호와 정비 창구 번호가 우리가 원하는 target 창구와 동일하면 결과값에 고객 번호 증가시키기
 *	4. target 창구와 동일한 창구를 이용한 고객이 없으면 -1 출력, 있으면 result 출력
 */
public class Solution {
	static int receptionDeskCnt, repairDeskCnt, clientCnt, targetReceptionDesk, targetRepairDesk;
	static ReceptionDesk[] receptions;
	static RepairDesk[] repairs;
	static Client[] clients;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 창구, 고객, 찾으려는 창구 번호 등 데이터를 입력받는다.
			st = new StringTokenizer(br.readLine());
			receptionDeskCnt = Integer.parseInt(st.nextToken());
			repairDeskCnt = Integer.parseInt(st.nextToken());
			clientCnt = Integer.parseInt(st.nextToken());
			targetReceptionDesk = Integer.parseInt(st.nextToken());
			targetRepairDesk = Integer.parseInt(st.nextToken());
			
			// 1-1. 접수 창구 처리 시간 입력 및 초기화
			receptions = new ReceptionDesk[receptionDeskCnt+1];
			st = new StringTokenizer(br.readLine());
			for(int idx=1; idx<=receptionDeskCnt; idx++) {
				receptions[idx] = new ReceptionDesk(idx, Integer.parseInt(st.nextToken()));
			}

			// 1-2. 정비 창구 처리 시간 입력 및 및초기화
			repairs = new RepairDesk[repairDeskCnt+1];
			st = new StringTokenizer(br.readLine());
			for(int idx=1; idx<=repairDeskCnt; idx++) {
				repairs[idx] = new RepairDesk(idx, Integer.parseInt(st.nextToken()));
			}
			
			// 1-3. 고객 도착 시간 입력 및 초기화
			clients = new Client[clientCnt+1];
			st = new StringTokenizer(br.readLine());
			for(int idx=1; idx<=clientCnt; idx++) {
				clients[idx] = new Client(idx, Integer.parseInt(st.nextToken()));
			}
			
			// 2. 시뮬레이션 로직
			simulation();
			
			int result = 0;
			// 3. 고객 배열을 순회
			for (int idx=1; idx<=clientCnt; idx++) {
				// 3-1. 고객이 이용한 접수 창구 번호와 정비 창구 번호가 우리가 원하는 target 창구와 동일
				if(clients[idx].receptionDesk == targetReceptionDesk && 
						clients[idx].repairDesk == targetRepairDesk) {
					result += clients[idx].num;
				}
			}
			
			// 4. target 창구와 동일한 창구를 이용한 고객이 없으면 -1 출력, 있으면 result 출력
			sb.append(result == 0 ? -1 : result).append('\n');
		}
		System.out.print(sb);
	}
	
	static void simulation() {
		// 2-1. 접수 창구 대기열 PQ 초기화
		// 2-1-1. 도착시간 빠른 순. 도착시간 동일하면 고객 번호 작은 순
		PriorityQueue<Client> receptionWaitPQ = 
				new PriorityQueue<>((c1, c2) ->  {
					if(c1.arriveTime == c2.arriveTime) 
						return Integer.compare(c1.num, c2.num);
					return Integer.compare(c1.arriveTime, c2.arriveTime);
				});
		
		// 2-2. 정비 창구 대기열 PQ 초기화
		// 2-1-2. 접수 끝난 시간 순. 접수 끝난 시간이 동일하면 접수 창구 번호가 작은 순 
		PriorityQueue<Client> repairWaitPQ = 
				new PriorityQueue<>((c1, c2) ->  {
					if(c1.receptFinishTime == c2.receptFinishTime) 
						return Integer.compare(c1.receptionDesk, c2.receptionDesk);
					return Integer.compare(c1.receptFinishTime, c2.receptFinishTime);
				});
		
		// 2-3. time=0 부터 시뮬레이션 시작. 모든 고객이 정비를 마칠 때까지 반복
		int time = 0;
		while(isRemainPeople()) {
			// 2-3-1. 정비 창구에서 정비 끝난 고객 빼주기
			for(int idx=1; idx<=repairDeskCnt; idx++) {
				if(repairs[idx].client == null) continue;
				if(repairs[idx].client.elapsedTime == repairs[idx].time) {
					repairs[idx].client.isFinish = true;
					repairs[idx].client = null;
				}
			}

			// 2-3-2. 접수 창구에서 접수 끝난 고객 빼주고 정비 창구 대기열에 줄 세우기
			for(int idx=1; idx<=receptionDeskCnt; idx++) {
				if(receptions[idx].client == null) continue;
				if(receptions[idx].client.elapsedTime == receptions[idx].time) {
					receptions[idx].client.receptFinishTime = time;
					repairWaitPQ.add(receptions[idx].client);
					receptions[idx].client = null;
				}
			}
			
			// 2-3-3. 정비소에 도착한 고객 접수 대기열에 줄 세우기
			for(int idx=1; idx<=clientCnt; idx++) {
				if(clients[idx].arriveTime == time) {
					receptionWaitPQ.add(clients[idx]);
				}
			}
			
			// 2-3-4. 비어있는 접수 창구에 고객 넣기
			for(int idx=1; idx<=receptionDeskCnt; idx++) {
				if(receptions[idx].client == null && !receptionWaitPQ.isEmpty()) {
					receptions[idx].client = receptionWaitPQ.poll();
					receptions[idx].client.receptionDesk = idx;
				}
			}
			
			// 2-3-5. 비어있는 정비 창구에 고객 넣기
			for(int idx=1; idx<=repairDeskCnt; idx++) {
				if(repairs[idx].client == null && !repairWaitPQ.isEmpty()) {
					repairs[idx].client = repairWaitPQ.poll();
					repairs[idx].client.repairDesk = idx;
					repairs[idx].client.elapsedTime = 0;
				}
			}
			
			// 2-3-6. 접수 창구에 있는 고객의 접수 경과 시간 1 증가시키기
			for(int idx=1; idx<=receptionDeskCnt; idx++) {
				if(receptions[idx].client == null) continue;
				receptions[idx].client.elapsedTime++;
			}
			
			// 2-3-7. 정비 창구에 있는 고객의 접수 경과 시간 1 증가시키기
			for(int idx=1; idx<=repairDeskCnt; idx++) {
				if(repairs[idx].client == null) continue;
				repairs[idx].client.elapsedTime++;
			}

			time++;
		}
	}

	static boolean isRemainPeople() {
		for(int idx=1; idx<=clientCnt; idx++) {
			if(!clients[idx].isFinish) return true;
		}
		return false;		
	}

	static class Client {
		int num, arriveTime, receptionDesk, repairDesk;
		int elapsedTime, receptFinishTime;
		boolean isFinish;

		public Client(int num, int arriveTime) {
			this.num = num;
			this.arriveTime = arriveTime;
			this.receptionDesk = 0;
			this.repairDesk = 0;
			this.elapsedTime = 0;
			this.receptFinishTime = 0;
			this.isFinish = false;
		}
	}
	
	static class ReceptionDesk {
		Client client;
		int num, time;

		public ReceptionDesk(int num, int time) {
			this.client = null;
			this.num = num;
			this.time = time;
		}
	}
	
	static class RepairDesk {
		Client client;
		int num, time;

		public RepairDesk(int num, int time) {
			this.client = null;
			this.num = num;
			this.time = time;
		}
	}
}