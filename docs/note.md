## Maximum Stack
#### A stack that keep track of maximum value in stack.

Use another stack to keep track of max or min value as they push and pop.

---
## Detect Circular LinkedList
#### Detecting a LinkedList that has circular reference.

Use two pointers, SLOW and FAST. SLOW will increment +1 while FAST increment +2. When both equal at some point, that means the list is circular. We reset SLOW to start while keeping FAST at the same spot. Increment each by +1. When they match, that's the beginning of the circular node.  
```
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
```
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
```
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
```
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
