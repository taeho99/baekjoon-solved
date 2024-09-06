import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
			
			st = new StringTokenizer(br.readLine());
			receptionDeskCnt = Integer.parseInt(st.nextToken());
			repairDeskCnt = Integer.parseInt(st.nextToken());
			clientCnt = Integer.parseInt(st.nextToken());
			targetReceptionDesk = Integer.parseInt(st.nextToken());
			targetRepairDesk = Integer.parseInt(st.nextToken());
			
			// 접수창구 입력
			receptions = new ReceptionDesk[receptionDeskCnt+1];
			st = new StringTokenizer(br.readLine());
			for(int idx=1; idx<=receptionDeskCnt; idx++) {
				receptions[idx] = new ReceptionDesk(idx, Integer.parseInt(st.nextToken()));
			}

			repairs = new RepairDesk[repairDeskCnt+1];
			st = new StringTokenizer(br.readLine());
			for(int idx=1; idx<=repairDeskCnt; idx++) {
				repairs[idx] = new RepairDesk(idx, Integer.parseInt(st.nextToken()));
			}
			
			clients = new Client[clientCnt+1];
			st = new StringTokenizer(br.readLine());
			for(int idx=1; idx<=clientCnt; idx++) {
				clients[idx] = new Client(idx, Integer.parseInt(st.nextToken()));
			}
			
			simulation();
			
			int result = 0;
			for (int idx=1; idx<=clientCnt; idx++) {
				if(clients[idx].receptionDesk == targetReceptionDesk && 
						clients[idx].repairDesk == targetRepairDesk) {
					result += clients[idx].num;
				}
			}
			
			sb.append(result == 0 ? -1 : result).append('\n');
		}
		System.out.print(sb);
	}
	
	static void simulation() {
		int time = -1;

		
		// 접수창구 대기 줄
		PriorityQueue<Client> receptionWaitPQ = 
				new PriorityQueue<>((c1, c2) ->  {
					if(c1.arriveTime == c2.arriveTime) 
						return Integer.compare(c1.num, c2.num);
					return Integer.compare(c1.arriveTime, c2.arriveTime);
				});
		
		// 정비창구 대기 줄
		PriorityQueue<Client> repairWaitPQ = 
				new PriorityQueue<>((c1, c2) ->  {
					if(c1.receptFinishTime == c2.receptFinishTime) 
						return Integer.compare(c1.receptionDesk, c2.receptionDesk);
					return Integer.compare(c1.receptFinishTime, c2.receptFinishTime);
				});
		
		while(isRemainPeople()) {
			time++;
			// 정비 창구에서 정비 끝난 고객 빼기
			for(int idx=1; idx<=repairDeskCnt; idx++) {
				if(repairs[idx].client == null) continue;
				if(repairs[idx].client.elapsedTime == repairs[idx].time) {
					repairs[idx].client.isFinish = true;
					repairs[idx].client = null;
				}
			}

			// 경과시간이 접수 창구의 처리 시간과 같아지면, 정비 창구에 줄 세우기
			for(int idx=1; idx<=receptionDeskCnt; idx++) {
				if(receptions[idx].client == null) continue;
				if(receptions[idx].client.elapsedTime == receptions[idx].time) {
					receptions[idx].client.receptFinishTime = time;
					repairWaitPQ.add(receptions[idx].client);
					receptions[idx].client = null;
				}
			}
			
			// 현재 도착한 고객 중, 접수 창구에 줄세우기
			for(int idx=1; idx<=clientCnt; idx++) {
				if(clients[idx].arriveTime == time) {
					receptionWaitPQ.add(clients[idx]);
				}
			}
			
			// 빈 접수창구에 고객 넣기(만약, 빈 창구가 없으면 다시 PQ에 넣기)
			for(int idx=1; idx<=receptionDeskCnt; idx++) {
				if(receptions[idx].client == null && !receptionWaitPQ.isEmpty()) {
					receptions[idx].client = receptionWaitPQ.poll();
					receptions[idx].client.receptionDesk = idx;
				}
			}
			
			// 정비 창구에 고객 넣기
			for(int idx=1; idx<=repairDeskCnt; idx++) {
				if(repairs[idx].client == null && !repairWaitPQ.isEmpty()) {
					repairs[idx].client = repairWaitPQ.poll();
					repairs[idx].client.repairDesk = idx;
					repairs[idx].client.elapsedTime = 0;
				}
			}
			
			// 접수 창구에 있는 고객의 경과시간 증가시키기
			for(int idx=1; idx<=receptionDeskCnt; idx++) {
				if(receptions[idx].client == null) continue;
				receptions[idx].client.elapsedTime++;
			}
			
			// 정비 창구에 있는 고객의 경과시간 증가시키기
			for(int idx=1; idx<=repairDeskCnt; idx++) {
				if(repairs[idx].client == null) continue;
				repairs[idx].client.elapsedTime++;
			}
			
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

		@Override
		public String toString() {
			return "[num=" + num + ", receptionDesk=" + receptionDesk
					+ ", repairDesk=" + repairDesk + ", elapsedTime=" + elapsedTime + ", receptFinishTime="
					+ receptFinishTime + ", isFinish=" + isFinish + "]";
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

		@Override
		public String toString() {
			return "[" + client + ", num=" + num + ", time=" + time + "]";
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

		@Override
		public String toString() {
			return "[" + client + ", num=" + num + ", time=" + time + "]";
		}
	}
}