import java.io.*;

import java.util.*;

public class Main {

	static int res = 0;

	static int[] x = { -1, 0, 1, 0 };
	static int[] y = { 0, 1, 0, -1 };
	static boolean[][] visit;
	static int[][] arr;
	static int[][] dp;
	static int r, c;
	static String str;
	static List<Long> list = new ArrayList<>();

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
 //dp + 메모이제이션 쓰는 문제.. 메모이제이션이 시간복잡도 줄여준다.
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		
		arr = new int[r][c];
		visit = new boolean[r][c];

		dp = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		
		for (int i = 0; i < r; i++) {
			Arrays.fill(dp[i], -1);//방문햇는데도 0 인 칸이 존재하기 때문에
            //마이너스 1을 할당해준다
		}

		

		System.out.println(solve(0, 0));//0,0 에서 시작

	}

	public static int solve(int x1, int y1) {

		if (x1 == r - 1 && y1 == c - 1) { //마지막 칸에 온 경우 1 리턴.
			return 1;

		}

		if (dp[x1][y1] != -1)
			return dp[x1][y1];//메모이제이션 쓰는이유
        //이미 방문한 경우(-1 이 아닌경우 ) 바로 리턴한다

		dp[x1][y1] = 0; //여기 왔다는건 원래 -1 이었다는 소리.. -1 을 0으로 바꾼다음 
		for (int i = 0; i < 4; i++) { //4방향 탐색.

			int nx = x1 + x[i];
			int ny = y1 + y[i];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c) { //범위 밖은 continue;
				continue;
			}

			if (arr[x1][y1] > arr[nx][ny]) { //현재보다 낮은 경우. 문제에서 계단식으로 동작한다했음.

				dp[x1][y1] += solve(nx, ny); // 

			}

		}

		return dp[x1][y1]; //해당칸에 처음 방문한 경우  return 해야한다. 

	}

}
