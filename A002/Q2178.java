package A002;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q2178  {
	
	static final int[] dx = {0, 0, -1, 1}; //동 서 북 남
	static final int[] dy = {1, -1, 0, 0};

	

	public static int calc(int[][] map, int n, int m){

		int count = 0;
		Queue<Point> queue = new LinkedList<>();
		Point previous = null;
		int[][] visited = new int[map.length][map[0].length];
		Point point = new Point(0,0);

		queue.add(point);
		visited[0][0] = 1;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			count++;
			if(p.x == n && p.y == m) break;
			
			for(int k = 0; k < 4; k++) {
				int nextX = p.x + dx[k];
				int nextY = p.y + dy[k];
				if(nextX < 0 || nextX > map.length-1 || nextY < 0 || nextY > map[0].length-1) continue;
				if(map[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
					queue.add(new Point(nextX, nextY));
					previous = new Point(p.x, p.y);
					visited[nextX][nextY] = 1;
					break;
				}
				if(k == 3) {
					queue.add(previous);
					visited[p.x][p.y] = 1;
					count -=2;
				}
				//전부 0일 경우 이전으로 돌아가야된다.
				
			}
			
		}

		return count;
	}

	public static void main(String[]args) {
		int n = 4;
		int m = 6;
		int[][] map ={
			{1,0,1,1,1,1},
			{1,0,1,0,1,0},
			{1,0,1,0,1,1},
			{1,1,1,0,1,1}
		};

		int result = calc(map, n-1, m-1);

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