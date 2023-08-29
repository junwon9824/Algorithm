 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[][] dp;
	static int n;

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		arr = new int[1000][3];
		dp = new int[1000][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) {

				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//1번 집의 색은 2번 집의 색과 같지 않아야 한다. <--- 이 조건은밑에 내용 이랑 같으므로 없어도됌
//		N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
// 
		for (int j = 0; j < 3; j++)
			dp[0][j] = arr[0][j]; // 행이 집번호 열이 색깔

		for (int i = 1; i < n; i++) { // 바로 전 색과 겹치면안돼므로

			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0]; // i+1 번 집 0번색 (dp 배열이 0부터시작 하므로)
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + arr[i][2]; // i+1 번 집 2번색 (dp 배열이 0부터시작 하므로)

		}

		System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2])); // dp[n-1] 의 3개중 젤 작은거
	}

}