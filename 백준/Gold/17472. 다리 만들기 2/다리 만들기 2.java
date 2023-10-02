 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main  {
	static boolean[][] visit;
	static int[][] arr;
	static int[] parent;
	static ArrayList<node>[] list = new ArrayList[7];
	static PriorityQueue<point> pq = new PriorityQueue<>();
	static int M;
	static int N;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int sum = 0;
	static int cnt = 1;

	static class point implements Comparable<point> { // point 오름차순
		int a, b, cost;

		public point(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(point o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}

	static class node {
		int r, c;

		public node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {

		// n-1개 다리가 있어야 연결된다.
		// 다리 길이는 2이상이어야 한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
//                System.out.print("arr" + arr[i][j]);
			}
		}
//		System.out.println("27" + arr[2][7]);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && arr[i][j] == 1) {
					list[cnt] = new ArrayList<>();
					bfs(i, j, N, M, cnt++);
				}
			}
		}

		parent = new int[cnt];

		for (int i = 1; i < cnt; i++) {
			parent[i] = i;

		}

		//System.out.println("cnt" + cnt);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
			//	System.out.print("arr    " + arr[i][j]);
			}
		//	System.out.println();
		}

		for (int i = 1; i < cnt; i++) {
			// System.out.println("lists" + list[i].size());

			for (int j = 0; j < list[i].size(); j++) {
				node n = list[i].get(j);

				for (int k = 0; k < 4; k++) {
					int na = n.r;
					int nb = n.c;
					// System.out.println("start" + na + " " + nb + " i" + i);
					if (isvalid(na, nb))
						connect(cnt, k, 0, na, nb, i);
				}
			}

			// System.out.println("end " + i);
		}

		int v = kruskal();

		System.out.println(v);
	}

	static void connect(int cnt, int dir, int len, int r, int c, int num) {

		// System.out.println(" " + " r c" + r + " " + c);
		// System.out.println("arr" + arr[r][c] + " r c" + r + " " + c);

		if (arr[r][c] != num && arr[r][c] != 0 && len - 1 >= 2) {
			len--;
			// System.out.println(
			// "pqadd" + r + " " + c + "num arr[r][c] len dir" + num + " " + arr[r][c] + " "
			// + len + " " + dir);
			pq.add(new point(num, arr[r][c], len));
			return;
		} else if (arr[r][c] != num && arr[r][c] != 0 && len - 1 < 2) {
			return;
		}

		int nr = r + dr[dir];
		int nc = c + dc[dir];

		if (isvalid(nr, nc) && arr[nr][nc] == num) {
			return;
		}

		if (isvalid(nr, nc) && arr[nr][nc] != num) {
			// System.out.println("nr nc" + nr + " " + nc);
			connect(cnt, dir, len + 1, nr, nc, num);
		}

	}

	static int kruskal() {
		int size = pq.size();
		// System.out.println("krus" + size);
		int bsize = 0;

		for (int i = 0; i < size; i++) {
			point p = pq.poll();
		//	System.out.println("p" + p.a + " " + p.b + "cost" + p.cost);
			int na = find(p.a);
			int nb = find(p.b);

			if (na != nb) {
				sum += p.cost;
				//System.out.println("addsum" + p.cost);
				union(na, nb);
				bsize++;
			}

		}

		// System.out.println("fin1");

		if (bsize != cnt - 2)
			return -1;

		// System.out.println("fin");
		return sum;
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}

	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) {

		} else {
			parent[a] = b;
		}
	}

	static void bfs(int r, int c, int N, int M, int num) {
		// 덩어리 탐색.

		Queue<point> q = new LinkedList<>();
		q.add(new point(r, c, num));
		list[num].add(new node(r, c));
		arr[r][c] = num;

		while (!q.isEmpty()) {
			point p = q.poll();

			for (int i = 0; i < 4; i++) {

				int nr = p.a + dr[i];
				int nc = p.b + dc[i];
				int ncost = p.cost;

				if (isvalid(nr, nc) && !visit[nr][nc] && arr[nr][nc] == 1) {
					visit[nr][nc] = true;
					q.add(new point(nr, nc, num));
					list[num].add(new node(nr, nc));
					//System.out.println("listadd" + " num" + num + " r" + nr + " c" + nc);
					arr[nr][nc] = num;
				}

			}

		}

	}

	private static boolean isvalid(int r, int c) {
		// TODO Auto-generated method stub
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}