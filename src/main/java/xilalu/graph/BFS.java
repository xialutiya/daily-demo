package xilalu.graph;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 解救朋友：有一天，小美和你去玩迷宫。但是方向感不好的小美很快就迷路了，你得知后便去
 * 解救无助的小美，你已经弄清楚了迷宫的地图，现在你要知道从你当前位置出发你是否能够达到
 * 小美的位置？ (0:代表可以走,1代表障碍物.)
 * 我    0   0   1   0
 * 0    0   1   0   0
 * 1    0   0   0   0
 * 0    0  小美 0   0
 * 1    0   0   0   0
 */
public class BFS {

    private static int m; // 地图的行.
    private static int n; // 地图的列.
    private static int dx; // 小美的位置.
    private static int dy; // 小美的位置.
    private static int[][] data; // 邻接矩阵.
    private static boolean[][] mark; // 是否已经走过.

    /**
     * @param x 我的位置.
     * @param y 我的位置.
     * @return
     */
    public static boolean bfs(int x, int y) {
        Queue<Point> queue = new ArrayBlockingQueue<>(m * n);
        if (x == dx && y == dy) {
            return true;
        }
        queue.offer(new Point(x, y));
        mark[x][y] = true;
        int[][] temp = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + temp[i][0];
                int nextY = poll.y + temp[i][1];
                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n
                        && !mark[nextX][nextY] && data[nextX][nextY] == 0) {
                    if (nextX == dx && nextY == dy) {
                        return true;
                    }
                    queue.offer(new Point(nextX, nextY));
                    mark[nextX][nextY] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        data = new int[m][n];
        mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int dx = sc.nextInt();
        int dy = sc.nextInt();
        boolean bfs = bfs(x, y);
        System.out.println(bfs);
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
