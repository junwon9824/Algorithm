 
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] grid;
	static int[] grid2;
	static int goalX, goalY;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		// 입력 처리
		grid = new int[n];
		grid2 = new int[n];

		for (int j = 0; j < n; j++) {
			grid[j] = scanner.nextInt();

		}

		for (int i = 0; i < n; i++) {
			int cnt = 0;
			int idx2 = grid[i];

			int idx = 0;
			while (grid2[idx] != 0 || cnt < idx2) {
				if (grid2[idx] == 0) {
					cnt++;
				}
				idx++;

			}

			grid2[idx] = i + 1;

		}

		for (int v : grid2) {
			System.out.print(v + " ");
		}

	}

}
