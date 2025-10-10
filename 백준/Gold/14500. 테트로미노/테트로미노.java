import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][][] tetromino = {
		{
			{true, true, true, true},
		},
		{
			{true},
			{true},
			{true},
			{true},
		},
		{
			{true, true},
			{true, true},
		},
		{
			{true, true},
			{false, true},
			{false, true},
		},
		{
			{false, true},
			{false, true},
			{true, true},
		},
		{
			{true, true},
			{true, false},
			{true, false},
		},
		{
			{true, false},
			{true, false},
			{true, true},
		},
		{
			{true, true, true},
			{true, false, false},
		},
		{
			{true, true, true},
			{false, false, true},
		},
		{
			{false, false, true},
			{true, true, true},
		},
		{
			{true, false, false},
			{true, true, true},
		},
		{
			{true, false},
			{true, true},
			{false, true},
		},
		{
			{false, true},
			{true, true},
			{true, false},
		},
		{
			{true, true, false},
			{false, true, true},
		},
		{
			{false, true, true},
			{true, true, false},
		},
		{
			{true, true, true},
			{false, true, false},
		},
		{
			{false, true, false},
			{true, true, true},
		},
		{
			{true, false},
			{true, true},
			{true, false},
		},
		{
			{false, true},
			{true, true},
			{false, true},
		}
	};

	static int rowSize, colSize;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<colSize; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		int maxSum = 0;
		for(int i=0; i< tetromino.length; i++) {
			for(int j=0; j<=rowSize - tetromino[i].length; j++) {
				for(int k=0; k<=colSize - tetromino[i][0].length; k++) {
					int sum = 0;
					for(int row=j; row<j + tetromino[i].length; row++) {
						for(int col=k; col<k + tetromino[i][0].length; col++) {
							if(tetromino[i][row-j][col-k]) sum += map[row][col];
						}
					}
					maxSum = Math.max(maxSum, sum);
				}
			}
		}
		System.out.println(maxSum);
	}
}
