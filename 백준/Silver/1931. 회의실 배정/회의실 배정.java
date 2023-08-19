 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

class point implements Comparable<point> {

	int s, e;

	public point(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(point o) {
		// TODO Auto-generated method stub
		if (this.e == o.e)
			return this.s - o.s;
		
		return this.e - o.e;
	}

}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		ArrayList<point> times = new ArrayList<>();
		int cnt = 0;

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			times.add(new point(a, b));

		}

		Collections.sort(times);

		int tmp = 0;

		for (int i = 0; i < n; i++) {
			
			if (tmp <= times.get(i).s) {
				tmp = times.get(i).e;
				cnt++;
			}

		}

		System.out.print(cnt);

	}

}