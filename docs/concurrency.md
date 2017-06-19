# Java 8 Concurrency

## Threads
Old way of doing things. Working directly with threads. Error prone.
```java
Runnable task = () -> {
  String threadName = Thread.currentThread().getName();
  System.out.println("Hello " + threadName);
}

task.run();
Thread thread = new Thread(task);
thread.start();
System.out.println("Done");
```

## Executors
Concurrency API help deal with threads. ExecutorService is higher level replacement for working with threads directly. It's really just a `pool of threads`.
```java
ExecutorService executor = Executors.newSingleThreadExectuor();
executor.submit(() -> {
  String threadName = Thread.currentThread().getName();
  System.out.println("Hello " + threadName);
});
```

*Executors do not shutdown like threads. You have to do it yourself*

### Executors can be scehduled
```java
ScheudledExecturoService executor = Executors.newScheduledThreadPool(1);
Ruanable task = () -> {
  try {
    TimeUnit.SECONDS.sleep(2);
    System.out.println("Scheduling: " + System.nanoTime());
  } catch (InterruptedException e) {
    System.err.println("task interrupted");
  }
}

executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
```

## Callables
Addition to `Runnable`, `Callables` are interfaces like `Runnable`. Instead of void returns, it can have a return value.
```java
Callable<Integer> task = () -> {
  try {
    TimeUnit.SECONDS.sleep(1);
    return 123;
  } catch (InterruptedException e) {
    throw new IllegalStateException("task interrupted", e);
  }
};
```

Callable can be submitted to `Executor` just like `Runnable`. Executor cannot wait for the task to complete, and so you can not get the return result directly. Executor instead return a `Future`.
```java
ExecutorService executor = Executors.newFixedThreadPool(1);
Future<Integer> future = executor.submit(task);
System.out.println("Future done? " + future.isDone());
Integer result = future.get();
System.out.println("Futute done? " + future.isDone());
System.out.println("result: " + result);
```

### Invoke Callables
```java
ExecutorService executor = Executors.newWorkStealingPool();
List<Callable<String>> callables = Arrays.asList(
  () -> "task1",
  () -> "task2"
);
executor.invokeAll(callables)
  .stream()
  .map(future -> {
    try {
      return future.get();
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  })
  .forEach(System.out::println);
```

# Synchronized 

# Locks

# Semaphores

# AtomicInteger 

# ConcurrentMap
Does not lock the map while read. Does not lock the whole map while write. Does not throw ConcurrentModificationException if change while being iterated. The Iterator is not designed to be used by more than one thread though. 

*ConcurrentHashMap vs. Collections.synchronizedMap(Map)*
ConcurrentHashMap allow concurrent reads without blocking, better performance but you might not get most updated reads. Synchronized map use blocking on reads so low on performance, but ensure consistency. 

## ConcurrentHashMap parallel operations
#### ForEach
```java
int minSize = 1 // each thread will have this minSize collection.
map.forEach(minSize, (key, value) -> doThing(key, value));
```
#### Search
Will find 1 result only and stop.
```java
map.search(minSize, (key, value) -> {
    if ("foo".equals(key)) {
        return value;
    }
    return null;
});
```
#### Reduce
The method `reduce()` already know from java 8 streams accepts two lambda expressions of type `BiFunction`. The first function transforms each key-value pair into a single value of anytyhpe. The second function combines all those transformed values into a single result, ignoring any possible `null` values.
```java
String result = map.reduce(1,
    (key, value) -> {
        System.out.println("Transform: " + Thread.currentThread().getName());
        return key + "=" + value;
    },
    (s1, s2) -> {
        System.out.println("Reduce: " + Thread.currentThread().getName());
        return s1 + ", " + s2;
    });

System.out.println("Result: " + result);

// Transform: ForkJoinPool.commonPool-worker-2
// Transform: main
// Transform: ForkJoinPool.commonPool-worker-3
// Reduce: ForkJoinPool.commonPool-worker-3
// Transform: main
// Reduce: main
// Reduce: main
// Result: r2=d2, c3=p0, han=solo, foo=bar
```