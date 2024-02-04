package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class GHN {
	static int[][] graph;
	static boolean[] visited;
	static int totalDistance;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = scanner.nextInt();
			graph = new int[N][N];
			visited = new boolean[N];
			totalDistance = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = scanner.nextInt();
				}
			}

			dfs(0, N, 1);

			System.out.println("#" + testCase + " " + totalDistance);
		}

		scanner.close();
	}

	private static void dfs(int current, int N, int count) {
		visited[current] = true;

		if (count == N) {
			totalDistance += graph[current][0];
			return;
		}

		int next = -1;
		int minDistance = Integer.MAX_VALUE;

		for (int j = 0; j < N; j++) {
			System.out.println("visited[j] ban dau="+visited[j]+" tai j= "+j);
			if (!visited[j] && graph[current][j] < minDistance) {
				System.out.println("visited[i]="+visited[j]+" tai i= "+j);
				minDistance = graph[current][j];
				System.out.println("min hien tai ="+minDistance+"tai cot"+j+"hang: "+current);
				next = j;
			}
		}

		totalDistance += minDistance;
		System.out.println("totalDistance ="+totalDistance);
		System.out.println("count="+count);
		dfs(next, N, count + 1);
	}
}
