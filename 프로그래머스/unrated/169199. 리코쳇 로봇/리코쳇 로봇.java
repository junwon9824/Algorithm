 
import java.util.*;

class Solution {
	static int startx, starty;
	static int endx, endy;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static char[][] arr;
	static boolean[][] visit;
	static int answer = -1;
 

	public static int solution(String[] board) {
		arr = new char[board.length][board[0].length()];
		visit = new boolean[board.length][board[0].length()];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				arr[i][j] = board[i].charAt(j);
				if (arr[i][j] == 'R') {
					startx = i;
					starty = j;
				}

				if (arr[i][j] == 'G') {
					endx = i;
					endy = j;
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { startx, starty, 0 });
		visit[startx][starty] = true;

		answer = bfs(q);

		return answer;
	}

	static int bfs(Queue<int[]> q) {
		while (!q.isEmpty()) {
			int[] v = q.poll();
			int r = v[0];
			int c = v[1];
			int d = v[2];

			if (r == endx && c == endy) {
				return d;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];

				while (isValid(nr, nc) && arr[nr][nc] != 'D' ) {
					nr += dx[i];
					nc += dy[i];
				}
                
				if ((arr[nr - dx[i]][nc - dy[i]] == 'R') )
					continue;

				if (isValid(nr - dx[i], nc - dy[i]) && !visit[nr - dx[i]][nc - dy[i]]) {
					q.add(new int[] { nr - dx[i], nc - dy[i], d + 1 });
					visit[nr - dx[i]][nc - dy[i]] = true;
				}

			}
		}

		return -1;
	}

	static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < arr.length && c < arr[0].length;
	}
}
