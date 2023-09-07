 

import java.io.*;
import java.util.*;

public class Main  { // 어렵다..

	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	static List<Node>[] list;
	static List<Integer> res;
	static int ans = 0;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			list[a].add(new Node(l, r));
		}

		for (int i = 1; i < n; i++) {
			for (Node node : list[i]) {

			//	System.out.println("lis" + node.left + " " + node.right);
				;
			}
		}

		res = new ArrayList<>();

		dfs(1, true); // 처음에 이 dfs 는 그냥 첨에 탐색하면서 res 에 저장하여 표시하기 위한 작업..
		dfs(1, false); // 이제 부터 진짜 탐색 하며 cnt 증가 시킴.

	}

	static void dfs(int here, boolean nowvisit) { // 중위순회이므로 ㅣ- m -r 순으로 체크..
		for (Node node : list[here]) {
			if (node.left != -1) {
				dfs(node.left, nowvisit);
				if (!nowvisit)// 처음 true 로 탐색할경우 이 케이스는 건너뛴다.
				{
					cnt++;
				//	System.out.println("cntleft++" + here);
				}
			}

			if (nowvisit) { 
				//
//				res.add(here);
				ans = here;
			//	System.out.println("Resadd" + here);
			}

			else { //
//				if (res.get(res.size() - 1) == here) { // 현재 노드가 7인경우
				if (ans == here) { // 현재 노드가 7인경우

					System.out.println(cnt);
					return;
				}
				cnt++;
			//	System.out.println("cnt++" + here);

			}

			if (node.right != -1) { // -1이 아니면 dfs 로 계속 탐색.
				dfs(node.right, nowvisit);
				if (!nowvisit) // main 에서 true 로 시작한것이 아니면 cnt++
				{
					cnt++;
				//	System.out.println("rightcnt" + here);
				}
			}

		}
	}

}