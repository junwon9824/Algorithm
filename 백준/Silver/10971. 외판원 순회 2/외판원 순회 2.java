 
import java.io.*;

import java.util.*;

public class Main  {
	static int n;

	static long res = Long.MAX_VALUE;
	static long[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		// 다익스트라?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new long[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			boolean[] visit = new boolean[n];
			visit[i] = true;
			solve(i, i, visit, 0);
			visit[i] = false;
		}

		System.out.println(res);

	}

	static void solve(int s, int now, boolean[] visit, long sum) {

		if (ispossible(visit)) {
			// System.out.println("in");
			if(arr[now][s]!=0)
			{
				
			sum = sum + arr[now][s]; // 마지막 노드랑 처음을 이어야하므로
			res = Math.min(res, sum);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i] && arr[now][i] != 0) {
				visit[i] = true;
				solve(s, i, visit, sum + arr[now][i]);
				visit[i] = false;
			}
		}
	}

	static boolean ispossible(boolean[] visit) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				return false;
			}
		}
		return true;
	}

}
