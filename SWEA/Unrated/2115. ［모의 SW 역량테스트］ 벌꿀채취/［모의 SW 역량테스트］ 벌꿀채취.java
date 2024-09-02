import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SWEA.2115 벌꿀채취
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
            for(int row1=0; row1<size-1; row1++) {
                for(int col1=0; col1<=size-bucketSize; col1++) {
                    for(int row2=row1+1; row2<size; row2++) {
                        for(int col2=0; col2<=size-bucketSize; col2++) {
                            getMaxHoney(row1, col1, row2, col2, bucketSize);
                        }
                    }
                }
            }
            
            sb.append(result).append('\n');
        }
        
        System.out.print(sb);
    }
    
	private static void getMaxHoney(int row1, int col1, int row2, int col2, int bucketSize2) {
		List<Integer> bucket1 = new ArrayList<>();
		List<Integer> bucket2 = new ArrayList<>();
		
		for(int col=col1; col<col1+bucketSize; col++) {
			bucket1.add(map[row1][col]);
		}
		for(int col=col2; col<col2+bucketSize; col++) {
			bucket2.add(map[row2][col]);
		}
		
		maxHoneySum1 = 0;
		honeyPowerSet(0, 0, 0, bucket1, 1);
		maxHoneySum2 = 0;
		honeyPowerSet(0, 0, 0, bucket2, 2);
		
		result = Math.max(result, maxHoneySum1 + maxHoneySum2);
	}

	private static void honeyPowerSet(int selectIdx, int honeySum, int income, List<Integer> bucket1, int bucketNo) {
		if(honeySum > maxCollect) return;
		if(selectIdx == bucket1.size()) {
			if(bucketNo == 1) {
				maxHoneySum1 = Math.max(maxHoneySum1, income);
			} else {
				maxHoneySum2 = Math.max(maxHoneySum2, income);
			}
			return;
		}
		
		int nowHoney = bucket1.get(selectIdx);
		honeyPowerSet(selectIdx+1, honeySum + nowHoney, income + nowHoney*nowHoney, bucket1, bucketNo);
		honeyPowerSet(selectIdx+1, honeySum, income, bucket1, bucketNo);
	}
}