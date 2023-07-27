

import java.io.*;

import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();

	
	
	public static void main(String args[]) throws IOException {

		int n, m, t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());



		roop: for (int i = 0; i < t; i++) {
			Deque<Character> q = new LinkedList<>();

			String str = br.readLine();
			
			solve(str, q);
		

		}
		
		System.out.print(sb);

	}
	

	public static void solve(String str,Deque q)
	{
		for (int j = 0; j < str.length(); j++) {

			if (str.charAt(j) == '(')
				q.offerFirst(str.charAt(j));

			else {

				if (q.isEmpty()) {

					sb.append("NO").append('\n');
					return;
				}

				else {
					q.pollLast();
				}

			}

		}

		if (q.isEmpty()) {

			sb.append("YES").append('\n');
		}
		else
		{
			sb.append("NO").append('\n');

		}

		
	}
	
	
}
