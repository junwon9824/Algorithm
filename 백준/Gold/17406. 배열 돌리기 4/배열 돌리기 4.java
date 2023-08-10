import java.util.*;

public class Main {

	static int[][] arr;
	static int[][] rotation;
	static int min = Integer.MAX_VALUE;
	static int n, m;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		rotation = new int[k][3];
		for (int i = 0; i < k; i++) {
			rotation[i][0] = sc.nextInt();
			rotation[i][1] = sc.nextInt();
			rotation[i][2] = sc.nextInt();
		}

		visited = new boolean[k];
		result = new int[k];
		permutation(0, k);

		System.out.println(min);
	}

	public static void permutation(int idx, int k) {
		if (idx == k) {
			int[][] copy = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					copy[i][j] = arr[i][j];
				}
			}
			solve(copy);
			return;
		}

		for (int i = 0; i < k; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				result[idx] = i;
				permutation(idx + 1, k);
				visited[i] = false;
			}
		}
	}

	public static void solve(int[][] copy) {
		for (int i = 0; i < result.length; i++) {
			int lx = rotation[result[i]][0] - rotation[result[i]][2] - 1;
			int ly = rotation[result[i]][1] - rotation[result[i]][2] - 1;
			int rx = rotation[result[i]][0] + rotation[result[i]][2] - 1;
			int ry = rotation[result[i]][1] + rotation[result[i]][2] - 1;
			rotate(lx, ly, rx, ry, copy);
		}
		minrow(copy);// 회전한 배열의 최소 행값을 구함
	}

	public static void minrow(int[][] copy) {
		for (int i = 0; i < copy.length; i++) {
			int sum = 0;
			for (int j = 0; j < copy[i].length; j++) {
				sum += copy[i][j];
			}
			min = Math.min(min, sum);
		}
	}

	public static void rotate(int lx, int ly, int rx, int ry, int[][] copy) {
		if (lx == rx && ly == ry) {
			return;
		}

		int[] temp = new int[3];
		temp[0] = copy[lx][ry];
		temp[1] = copy[rx][ry];
		temp[2] = copy[rx][ly];

		// 오른쪽으로 회전
		for (int i = ry; i > ly; i--) {
			copy[lx][i] = copy[lx][i - 1];
		}
		// 아래로 회전
		for (int i = rx; i > lx; i--) {
			if (i == lx + 1)
				copy[i][ry] = temp[0];
			else
				copy[i][ry] = copy[i - 1][ry];
		}
		// 왼쪽으로 회전
		for (int i = ly; i < ry; i++) {
			if (i == ry - 1)
				copy[rx][i] = temp[1];
			else
				copy[rx][i] = copy[rx][i + 1];
		}
		// 위로 회전
		for (int i = lx; i < rx; i++) {
			if (i == rx - 1)
				copy[i][ly] = temp[2];
			else
				copy[i][ly] = copy[i + 1][ly];
		}
		rotate(lx + 1, ly + 1, rx - 1, ry - 1, copy);
	}
}
