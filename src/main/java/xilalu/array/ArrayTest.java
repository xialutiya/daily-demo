package xilalu.array;

import org.springframework.util.Assert;

public class ArrayTest {
    private int size;
    private int index;
    private int[] data;

    public ArrayTest(int size) {
        this.size = size;
        index = 0;
        data = new int[size];
    }

    public void add(int n) {
        if (index < size) {
            data[index++] = n;
        } else {
            resize();
            data[index++] = n;
        }
    }

    public void deleted(int c) {
        if (c < 0 || c >= size) {
            Assert.isTrue(false, "数组下标越界!");
        } else if (c > index - 1) {
            data[c] = 0;
        } else {
            for (int i = c; i < index; i++) {
                data[i] = data[i + 1];
            }
        }
        index--;
    }

    public void update(int c, int n) {
       if (c < 0 || c >= size) {
           Assert.isTrue(false, "数组下标越界!");
       } else {
           data[c] = n;
       }
    }

    public int get(int c) {
        if (c < 0 || c >= size) {
            Assert.isTrue(false, "数组下标越界!");
        }
        return data[c];
    }

    public void insert(int c, int n) {
        if (c < 0 || c >= size) {
            Assert.isTrue(false, "数组下标越界!");
        }
        if (index < size) {
            for (int i = size - 1; i > c; i--) {
                data[i] = data[i - 1];
            }
            data[c] = n;
            index++;
        } else {
            resize();
            insert(c, n);
        }
    }

    public void toArrayTest() {
        for (int i = 0; i < index; i++) {
            System.out.println(data[i]);
        }
    }

    public void resize() {
        int len  = size * 2;
        int[] dataNew = new int[len];
        System.arraycopy(data, 0, dataNew, 0, size);
        size = len;
        data = dataNew;
    }
}
