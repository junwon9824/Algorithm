//

//import java.util.*;
//import java.io.*;
//
//public class Solution_1263_정준원 {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;
//	static int[][] map;
//	static boolean[][] visited;
//
//	public static void main(String[] args) throws Exception {
//		int TC = Integer.parseInt(br.readLine());
//
//		for (int tc = 1; tc <= TC; tc++) {
//			st = new StringTokenizer(br.readLine());
//
//			int n = Integer.parseInt(st.nextToken());
//			map = new int[n][n];
//
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//					System.out.print("Map" + map[i][j]);
//				}
//				System.out.println();
//			}
//
//			int v = solve();
//			System.out.println("#" + tc + " " + v);
//		}
//
//	}
//
//	static int solve() {
//		int rowsize = map.length;
//		int colsize = map[0].length;
//
//		int[][] dp = new int[rowsize][colsize];
//
//		for (int k = 0; k < rowsize; k++) {
//			for (int i = 0; i < colsize; i++) {
//				dp[k][i] = Integer.MAX_VALUE;
//			}
//		}
//
//		for (int k = 0; k < map.length; k++) {
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					dp[i][j] = Math.min(dp[i][j], map[i][k] + map[k][j]);
//				}
//			}
//		}
//
//		for (int i = 0; i < map.length; i++) {
//
//			for (int j = 0; j < map.length; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
//
//		int res = Integer.MAX_VALUE;
//
//		for (int i = 0; i < map.length; i++) {
//			int sum = 0;
//
//			for (int j = 0; j < map.length; j++) {
//				sum += dp[i][j];
//			}
//			System.out.println("sum" + " " + i + " " + " " + sum);
//			res = Math.min(sum, res);
//		}
//
//		return res;
//	}
//
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
	static int n;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			dist = new int[n][n]; // 거리 저장

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && dist[i][j] == 0)
						dist[i][j] = 999999; // 주 대각선이 아닌데 0인 경우
				}
			}

			floydWarshall();
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				int ret = 0;
				for (int j = 0; j < n; j++)
					ret += dist[i][j];
				min = Math.min(min, ret);
			}

			System.out.println("#" + tc + " " + min);
		}
	}

	private static void floydWarshall() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
//				if (i == k)
//					continue;
				for (int j = 0; j < n; j++) {
//					if (i == j || k == j)
//						continue;
					// 바로 가는 것 보다 k를 거쳐서 가는게 더 빠른 경우 update

					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
