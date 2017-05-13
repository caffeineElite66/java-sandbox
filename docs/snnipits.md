## Java 8 Stream API
#### General stream operations
```java
transactions.stream()
            .filter(t -> t.getType() == transaction.GROCERY)
            .sorted(comparing(Transaction::getValue).reversed())
            .map(Transaction::getId)
            .collect(toList());
```
#### Count lines in file
```java
long numberOfLines = Files.lines(Paths.get("file.txt"), Charset.defaultCharset())
                          .count();
```
#### Generating numbers
```java
IntStream oddNumbers = IntStream.rangeClosed(10, 30)
                                .filter(n -> n % 2 == 1);
```
---
## Java 8 Loops
---
## Java 8 sort ArrayList
sorting with `Collectors` static class
```java
Collections.sort(arraylist, (p1, p2) -> p1.a - p2.a);
```
sorting with stream. stream sorted takes in a comparator. you need to define your own and can chain them. return type of `collect()` is Interface List. Cannot be ArrayList.
```java
Comparator<Pair> compByStartTime = (p1, p2) -> p1.a - p2.a;
Comparator<Pair> compByEndTime = (p1, p2) -> p1.b - p2.b;

List<Pair> newList = list.stream()
  .sorted(compByStartTime.thenComparing(compByEndTime))
  .collect(Collectors.toList());
```
