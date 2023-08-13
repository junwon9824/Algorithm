
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] permutation = new int[n];
		//System.out.println("in");
		solve(n, 0, 0, permutation);

	}

	static void solve(int n, int depth, int mask, int[] permutation) {

		if (depth == n) {
//			System.out.println("fin");
			StringBuilder sb = new StringBuilder();
//			System.out.println("ar" + Arrays.toString(permutation));
			for (int i : permutation)
				sb.append(i).append(" ");
//				System.out.print(i + " ");
//			System.out.println();
			//sb.append('\n');
			System.out.println(sb.toString());
			return;
		}

		for (int i = 1; i <= n; i++) {

			if ((mask & (1 << i)) != 0) {
				continue;
			}
			permutation[depth] = i;
//			System.out.println("perm" + permutation[depth]);
			solve(n, depth + 1, mask | (1 << i), permutation);
		}
	}
}
