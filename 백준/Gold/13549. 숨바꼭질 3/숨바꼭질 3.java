
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

class Main {

	static int k;
	static int n;
	static int res = Integer.MAX_VALUE;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();

		int depth = 0;
		solve();

		System.out.println(res);
		sc.close();
	}

	static class point {
		int depth;
		int pos;

		public point(int pos, int depth) {
			this.depth = depth;
			this.pos = pos;
		}
	}

	static void solve() {
//
//		if (num == 9)
//			System.out.println("num depth" + num + " " + depth);
		visit = new boolean[100001];

		Queue<point> q = new LinkedList<>();
		q.add(new point(n, 0));

		while (!q.isEmpty()) {

			point v = q.poll();
			int num = v.pos;
			int depth = v.depth;

//			System.out.println("num depth" + num + " " + depth);
			visit[num] = true;

			if (num == k) {
				res = Math.min(res, depth);
//				System.out.println("in");
//				System.out.println("res " + res);
				return;
			}

			if (num - 1 >= 0 && visit[num - 1] == false)
				q.add(new point(num - 1, depth + 1));
			if (num * 2 <= 100000 && visit[num * 2] == false)
				q.add(new point(num * 2, depth));

			if (num < k && visit[num + 1] == false)
				q.add(new point(num + 1, depth + 1));

		}

	}

}