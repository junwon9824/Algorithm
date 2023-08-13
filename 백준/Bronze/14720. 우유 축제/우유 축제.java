
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main  {

	static int n;
	static int m;
	static int w;
	static int v;
	static int[] arr;
	static int res = 0;

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, 0, 0);
		System.out.println(res);
	}

	static void solve(int milk, int depth, int cnt) {

		if (depth == n) {
			res = Math.max(res, cnt);
			return;
		}

		if (milk == arr[depth]) {
			solve((milk + 1) % 3, depth + 1, cnt + 1);
		} else {
			solve((milk), depth + 1, cnt);
		}

	}

}