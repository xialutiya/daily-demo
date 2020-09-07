package xilalu.graph;

import java.util.Scanner;

/**
 * 求最短路径.1->3:10,1->5:30,1->6:100,2->3:10,3->4:20,4->6:10,5->4:20,5->6:60,
 * xx->yy:value,有向图,从顶点xx到yy的边的权重为value.
 * 0 2 10
 * 0 4 30
 * 0 5 100
 * 1 2 10
 * 2 3 20
 * 3 5 10
 * 4 3 20
 * 4 5 60
 */
public class DJSTL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        int[][] data = new int[n][n]; // 存放各边的权重.
        int[] temp = new int[n]; // 存放中间变量.
        String[] str = new String[n]; // 存放路径.
        // 初始化边的权值.
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.MAX_VALUE; // 初始化中间变量值.
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    data[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int xx = sc.nextInt(); // 起点.
            int yy = sc.nextInt(); // 终点.
            int value = sc.nextInt(); // 从xx到yy的边的权重.
            data[xx][yy] = value;
            if (start == xx) { // 初始化第一轮的中间变量.
                temp[yy] = value;
                str[yy] = start + "->" + yy;
            }
        }
//        search(start, temp, data, n);
        searchRoad(start, temp, data, n, str);
    }

    /**
     * @param start 起始顶点.
     * @param temp  临时数组.
     * @param data  邻接矩阵.
     * @param n     顶点数.
     */
    public static void search(int start, int[] temp, int[][] data, int n) {
        boolean[] mark = new boolean[n];
        temp[start] = 0; // 从start到start的边的权重.
        mark[start] = true; // 标记已操作的顶点.
        int loc = start; // 正在操作的顶点的指针.
        while (loc < n) {
            loc = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!mark[i] && temp[i] < min) {
                    min = temp[i];
                    loc = i;
                }
            }
            if (loc == -1) {
                break;
            }
            mark[loc] = true;
            for (int i = 0; i < n; i++) {
                if (data[loc][i] != -1) {
                    temp[i] = Math.min(temp[loc] + data[loc][i], temp[i]);
                }
            }
            loc++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("从顶点" + start + "到顶点" + i + "的最短路径是:" + temp[i]);
        }
    }

    /**
     * @param start 起始点.
     * @param temp  存放中间数据.
     * @param data  存放边的权重.
     * @param n     顶点数.
     * @param str   存放路径.
     */
    public static void searchRoad(int start, int[] temp, int[][] data, int n, String[] str) {
        boolean[] mark = new boolean[n];
        temp[start] = 0;
        mark[start] = true;
        str[start] = start + "->" + start;
        int loc = start;
        while (loc < n) {
            loc = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!mark[i] && temp[i] < min) {
                    min = temp[i];
                    loc = i;
                }
            }
            if (loc == -1) {
                break;
            }
            mark[loc] = true;
            for (int i = 0; i < n; i++) {
                if (data[loc][i] != -1 && temp[loc] + data[loc][i] < temp[i]) {
                    temp[i] = temp[loc] + data[loc][i];
                    str[i] = str[loc] + "->" + i;
                }
            }
            loc++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("从顶点" + start + "到顶点" + i + "的最短路径是:" + temp[i]);
            System.out.println("路径:" + str[i]);
        }
    }

}
