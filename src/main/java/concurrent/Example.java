package concurrent;


import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Example {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ConcurrentHashMap<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();

        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
            concurrentMap.put(i, i);
        }

        Instant start = Instant.now();
        map.forEach((key, value) -> System.out.print(key + ":" + value));
        Instant end = Instant.now();
        System.out.println("\n\n" + Duration.between(start,end));

        start = Instant.now();
        concurrentMap.forEach((key, value) -> System.out.print(key + ":" + value));
        end = Instant.now();
        System.out.println("\n\n" + Duration.between(start,end));
    }


}
