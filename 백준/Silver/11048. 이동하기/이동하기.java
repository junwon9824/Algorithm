 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;
import java.io.*;

class Main  {
	static int M;
	static int result = 0;

	static int[][] dp; // 가.세.대
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); //
		M = Integer.parseInt(st.nextToken()); //

		arr = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(N, M);
		System.out.println(arr[N][M]);

	}

	static void solve(int r, int c) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int tmp = Math.max(Math.max(arr[i][j - 1], arr[i - 1][j]), arr[i - 1][j - 1]);
				arr[i][j] += tmp;
			}
		}
	}
}
