
import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main  {
	static boolean[] visit;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
//			System.out.println("n" + N);
			visit = new boolean[N];
			selected = new int[6];

			if (N == 0)
				break;

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

//			System.out.println("arr" + Arrays.toString(arr));
			solve(0, N, 0, arr);
			System.out.println();
		}

	}

	static void solve(int idx, int n, int depth, int[] arr) {

		if (depth == 6) {
			for (int i : selected)
				System.out.print(i + " ");
			System.out.println();
//			System.out.println(Arrays.toString(selected));
//			System.out.println("ss");
			return;
		}

		for (int i = idx; i < n; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			selected[depth] = arr[i];
//			System.out.println("i de" + i + " " + depth);
			solve(i + 1, n, depth + 1, arr);
			visit[i] = false;
		}

	}

}
