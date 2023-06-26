 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] distance;
	static int n;
	static int m;
	static int targetX;
	static int targetY;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		distance = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], -1);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					targetX = i;
					targetY = j;
				}
				if (map[i][j] == 0) {
					distance[i][j] = 0;
				}

			}
		}

		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { targetX, targetY });
		distance[targetX][targetY] = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (isValid(nx, ny) && map[nx][ny] == 1 && distance[nx][ny] == -1) {
					distance[nx][ny] = distance[x][y] + 1;
					queue.offer(new int[] { nx, ny });
				} else if (isValid(nx, ny) && map[nx][ny] == 0 && distance[nx][ny] == -1) {
					distance[nx][ny] = 0;

				}
			}

		}
	}

	private static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}
