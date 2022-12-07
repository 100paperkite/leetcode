# Problem

배열이 주어졌을 때, `k`횟수 만큼 회전시킨 배열을 구할 것.

# My Solution

가장 간단한 방법. Queue에 넣어서 직접 돌림.

```java
class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=nums.length-1;i >=0; i--){
            queue.add(nums[i]);
        }

        k %= nums.length;
        while (k > 0){
            queue.add(queue.remove());
            k--;
        }

        int index = nums.length-1;
        while (queue.peek() != null){
            nums[index--] = queue.remove();
        }

    }
}

```

# [Top Rated Solution](https://leetcode.com/problems/rotate-array/solutions/54250/easy-to-read-java-solution/?orderBy=most_votes)

직접 돌릴 필요가 없다. 회전한 배열은 배열을 반대로 뒤집어서 구할 수 있음.

```java
public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
```
