 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {

	static class point implements Comparable<point> {
		int idx, cost;

		public point(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(point o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int N, M;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		ArrayList<point> arr[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		PriorityQueue<point> pq = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			int a, b, cost;
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());

			arr[a].add(new point(b, cost));
			arr[b].add(new point(a, cost));
		}

		pq.add(new point(1, 0));
		int res = 0;
		int cnt = 0;

		boolean[] visit = new boolean[N + 1];
		while (!pq.isEmpty()) {
			point p = pq.poll();
			//System.out.printf("befo  p.idx %d p.cost %d res%d\n", p.idx, p.cost, res);

			if (visit[p.idx]) {
			//	System.out.printf("if in p.idx %d p.cost %d res%d\n", p.idx, p.cost, res);
				continue;
			}
			int dis = p.cost;
			int now = p.idx;
			visit[now] = true;
			res += dis;
			//System.out.printf("after  p.idx %d p.cost %d res%d\n", p.idx, p.cost, res);
			cnt++;
			if (cnt == N)
				break;

			for (point pp : arr[now]) {
				if (!visit[pp.idx]) {

					//System.out.printf("qadd NOW%d pp.idx %d pp.cost %d res%d\n", now, pp.idx, pp.cost, res);
					pq.add(pp);

				}
			}

		}

		System.out.println(res);
	}
}
