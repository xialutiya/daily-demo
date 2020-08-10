package xilalu.code;

import java.util.Scanner;

/**
 * 小明在越南旅游，参加了当地的娱乐活动。小明运气很好，拿到了大奖，
 * 到了最后的拿奖金环节。小明发现桌子上放着一列红包，每个红包上写着奖金数额。
 * 现在主持人给要求小明在这一列红包之间“切”2刀，将这一列红包“切”成3组，
 * 并且第一组的奖金之和等于最后一组奖金和（允许任意一组的红包集合是空）。
 * 最终第一组红包的奖金之和就是小明能拿到的总奖金。
 * 小明想知道最多能拿到的奖金是多少，你能帮他算算吗。
 * <p>
 * 举例解释：桌子上放了红包  1, 2, 3, 4, 7, 10。小明在“4,7”之间、“7,10” 之间各切一刀，
 * 将红包分成3组 [1, 2, 3, 4]   [7]   [10]，其中第一组奖金之和=第三组奖金之和=10，
 * 所以小明可以拿到10越南盾
 */
public class MainSix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(testNum(arr));
    }

    public static long testNumTwo(int[] arr) {

        int left = 0, right = arr.length - 1;
        long leftSum = arr[left], rightSum = arr[right], maxSum = 0;
        while (left < right) {
            if (leftSum == rightSum) {
                maxSum += leftSum;
                leftSum += arr[++left];
                rightSum += arr[--right];
            } else if (leftSum < rightSum) {
                leftSum += arr[++left];
            } else {
                rightSum += arr[--right];
            }
        }
        return maxSum;
    }

    public static long testNum(int[] arr) {

        int left = 0, right = arr.length - 1;
        long leftSum = arr[left], rightSum = arr[right], maxSum = 0;
        while (left < right) {
            if (leftSum == rightSum) {
                maxSum = leftSum;
                leftSum += arr[++left];
                rightSum += arr[--right];
            } else if (leftSum > rightSum) {
                rightSum += arr[--right];
            } else {
                leftSum += arr[++left];
            }
        }
        return maxSum;
    }

}
