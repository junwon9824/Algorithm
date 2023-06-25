 
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트 케이스 개수

		int[][] dp = new int[10001][4];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;// 2 1
		dp[3][3] = 1;
		dp[4][1] = 1;
		dp[4][2] = 2; // 2 2 / 2 1 1
		dp[4][3] = 1; // 3 1
		dp[5][1] = 1; // 1 1 1 1 1
		dp[5][2] = 2; // 2 2 1 // 2 1 1
		dp[5][3] = 2; // 3 2 // 3 1 1

		for (int i = 6; i <= 10000; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];

		}

		while (t-- > 0) {
			int n = sc.nextInt(); // 정수 n

			System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
		}

		sc.close();

	}
}
