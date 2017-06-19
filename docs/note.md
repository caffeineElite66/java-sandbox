## Problem Solving Approach
Good engineer come up with a solution. Great engineer come up with many and weight pros and cons. 


## Maximum Stack
#### A stack that keep track of maximum value in stack.

Use another stack to keep track of max or min value as they push and pop.

---
## Detect Circular LinkedList
#### Detecting a LinkedList that has circular reference.

Use two pointers, SLOW and FAST. SLOW will increment +1 while FAST increment +2. When both equal at some point, that means the list is circular. We reset SLOW to start while keeping FAST at the same spot. Increment each by +1. When they match, that's the beginning of the circular node.  
```java
public ListNode detectCycle(ListNode a) {
  ListNode fast = a;
  ListNode slow = a;
  boolean hasCycle = false;
  while(fast != null && fast.next != null && slow != null){
      fast = fast.next.next;
      slow = slow.next;
      if(fast == slow){
          hasCycle = true;
          break;
      }
  }
  if(!hasCycle) return null;
  else{
      fast = a;
      while(fast != slow){
          fast = fast.next;
          slow = slow.next;
      }
      return fast;
  }

}
```

---
## XOR to find single elements in pairs
#### Having list of int where all are in pairs except one. Find the one int that doesn't have a matching pair.

When `0 ^ 0 = 0`, `0 ^ 1 = 1`, `1 ^ 1 = 0` with XOR. If you have `list = [1,1,3,4,3,5,4]`, you can do the following to find 5:
```java
int oddManOut = 0;
for (int a : list) {
  oddManOut ^= a;
}
return oddManOut;
```
---
## JAVA 8 Collections
#### Get top 10 words where words store in map as <word, count>

With JAVA 8, we can use the `stream` API
```java
map.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .limit(10)
        .forEach(System.out::println);
```
---
## Two Points
#### From a list of numbers, find all possible pairs that add up to a diff.

For example, we have a list of `[1,4,5,2,3,7,6]`. We want to find pairs that add up to `5`.
1. Sort the array arr
2. Take two pointers, l and r, both pointing to 1st element
3. Take the difference arr[r] – arr[l]
4. If value diff is K, increment count and move both pointers to next element
if value diff > k, move l to next element
if value diff < k, move r to next element
return count
```java
int countPairsWithDiffK(int arr[], int n, int k) {
    int count = 0;
    sort(arr, arr+n);  // Sort array elements

    int l = 0;
    int r = 0;
    while(r < n) {
         if(arr[r] - arr[l] == k) {
              count++;
              l++;
              r++;
        }
         else if(arr[r] - arr[l] > k)
              l++;
         else // arr[r] - arr[l] < sum
              r++;
    }   
    return count;
}
```
---
## Sum two binary strings
#### Given 2 binary represented in string. Sum them up and return their string representation. Keep in mind that strings can be longer than int. In this case you might want to use long instead.
```java
private static String sumBinaryStrings(String s1, String s2) {

      ArrayList<Character> list1 = new ArrayList<>();
      ArrayList<Character> list2 = new ArrayList<>();

      for (Character c : s1.toCharArray()) list1.add(c);
      for (Character c : s2.toCharArray()) list2.add(c);

      ArrayList<Integer> result = new ArrayList<Integer>();
      int carry = 0;

      while (!list1.isEmpty() || !list2.isEmpty()) {
        // remove last index
        int a = (list1.isEmpty()) ? 0 : Character.getNumericValue(list1.remove(list1.size() - 1));
        int b = (list2.isEmpty()) ? 0 : Character.getNumericValue(list2.remove(list2.size() - 1));

        int answer = (a + b + carry);

        if (answer == 3) {
          answer = 1;
          carry = 1;
        } else if (answer == 2){
          answer = 0;
          carry = 1;
        } else {
          carry = 0;
        }

        result.add(0, answer);
      }

      if (carry == 1) result.add(0, 1);

      String stringAnswer = "";
      for (int digit : result) {
        stringAnswer += String.valueOf(digit);
      }
      return stringAnswer;
  }
```
---
## Permutation of string
#### This was harder than it looks
```java
  private static void perm(String prefix, char[] body) {

    if (body.length == 2) {
      System.out.println(prefix + body[0] + body[1]);
      System.out.println(prefix + body[1] + body[0]);
    }

    for (int i = 0; i < body.length; i++) {
      char tempHead = body[0];
      body[0] = body[i];
      body[i] = tempHead;
      perm(String.valueOf(prefix+body[0]), removeHead(body));
    }
  }
```
---
## Bitwise operation
```
a     = 0011 1100
b     = 0000 1101
-----------------
a&b   = 0000 1100 AND both need to be 1
a|b   = 0011 1101 OR either bits is 1
a^b   = 0011 0001 XOR - one bit is 1, but not both
~a    = 1100 0011 Ones complement. Filp the bits.
a<<2  = 1111 0000 Left shift - will give you square
a>>2  = 1111 right shift - will give you square root
a>>>2 = 0000 1111 rigth shift with 0 filled.
```
---
## Printing Matrix
#### print in spiral
##### Use 4 for loops for each direction. Decrease row and col count each time

## Tricks with Mod operator.

## JAVA Type Conversions
```java
Integer.valueOf("10"); // String --> Integer
String.valueOf(10); // Integer --> String
s.charAt(1); // String --> Character
String.valueOf('a'); // Character --> String
"Something".toCharArray(); // string --> char[]
```

## In-place shuffle
Write a function that does in-place shuffle of an arry. Each number must have same probability of ending up in each spot. 
1. For each slot, we generate a number from 0 to size of current array. SizeOfArray--.

## The common series
When you have to sum all integer from 0 to n. 
`1+2+3+4+5+6+7+8+9+10` --> O(n^2/2) --> O(n^2)


