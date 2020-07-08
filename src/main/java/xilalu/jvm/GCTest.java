package xilalu.jvm;

public class GCTest {
    public static void main(String[] args) {
        // -XX:+PrintGCDetails
        byte[] allocationOne, allocationTwo, allocationThree,
                allocationFour, allocationFive, allocationSix;

//        allocationOne = new byte[1024* 1024 * 1024];
//        allocationTwo = new byte[1024 * 1024 * 1024];
        allocationThree = new byte[63 * 1024 * 1024];
        allocationFour = new byte[21 * 1024 * 1024];
        allocationFive = new byte[21 * 1024 * 1024];
        allocationSix = new byte[21 * 1024 * 1024];
    }
}
