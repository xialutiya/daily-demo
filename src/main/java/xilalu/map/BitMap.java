package xilalu.map;

/**
 * 位数组.
 * 用于判断指定数值是否存在与某个数字集合中.当集合很大时
 * 例如:判断数字a是否存在与n中,n包含3亿个数字,每个数字的大小为0~2亿.机器内存300Mib
 * 如果没有内存限制,很容易就能想到利用基数排序.
 */
public class BitMap {

    private final int CAPACITY = 5;
    private int[] arr;

    public BitMap(int max) {
        arr = new int[(max >> CAPACITY) + 1];
    }

    public void add(int num) {
        int index = num >> CAPACITY;
        int loc = num & 31;
        arr[index] |= 1 << loc;
    }

    public boolean find(int num) {
        int index = num >> CAPACITY;
        int loc = num & 31;
        int flag = arr[index] & 1 << loc;
        if (flag == 0) return false;
        return true;
    }

    public void remove(int num) {
        int index = num >> CAPACITY;
        int loc = num & 31;
        arr[index] ^= 1 << loc;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(1000000);
        bitMap.add(12);
        bitMap.add(99);
        bitMap.add(2);
        bitMap.add(9083);
        bitMap.add(1923);
        System.out.println(bitMap.find(12));
        System.out.println(bitMap.find(33));
        System.out.println(bitMap.find(1923));
        bitMap.remove(12);
        System.out.println(bitMap.find(12));
    }
}
