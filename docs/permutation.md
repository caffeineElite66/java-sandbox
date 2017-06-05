# Permutation
Best way to explain this is understand the following graph. See that we take each head of the string and pass it to the same method.

```java
static void perm(String prefix, String s) {
    if (s.length() == 2) {
        System.out.println(prefix + s.charAt(0) + s.charAt(1));
        System.out.println(prefix + s.charAt(1) + s.charAt(0));
    }
    for (int i = 0; i < s.length(); i++) {
        char head = s.charAt(i);
        String rest = s.substring(0, i) + s.substring(i + 1, s.length());
        perm(prefix + head, rest);
    }
}
```