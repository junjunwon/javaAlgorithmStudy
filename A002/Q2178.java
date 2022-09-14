package A002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {

	static final int[] dx = { 0, 0, -1, 1 }; // 동 서 북 남
	static final int[] dy = { 1, -1, 0, 0 };

	public static int calc(int[][] map, int n, int m) {

		int count = 0;
		Queue<Point> queue = new LinkedList<>();
		Point previous = null;
		int[][] visited = new int[map.length][map[0].length];
		int[][] counting = new int[map.length][map[0].length];
		Point point = new Point(0, 0);

		queue.add(point);
		visited[0][0] = 1;
		counting[0][0] = 1;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			if (p.x == n && p.y == m)
				break;

			for (int k = 0; k < 4; k++) {
				int nextX = p.x + dx[k];
				int nextY = p.y + dy[k];
				if (nextX < 0 || nextX > map.length - 1 || nextY < 0 || nextY > map[0].length - 1)
					continue;
				if (map[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
					visited[nextX][nextY] = 1;
					counting[nextX][nextY] = counting[p.x][p.y] + 1;
					queue.add(new Point(nextX, nextY));
					previous = new Point(p.x, p.y);
				}
				if (k == 3) {
					queue.add(previous);
					visited[p.x][p.y] = 1;
				}
				// 전부 0일 경우 이전으로 돌아가야된다.

			}

		}

		for(int i = 0; i<n; i++){
			for (int j = 0; j<m; j++){
				System.out.print(counting[i][j]);
			}
			System.out.println();
		}

		return counting[n][m];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map2 = new int[n][m];

		for(int i = 0; i < n; i++){
			String[] temp = br.readLine().split("");
			for(int j =0; j< m; j++){
					map2[i][j]=Integer.parseInt(temp[j]);
			}
	}
		// int n = 4;
		// int m = 6;

		// int[][] map ={
		// {1,0,1,1,1,1},
		// {1,0,1,0,1,0},
		// {1,0,1,0,1,1},
		// {1,1,1,0,1,1}
		// };

		int result = calc(map2, n - 1, m - 1);

		System.out.println(result);
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}