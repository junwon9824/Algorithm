 
import java.io.*;
import java.util.*;

public class Main {
	static String input;

	public static void main(String[] args) throws IOException {
		init();
		solve();
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
	}

	static void solve() {
		char[] arr = input.toCharArray();
		int ans = solution(arr); // 원래 문자열에서 팰린드롬을 만드는 법
		for (int i = 0; i < arr.length - 1; i++) { // 이 안의 알고리즘은 교환을 위한것.
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j])
					continue;

				swap(i, j, arr);
				ans = Math.min(ans, solution(arr) + 1);
				swap(i, j, arr); // 백트랙킹
			}
		}

		System.out.println(ans);
	}

	static int solution(char[] arr) {
		// 삭제와 삽입만...
		int size = arr.length;
		int[][] dp = new int[size][size];
		for (int i = 0; i < size; i++) {
			dp[i][i] = 0; //solve 에서 매번 for 문 돌기 때문에 매번 초기화 해야 한다.

			if (i != size - 1) {
				dp[i][i + 1] = arr[i] == arr[i + 1] ? 0 : 1;
			}
		}

		for (int i = 2; i < size; i++) {
			for (int j = 0; j < size - i; j++) {
				dp[j][j + i] = Math.min(dp[j + 1][j + i] + 1, dp[j][j + i - 1] + 1);
				if (arr[j + i] == arr[j]) { // 양 사이드가 같은경우
					dp[j][j + i] = Math.min(dp[j + 1][j + i - 1], dp[j][j + i]);
				} else { //3번의 문자교환
					dp[j][j + i] = Math.min(dp[j + 1][j + i - 1] + 1, dp[j][j + i]);
				}
			}
		}

		return dp[0][size - 1];
	}

	static void swap(int a, int b, char[] arr) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}