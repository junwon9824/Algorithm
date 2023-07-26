 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int num = 0;

		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("push")) {
				String str2 = st.nextToken();
				q.add(Integer.parseInt(str2)); // push 해야 하는 값을 넣는다
			}

			if (str.equals("pop")) {
				if (q.size() != 0)
					System.out.println(q.poll()); // 공백이 아니면 출력
				else
					System.out.println("-1");
			}

			if (str.equals("size")) {
				System.out.println(q.size());
			}

			if (str.equals("empty")) {
				if (q.size() == 0) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			}

			if (str.equals("front")) {
				if (q.size() == 0)
					System.out.println("-1");
				else
					System.out.println(q.getFirst());

			}
			if (str.equals("back")) {
				if (q.size() == 0)
					System.out.println("-1");
				else
					System.out.println(q.getLast());

			}

		}

	}

}