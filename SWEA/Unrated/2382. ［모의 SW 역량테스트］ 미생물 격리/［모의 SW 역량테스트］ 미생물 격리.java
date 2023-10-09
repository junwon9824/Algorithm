 
import java.util.*;
import java.io.*;

public class Solution  {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class creature implements Comparable<creature> {

		int r, c, cnt, dir, idx;

		public creature(int r, int c, int cnt, int dir, int idx) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
			this.idx = idx;
		}

		@Override
		public int compareTo(creature o) {
			if (this.idx == o.idx)
				return o.cnt - this.cnt; // 내림차순 정렬 ..

			else
				return this.idx - o.idx;
		}

		@Override
		public String toString() {
			return "creature [r=" + r + ", c=" + c + ", cnt=" + cnt + ", dir=" + dir + ", idx=" + idx + "]";
		}

	}

	static ArrayList<creature> map;

	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			map = new ArrayList<>();

			arr = new int[n][n];

			makered(arr);

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken()); // 미생물수
				int dir = Integer.parseInt(st.nextToken());

				map.add(new creature(r, c, cnt, dir, r * n + c));

//					System.out.print("map " + map.get(n));
			}

			solve(m, 0, n);

			int res = 0;

			for (int i = 0; i < map.size(); i++) {

				res += map.get(i).cnt;
			}

			System.out.println("#" + tc + " " + res);

		}
	}

	static void solve(int m, int depth, int n) {
		// 한번 움직이는 로직

		int[] dr = { 0, -1, 1, 0, 0 }; // 상하좌우
		int[] dc = { 0, 0, 0, -1, 1 };

//		int size = arr.length; //n

		if (depth == m) {
			return;
		}

	//	System.out.println("start" + depth);

		for (int i = 0; i < map.size(); i++) {
			// map.size==k 미생물 군집수 .. k,m<1000

			creature cr = map.get(i);

			int r = cr.r;
			int c = cr.c;

//			System.out.println("before r c " + r + " " + c + " dir " + map.get(i).dir + " arr" + arr[r][c]);

			r += dr[map.get(i).dir];

			c += dc[map.get(i).dir];

			// System.out.println("r c " + r + " " + c + " dir " + map.get(i).dir + " cnt" +
			// map.get(i).cnt);

			cr.r = r;
			cr.c = c;
			//System.out.println("before" + cr.idx);
			cr.idx = cr.r * n + cr.c;
			//System.out.println("after" + cr.idx);

			if (arr[r][c] == -1) {

				creature cr1 = map.get(i);
				cr1.cnt = cr1.cnt / 2;
				// cnt 가 0 인 놈은 리스트에서 제거

				if (cr1.cnt == 0) {
					map.remove(i);
					i--;
//					continue;

				}

				if (cr1.dir == 4) {
					cr1.dir -= 1;

				} else if (cr1.dir == 3)
//					map.set(i, new creature(r, c, map.get(i).cnt / 2, map.get(i).dir + 1, map.get(i).idx));
					cr1.dir += 1;

				else if (cr1.dir == 2)
					cr1.dir -= 1;

				else if (cr1.dir == 1)
					cr1.dir += 1;

				cr1.idx = cr1.r * n + cr1.c;

			}
		}

		Collections.sort(map);

		for (int j = 0; j < map.size() - 1; j++) {
			creature cr = map.get(j);
			creature cr2 = map.get(j + 1);
			if (cr.idx == cr2.idx) {
				// map.get(j).cnt = map.get(j).cnt + map.get(j + 1).cnt;
				cr.cnt = cr.cnt + cr2.cnt;
				map.remove(j + 1);
				j--;
			}
		}

		//for (int i = 0; i < map.size(); i++)
			//System.out.println(" " + map.get(i).toString());

		solve(m, depth + 1, n);
	}

	static void makered(int[][] arr) {
		int size = arr.length;

		for (int i = 0; i < size; i++) {
			arr[0][i] = -1;
		}

		for (int i = 0; i < size; i++) {
			arr[i][0] = -1;
		}

		for (int i = 0; i < size; i++) {
			arr[size - 1][i] = -1;
		}
		for (int i = 0; i < size; i++) {
			arr[i][size - 1] = -1;
		}

//		for (int i = 0; i < size; i++) {
//			for (int i1 = 0; i1 < size; i1++) {
//				System.out.print(" " + arr[i][i1]);
//			}
//			System.out.println();
//		}
	}
}
