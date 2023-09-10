 
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {
	static int arr[];
	static int[] parent;

	static class point {
		int next, weigth;

		public point(int next, int weigth) {
			super();
			this.next = next;
			this.weigth = weigth;
		}
	}

	static ArrayList<Integer>[] list;
	static int[] weight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int cnt = 0;

		st = new StringTokenizer(br.readLine());
		list = new ArrayList[n + 1];
		weight = new int[n + 1];

		for (int i = 1; i <= n; i++) {

			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			int u = Integer.parseInt(st.nextToken());
			if (u == -1)
				continue;
			list[u].add(i);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			weight[I] += W;
		}
		dfs(1);

		for (int i = 1; i <= n; i++) {
			System.out.print(weight[i] + " ");
		}

	}

	static void dfs(int a) {
		for (int i : list[a]) {
		 
			// System.out.println("i " + i + " " + w);
			weight[i] += weight[a];
			dfs(i);
		}

	}

}