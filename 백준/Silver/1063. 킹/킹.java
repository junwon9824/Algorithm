 

import java.io.*;
import java.util.*;

public class Main {
	static String input;
	static int[][] arr;
	static int[] dr = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };
//	static String[] alldir = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" };
	static point king;
	static point rock;

	public static void main(String[] args) throws IOException {
		init();
	}

	static boolean isvalid(char r, char c) {
		return r >= '1' && r < '9' && c >= 'A' && c <= 'H';
	}

	static class point {
		char r;
		char c;

		public point(char r, char c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String tmp;

		tmp = st.nextToken();
		king = new point(tmp.charAt(1), tmp.charAt(0));
//		System.out.println("king " + king.r + " " + king.c);
		tmp = st.nextToken();
		rock = new point(tmp.charAt(1), tmp.charAt(0));
//		System.out.println("rock" + rock.r + " " + rock.c);

		int N = Integer.parseInt(st.nextToken());

		arr = new int[9][9];

		for (int i = 0; i < N; i++) {

			String ch = br.readLine();
			solve(ch);
		}

		System.out.println((((king.c)) + "" + ((king.r))));
		System.out.println(((rock.c) + "" + ((rock.r))));
 		//System.out.println((char) ((king.r - 1) + 'A') + "" + king.c);
 	//	System.out.println((char) ((rock.r - 1) + 'A') + "" + rock.c);

	}

	static void solve(String ch) {
		point kingnext = new point('0', '0');
		point rocknext = new point('0', '0');

		kingnext.r = king.r;
		kingnext.c = king.c;
		rocknext.r = rock.r;
		rocknext.c = rock.c;

		if (ch.equals("R")) {
			kingnext.r = (char) (king.r + dr[0]);
			kingnext.c = (char) (king.c + dc[0]);
			if (kingnext.r == rock.r && kingnext.c == rock.c) {
				rocknext.r = (char) (rock.r + dr[0]);
				rocknext.c = (char) (rock.c + dc[0]);
			}
		}

		if (ch.equals("L")) {
			kingnext.r = (char) (king.r + dr[1]);
			kingnext.c = (char) (king.c + dc[1]);
			if (kingnext.r == rock.r && kingnext.c == rock.c) {
				rocknext.r = (char) (rock.r + dr[1]);
				rocknext.c = (char) (rock.c + dc[1]);
			}
		}
		if (ch.equals("B")) {
			kingnext.r = (char) (king.r + dr[2]);
			kingnext.c = (char) (king.c + dc[2]);
			if (kingnext.r == rock.r && kingnext.c == rock.c) {
				rocknext.r = (char) (rock.r + dr[2]);
				rocknext.c = (char) (rock.c + dc[2]);
			}
		}
		if (ch.equals("T")) {
			//System.out.println("TT");
			kingnext.r = (char) (king.r + dr[3]);
			kingnext.c = (char) (king.c + dc[3]);
			//System.out.println("kingnext" + kingnext.r);
			if (kingnext.r == rock.r && kingnext.c == rock.c) {
				//System.out.println("same");
				rocknext.r = (char) (rock.r + dr[3]);
				rocknext.c = (char) (rock.c + dc[3]);
			}
		}
		if (ch.equals("RT")) {
			kingnext.r = (char) (king.r + dr[4]);
			kingnext.c = (char) (king.c + dc[4]);
			if (kingnext.r == rock.r && kingnext.c == rock.c) {
				rocknext.r = (char) (rock.r + dr[4]);
				rocknext.c = (char) (rock.c + dc[4]);
			}
		}
		if (ch.equals("LT")) {
			kingnext.r = (char) (king.r + dr[5]);
			kingnext.c = (char) (king.c + dc[5]);
			if (kingnext.r == rock.r && kingnext.c == rock.c) {
				rocknext.r = (char) (rock.r + dr[5]);
				rocknext.c = (char) (rock.c + dc[5]);
			}
		}
		if (ch.equals("RB")) {
			kingnext.r = (char) (king.r + dr[6]);
			kingnext.c = (char) (king.c + dc[6]);
			if (kingnext.r == rock.r && kingnext.c == rock.c) {
				rocknext.r = (char) (rock.r + dr[6]);
				rocknext.c = (char) (rock.c + dc[6]);
			}
		}
		if (ch.equals("LB")) {
			kingnext.r = (char) (king.r + dr[7]);
			kingnext.c = (char) (king.c + dc[7]);
			if (kingnext.r == rock.r && kingnext.c == rock.c) {
				rocknext.r = (char) (rock.r + dr[7]);
				rocknext.c = (char) (rock.c + dc[7]);
			}
		}
		//System.out.println("kingnext" + kingnext.r + " " + kingnext.c);
		//System.out.println("rocknext" + rocknext.r + " " + rocknext.c);

		if (isvalid(kingnext.r, kingnext.c) && isvalid(rocknext.r, rocknext.c)) {
			//System.out.println("in");
			king.r = kingnext.r;
			king.c = kingnext.c;
			rock.r = rocknext.r;
			rock.c = rocknext.c;
		}
		//System.out.println("kk" + king.r + " " + king.c);
		//System.out.println("rr" + rock.r + " " + rock.c);

	}

}