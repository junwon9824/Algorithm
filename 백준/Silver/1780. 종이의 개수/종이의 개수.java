
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
//	static int arr[][];

	static int cntzero = 0;
	static int cntone = 0;
	static int cntminusone = 0;

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(n, 0, 0, arr);
		System.out.println(cntminusone);
		System.out.println(cntzero);
		System.out.println(cntone);

	}

	static void solve(int len, int r, int c, int[][] arr) {

		int tcntzero = 0;
		int tcntone = 0;
		int tcntminusone = 0;

//		System.out.println("r c len" + r + " " + c + " " + len);
		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {

				if (arr[i][j] == 0) {
					tcntzero++;
				}

				if (arr[i][j] == 1) {
					tcntone++;
				}
				if (arr[i][j] == -1) {
					tcntminusone++;
				}

			}
		}

		if (len * len == tcntzero) {

			cntzero++;
//			System.out.println("r c len cntzero" + r + " " + c + " " + len + " " + cntzero);

			return;
		}

		if (len * len == tcntminusone) {
			cntminusone++;
//			System.out.println("r c len cntminus" + r + " " + c + " " + len + " " + cntminusone);
			return;
		}

		if (len * len == tcntone) {
			cntone++;
//			System.out.println("r c len cntone" + r + " " + c + " " + len + " " + cntone);
			return;
		}

		int size = len / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				solve(len / 3, r + i * size, c + j * size, arr);
			}
		}

	}

}
