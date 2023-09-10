
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {

	static int n;
	static char map[][];
	static char[] move;
	static int dx[] = { 0, -1, 0, 1, 0 }; // 위 오 아 왼
	static int dy[] = { 0, 0, 1, 0, -1 };
	static int dir = 3;
	static int left_x = 50;
	static int left_y = 50;
	static int right_x = 50;
	static int right_y = 50;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[101][101];
		n = Integer.parseInt(br.readLine());
		move = new char[n];

		for (int i = 0; i < 99; i++) {
			for (int j = 0; j < 99; j++) {
				map[i][j] = '#';
			}
		}

		String input = br.readLine();
		for (int i = 0; i < n; i++) {
			move[i] = input.charAt(i);
		}

		map[50][50] = '.';

		int tmp_x = 50;
		int tmp_y = 50;

		for (int i = 0; i < n; i++) {
			char order = move[i];

			if (order != 'F') {
				changedir(order);
			} else {
				tmp_x += dx[dir];
				tmp_y += dy[dir];
				map[tmp_x][tmp_y] = '.';
			}
		}
//		System.out.println("map"+map[50][50]);
//		System.out.println("map"+map[49][50]);

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {

				if (map[i][j] == '.') { //모든행과열에는 . 이 하나씩 잇기때문에 j 열에 하나라도 있으면 left 에 할당 .

					if (left_x > i) {//마찬가지로 현재보다 작은 값중에 i 행애 하나라도 . 이 있으면 할당.
						//System.out.println("left "+i + " "  );

						left_x = i;
					}
					if (left_y > j) { 
						//System.out.println("left "+j+ " "  );
						left_y = j;
					}
					if (right_x < i) {
						//System.out.println(i + " " + j);

						right_x = i;
					}
					if (right_y < j) {
						right_y = j;
					}
				}

			}
		}

//		
//		System.out.println(left_x + " " + left_y);
//		System.out.println(right_x + " " + right_y);

		for (int i = left_x; i <= right_x; i++) {
			for (int j = left_y; j <= right_y; j++) {
				System.out.print(map[i][j] + "");
			}
			System.out.println();
		}

	}

	public static void changedir(char order) {
		if (order == 'R') {
			dir += 1;
			if (dir == 5) {
				dir = 1;
			}
		} else {
			dir -= 1;
			if (dir == 0) {
				dir = 4;
			}
		}
	}
}