
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[][] pattern;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		pattern = new char[n][2 * (n - 1) + 1];
		for (int i = 0; i < n; i++) {

			Arrays.fill(pattern[i], ' ');

		}
		for (int i = 0; i < n; i++) {

//			for (int j = 0; j < n; j++) {
//
//				pattern[i][j] = ' ';
//			}

			for (int j = n - i - 1; j < n + i; j++) {

				pattern[i][j] = '*';
			}

		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 2 * (n - 1) + 1; j++) {
//				System.out.print(pattern[i][j]);
//
//			}
//			System.out.println();
//		}

//		int num = (n % 2 == 0) ? 0 : 1;
		solve(n, 0, n - 1);

		sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * (n - 1) + 1; j++) {
				sb.append(pattern[i][j]);
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}

	static void solve(int n, int row, int col) {

//		System.out.println("n r c" + n + row + col);
		if (n == 3) {
			pattern[row + 1][col] = ' ';
			return;
		}

		int newSize = n / 2; // 3

		solve(newSize, row, col);
		solve(newSize, row + newSize, col - (newSize));

		for (int r = row + newSize; r < row + 2 * newSize; r++) {
			for (int c = col - newSize + 1 + (r - row - newSize); c < col + newSize - (r - row - newSize); c++) {
				pattern[r][c] = ' ';
//				System.out.println("remove " + r + c);
			}
		}

		solve(newSize, row + newSize, col + newSize);

//		for (int i = 0; i < 4; i++) {
//
//			if (i == 2) {
//				for (int r = row + newSize; r < row + 2 * newSize; r++) {
//					for (int c = col + newSize; c < col + 2 * r; c++) {
//						pattern[r][c] = ' ';
//					}
//				}
//			}
//
//			else {
//				solve(newSize, row + i * newSize, col + j * newSize);
//			}
//
//		}

	}
}
