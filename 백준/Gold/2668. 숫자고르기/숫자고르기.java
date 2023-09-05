 

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {
	static int arr[];
	static PriorityQueue<Integer> pq;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			int v = Integer.parseInt(br.readLine());
			arr[i] = v;

		}

		visit = new boolean[n + 1];
//		 N(1≤N≤100)을
		for (int i = 1; i <= n; i++) {
			if (!visit[i])
				dfs(i, i);
		}

		int size = pq.size();
		System.out.println(size);
		for (int i = 0; i < size; i++)
			System.out.println(pq.poll());
	}

	static void dfs(int num, int res) {
		if (arr[num] == res) {
			pq.add(res);
			return;
		}

		if (!visit[num]) {
			visit[num] = true;
			dfs(arr[num], res);
			visit[num] = false;
		}

	}

}