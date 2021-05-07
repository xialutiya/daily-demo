package xilalu.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * .给定一个非空的整数数组，从数组第一个元素(下标为0的元素)开始遍历进行移动，
 * 下一次向后或向前移动 该元素的值 的位数（值为正数向后移动，值为负数向前移动，值为零不移动），
 * 依次类推进行移动，若某次移动数组出现越界，则说明数组可以跳出，返回true；不能跳出则返回false；
 * （加分项：也可考虑不增加使用其他集合数组辅助完成算法）
 * 例1：
 * 输入数组a[5] = [1,2,3,2,5];从第一个元素开始a[0]=1,下次向后移动1位到第二个元素a[1]=2,
 * 再次向后移动2位到第四个元素a[3],因为下次向后移动2位(a[3]=2)后,向后数组越界,即跳出数组,输出true;
 * 例2：
 * 输入数组a[2] = [1,-3];从第一个元素开始a[0]=1,下次移动1位到第二个元素a[1]=-3,再次向前移动3位后,
 * 向前数组越界,即跳出数组,输出true;
 *
 * @author lds
 * @date 2021/2/21 22:50
 */
public class Main18 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        jumpOutArr(arr);
    }

    public static void jumpOutArr(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        int index = 0;
        while (index >= 0 && index < arr.length) {
            if (map.get(index) == null) {
                map.put(index, index);
                index += arr[index];
            } else {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }


    public static boolean test001(int[] arr) {

        Map<Integer, Integer> map = new HashMap(arr.length);
        int mark = 0;
        while (0 <= mark && mark < arr.length) {
            if (map.get(mark) == null) {
                map.put(mark, 0);
            } else {
                return false;
            }
            mark = mark + arr[mark];
        }

        return true;
    }


    /**
     * 判断是否可以成功跳出.
     *
     * @param arr
     * @return
     */
    public static boolean moveCoordinate(int[] arr) {

        int index = 0;
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        while (index >= 0 && index < arr.length) {
            if (map.get(index) != null || (index == arr.length - 1 && arr[index] == 0)) {
                return true;
            } else {
                map.put(index, index);
            }
            int num = arr[index];
            if (num == 0) {
                index++;
            } else {
                index = num + index;
            }
        }

        return false;
    }
}
