package xilalu.validate;

/**
 * volatile可以保证被修饰共享变量的可见性与有序性.
 * 如果一个线程修改了被volatile修饰的共享变量的值,
 * 新值可以立即被其它线程得到.
 */
public class VolatileTest {

    volatile boolean initFlag = false;

    public void save() {
        this.initFlag = true;
        String threadname = Thread.currentThread().getName();
        System.out.println("线程：" + threadname + ":修改共享变量initFlag");
    }

    public void load() {
        String threadname = Thread.currentThread().getName();
        while (!initFlag) {
            //线程在此处空跑，等待initFlag状态改变
        }
        System.out.println("线程：" + threadname + "当前线程嗅探到initFlag的状态的改变");
    }

    public static void main(String[] args) {
        VolatileTest sample = new VolatileTest();
        Thread threadA = new Thread(() -> {
            sample.save();
        }, "threadA");
        Thread threadB = new Thread(() -> {
            sample.load();
        }, "threadB");
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }
}
