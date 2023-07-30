
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

		pattern = new char[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(pattern[i], '*');
		}

		solve(n, 0, 0);

		sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(pattern[i][j]);
//				System.out.print(pattern[i][j]);
			}
			sb.append('\n');
//			System.out.println();
		}
		System.out.println(sb.toString());
	}

	static void solve(int n, int row, int col) {

		if (n == 3) {

			pattern[row + 1][col + 1] = ' ';
			return;
		}

		int newSize = n / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (i == 1 && j == 1) {
					for (int r = row + newSize; r < row + 2 * newSize; r++) {
						for (int c = col + newSize; c < col + 2 * newSize; c++) {
							pattern[r][c] = ' ';
						}
					}
				}

				else {
					solve(newSize, row + i * newSize, col + j * newSize);
				}

			}
		}

	}
}
