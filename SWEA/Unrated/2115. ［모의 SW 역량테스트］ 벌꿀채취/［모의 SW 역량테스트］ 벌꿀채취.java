import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *	SWEA.2115 벌꿀채취
 *
 *	1. 맵(벌통)의 크기와 채취 가능한 벌통 수, 채취 벌꿀의 최대량과 맵의 정보를 입력받는다.
 *	2. 일꾼은 무조건 2명이므로 일꾼이 벌통을 채취하기 시작하는 좌표를 모두 찾는다. 
 *		(row1,col1: 첫번째 일꾼 시작위치, row2, col2: 두번째 일꾼 시작위치)
 *		2-1. 두 일꾼이 현재 시작 위치에서 채취할 수 있는 벌꿀의 최대치를 구한다.
 *	3. 두 일꾼이 현재 위치에서 채취 가능한 벌통만큼 벌꿀을 채취한다.
 *		3-1. 첫 번째 일꾼이 채취 가능한 벌통을 리스트에 추가
 *		3-2. 두 번째 일꾼이 채취 가능한 벌통을 리스트에 추가
 *		3-3. 첫 번째 일꾼이 채취 가능한 벌통의 조합(부분집합)을 구하고 최대 채취 벌꿀 양을 maxHoneySum1에 저장
 *		3-4. 두 번째 일꾼이 채취 가능한 벌통의 조합(부분집합)을 구하고 최대 채취 벌꿀 양을 maxHoneySum2에 저장
 *		3-5. 두 일꾼의 최대 채취 벌꿀 양을 더해서 result를 최대로 갱신
 *	4. 채취 가능한 벌통을 알아본다.
 *		4-1. [가지치기] 만약, 총 꿀의 양이 최대량을 넘어서면 return
 *		4-2. [기저조건] 채취할 벌통 조합을 만들었으면
 *			4-2-1. 첫 번째 일꾼인 경우 maxHoneySum1보다 income이 더 크면 갱신
 *			4-2-2. 두 번째 일꾼인 경우 maxHoneySum2보다 income이 더 크면 갱신
 *		4-3. 현재 위치의 벌통을 포함시키고 다음 위치의 벌통 알아보러 가기
 *		4-4. 현재 위치의 벌통을 포함시키지 않고 다음 위치의 벌통 알아보러 가기
 *	5. 결과값을 출력한다.
 */
public class Solution {
    static int size, bucketSize, maxCollect, maxHoneySum1, maxHoneySum2, result;
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
        	sb.append('#').append(tc).append(' ');
        	
        	// 1. 맵(벌통)의 크기와 채취 가능한 벌통 수, 채취 벌꿀의 최대량과 맵의 정보를 입력받는다.
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            bucketSize = Integer.parseInt(st.nextToken());
            maxCollect = Integer.parseInt(st.nextToken());

            map = new int[size][size];
            visited = new boolean[size][size];
            for(int row=0; row<size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            // 2. 일꾼은 무조건 2명이므로 일꾼이 벌통을 채취하기 시작하는 좌표를 모두 찾는다. 
            // (row1,col1: 첫번째 일꾼 시작위치, row2, col2: 두번째 일꾼 시작위치)
            for(int row1=0; row1<size-1; row1++) {
                for(int col1=0; col1<=size-bucketSize; col1++) {
                    for(int row2=row1+1; row2<size; row2++) {
                        for(int col2=0; col2<=size-bucketSize; col2++) {
                        	// 2-1. 두 일꾼이 현재 시작 위치에서 채취할 수 있는 벌꿀의 최대치를 구한다.
                            getMaxHoney(row1, col1, row2, col2);
                        }
                    }
                }
            }
            
            // 5. 결과값을 출력한다.
            sb.append(result).append('\n');
        }
        
        System.out.print(sb);
    }
    
    // 3. 두 일꾼이 현재 위치에서 채취 가능한 벌통만큼 벌꿀을 채취한다.
	private static void getMaxHoney(int row1, int col1, int row2, int col2) {
		List<Integer> bucket1 = new ArrayList<>();
		List<Integer> bucket2 = new ArrayList<>();
		
		// 3-1. 첫 번째 일꾼이 채취 가능한 벌통을 리스트에 추가
		for(int col=col1; col<col1+bucketSize; col++) {
			bucket1.add(map[row1][col]);
		}
		
		// 3-2. 두 번째 일꾼이 채취 가능한 벌통을 리스트에 추가
		for(int col=col2; col<col2+bucketSize; col++) {
			bucket2.add(map[row2][col]);
		}
		
		// 3-3. 첫 번째 일꾼이 채취 가능한 벌통의 조합(부분집합)을 구하고 최대 채취 벌꿀 양을 maxHoneySum1에 저장
		maxHoneySum1 = 0;
		honeyPowerSet(0, 0, 0, bucket1, 1);
		// 3-4. 두 번째 일꾼이 채취 가능한 벌통의 조합(부분집합)을 구하고 최대 채취 벌꿀 양을 maxHoneySum2에 저장
		maxHoneySum2 = 0;
		honeyPowerSet(0, 0, 0, bucket2, 2);
		
		// 3-5. 두 일꾼의 최대 채취 벌꿀 양을 더해서 result를 최대로 갱신
		result = Math.max(result, maxHoneySum1 + maxHoneySum2);
	}

	// 4. 채취 가능한 벌통을 알아본다.
	private static void honeyPowerSet(int selectIdx, int honeySum, int income, List<Integer> bucket, int bucketNo) {
		// 4-1. [가지치기] 만약, 총 꿀의 양이 최대량을 넘어서면 return
		if(honeySum > maxCollect) return;
		// 4-2. [기저조건] 채취할 벌통 조합을 만들었으면
		if(selectIdx == bucket.size()) {
			// 4-2-1. 첫 번째 일꾼인 경우 maxHoneySum1보다 income이 더 크면 갱신
			if(bucketNo == 1) {
				maxHoneySum1 = Math.max(maxHoneySum1, income);
			} 
			// 4-2-2. 두 번째 일꾼인 경우 maxHoneySum2보다 income이 더 크면 갱신
			else {
				maxHoneySum2 = Math.max(maxHoneySum2, income);
			}
			return;
		}
		
		int nowHoney = bucket.get(selectIdx);
		// 4-3. 현재 위치의 벌통을 포함시키고 다음 위치의 벌통 알아보러 가기
		honeyPowerSet(selectIdx+1, honeySum + nowHoney, income + nowHoney*nowHoney, bucket, bucketNo);
		// 4-4. 현재 위치의 벌통을 포함시키지 않고 다음 위치의 벌통 알아보러 가기
		honeyPowerSet(selectIdx+1, honeySum, income, bucket, bucketNo);
	}
}