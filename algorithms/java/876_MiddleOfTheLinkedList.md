# Problem

링크드 리스트의 중앙 노드를 구하기.

# My Solution

링크드 리스트에 포인터를 두 개 두고, 하나는 +1만큼, 하나는 +2씩 움직이다가 +2 포인터가 리스트 끝에 다다르면 +1포인터는 중앙에 와 있음.

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        var first = head;
        var second = head;

        while (second.next != null){
            first = first.next;
            second = second.next;
            if (second.next != null){
                second = second.next;
            }
        }
        return first;
    }
}
```
