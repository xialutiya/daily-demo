package xilalu.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 2.给定一个数组A[n], 定义数组的众数 ( Majority Element) 为数组中出现次数超过 n/2 次的元素,
 * 假设数组A[n]非空且一定存在众数, 请设计算法找到该众数并输出.
 *
 * @author lds
 * @date 2021/2/21 23:19
 */
public class Main19 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        selectMode(arr);
    }

    public static void selectMode(int[] arr) {
        int middle = arr.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>(middle);
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                Integer num = map.get(arr[i]);
                if (++num > middle) {
                    System.out.println(arr[i]);
                    return;
                }
                map.put(arr[i], num);
            }
        }
    }


    public static int test001(int[] arr) {

        int capacity = arr.length / 2;
        Map<Integer, Integer> map = new HashMap(capacity);
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            Integer index = map.get(num);
            if (index != null) {
                if ((index + 1) > capacity) {
                    return num;
                } else {
                    map.put(num, ++index);
                }
            } else {
                map.put(num, 1);
            }
        }
        return 0;
    }

    public static int mooreVote(int[] arr) {

        int res = 0, num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (res == 0) {
                res++;
                num = arr[i];
            } else {
                if (num == arr[i]) {
                    res++;
                } else {
                    res--;
                }
            }
        }
        if (res == 0) {
            return 0;
        }

        return num;
    }

    public static int getMode(int[] arr) {

        int middle = arr.length / 2;
        Map<Integer, Integer> map = new HashMap<>(arr.length);

        for (int element : arr) {
            Integer value = map.get(element);
            if (value == null) {
                map.put(element, 1);
            } else {
                map.put(element, ++value);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > middle) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
