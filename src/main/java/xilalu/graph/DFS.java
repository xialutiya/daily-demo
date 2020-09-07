package xilalu.graph;

import java.util.Scanner;

/**
 * 解救朋友2：有一天，小美去玩迷宫。但是方向感不好的小美很快就迷路了，你得知后便去
 * 解救无助的小美，你已经弄清楚了迷宫的地图，现在要你以最快的速度去解救小美，你能计算出
 * 最快需要几步吗？最快的路径。(0:代表可以走,1代表障碍物.)
 * 我    0   0   1   0
 * 0    0   1   0   0
 * 1    0   0   0   0
 * 0    0  小美 0   0
 * 1    0   0   0   0
 */
public class DFS {
    private static int m; // 地图的行.
    private static int n; // 地图的列.
    private static int dx; // 小美的位置.
    private static int dy; // 小美的位置.
    private static int[][] data; // 迷宫地图.
    private static boolean[][] mark; // 是否已经走过.
    private static int min = Integer.MAX_VALUE; // 最快的步数.
    private static int[][] temp = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 深度遍历. 路径.
     *
     * @param x     当前我的位置.
     * @param y     当前我的位置.
     * @param count 最小步数.
     */
    public static void dfs(int x, int y, int count) {
        if (x == dx && y == dy) { // 出口.
            if (min > count) {
                min = count;
            }
            return;
        }
        for (int i = 0; i < temp.length; i++) {
            int nextX = x + temp[i][0];
            int nextY = y + temp[i][1];
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n &&
                    data[nextX][nextY] == 0 && !mark[nextX][nextY]) { // 剪枝.
                mark[nextX][nextY] = true; // 标记为已走.
                dfs(nextX, nextY, count + 1); // 递归.
                mark[nextX][nextY] = false; // 回溯.
            }
        }
    }

    public static void dfsRoadKing(int x, int y, String sb) {
        if (x == dx && y == dy) {
            if (sb.split(",").length == 5)
                System.out.println(sb.substring(0, sb.length() - 1));
        }
        for (int i = 0; i < temp.length; i++) {
            int nextX = x + temp[i][0];
            int nextY = y + temp[i][1];
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n &&
                    data[nextX][nextY] == 0 && !mark[nextX][nextY]) {
                mark[nextX][nextY] = true;
                dfsRoadKing(nextX, nextY, sb + nextX + ":" + nextY + ",");
                mark[nextX][nextY] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        dx = sc.nextInt();
        dy = sc.nextInt();
        data = new int[m][n];
        mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = sc.nextInt();
            }
        }
//        dfs(0, 0, 0);
//        System.out.println(min);
        dfsRoadKing(0, 0, "");
    }
}

