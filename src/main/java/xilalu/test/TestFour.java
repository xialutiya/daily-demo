package xilalu.test;

import xilalu.entity.Person;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

/**
 * @author lds
 * @date 2021/1/20 16:36
 */
public class TestFour {
    public static void main(String[] args) throws InterruptedException {

        int current = 1, pages = 9;
        ExecutorService executor = Executors.newFixedThreadPool(pages - 1);
        CompletableFuture<Void> all = null;
        Person person = new Person();

        for (current = 2; current <= pages; current++) {
//            generalViewRangeSearchQry.setPageNo(current);
            person.setAge(current);
            System.out.println("one===>" + Thread.currentThread().getId() + ":" + current);
            int finalCurrent = current;
            System.out.println("tow===>" + Thread.currentThread().getId() + ":" + finalCurrent);
            final int currentOne = current;
            CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
                try {

                    Thread.sleep(2000);
                    System.out.println("three===>" + Thread.currentThread().getId() + ":" + currentOne);
//                    addOpenidSet(generalViewRangeSearchQry, concurrentHashMap);
                } catch (Exception e) {
//                    log.error("异步执行查询uc 用户openid出错{}", e.getMessage());
                }
                return String.valueOf(finalCurrent);
            }, executor);
            cf.whenComplete((t, u) -> {
//                    log.info("t==={}", t);
            });
//            all = CompletableFuture.allOf(cf);
//            Thread.sleep(1000);
        }
    }
}
