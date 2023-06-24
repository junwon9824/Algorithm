 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, d;
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		int s, e, dis;

		ArrayList<point> p = new ArrayList<>();

		int ans = 0;

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			dis = Integer.parseInt(st.nextToken());

			if (dis > e - s)
				continue;

			if (d < e)
				continue;

			p.add(new point(s, e, dis));
		}

		Collections.sort(p);

		int idx = 0;
		int pidx = 0;
		int[] distance = new int[10001];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;

		while (idx < d) {

			if (pidx < p.size()) {
				if (idx == p.get(pidx).s) {
					distance[p.get(pidx).e] = Math.min(p.get(pidx).dis + distance[idx], distance[p.get(pidx).e]);
					pidx++;

				} else {
					distance[idx + 1] = Math.min(distance[idx + 1], distance[idx] + 1);
					idx++;
				}

			} else {
				distance[idx + 1] = Math.min(distance[idx + 1], distance[idx] + 1);
				idx++;
			}

		}

		System.out.println(distance[d]);

	}

	static class point implements Comparable<point> {

		int s, e, dis;

		public point(int s, int e, int dis) {
			this.s = s;
			this.e = e;
			this.dis = dis;

		}

		@Override
		public int compareTo(point o) {

			if (this.s == o.s) {
				return this.e - o.e;
			} else
				return this.s - o.s;

		}

	}

}
