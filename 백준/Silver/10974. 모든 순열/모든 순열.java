
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	static boolean[] visit;
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		res = new int[n];
		visit = new boolean[n];
		solve(n, 0);
	}

	static void solve(int n, int depth) {

		if (depth == n) {
			for (int i : res)
				System.out.print(i + " ");
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			res[depth] = i + 1;
			solve(n, depth + 1);
			visit[i] = false;
		}

	}
}
