 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.InputMap;

public class Main {
	static int[] dr = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] dc = { 1, -1, -2, 2, 2, -2, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = new String[36];

		for (int i = 0; i < 36; i++) {
			str[i] = br.readLine();
		}
		solve(str);

	}

	static void solve(String[] str) { // 저번꺼랑 비교 8개 방향* 36 ??
		boolean[][] visit = new boolean[6][6];
		char[] first = new char[2];
		first[0] = str[0].charAt(0);
		first[1] = str[0].charAt(1);

		char[] last = new char[2];
		last[0] = str[35].charAt(0);
		last[1] = str[35].charAt(1);

		for (int i = 0; i < 36; i++) {
			boolean flag = false;

			char ch[] = str[i].toCharArray();

			if (i >= 1) {
				int r = str[i - 1].charAt(0) - ch[0];
				int c = str[i - 1].charAt(1) - ch[1];

				for (int j = 0; j < 8; j++) {
					if (r == dr[j] && c == dc[j]) {
						flag = true;
					}

				}

				if (flag == false) {
					System.out.println("Invalid");
					return;
				}
			}

			if (!visit[6 - (ch[1] - '0')][ch[0] - 'A'])
				visit[6 - (ch[1] - '0')][ch[0] - 'A'] = true;

			else {
				System.out.println("Invalid");
				return;
			}

		}
		int cnt = 0;
		
		for (int j = 0; j < 8; j++) {
			if (first[0] - last[0] == dr[j] && first[1] - last[1] == dc[j]) {
				cnt++;
			}
		}

		if (cnt == 0) {
			System.out.println("Invalid");
			return;
		}

		System.out.println("Valid");
	}

}
