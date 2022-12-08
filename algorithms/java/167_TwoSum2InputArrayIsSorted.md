# Problem

감소하지 않는 정수 배열이 주어졌을 때, 두 수를 더해서 `target`을 만들 수 있는 인덱스 구하기.

# My Solution

배열의 양 끝에서 중앙으로 탐색. O(N)

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int start = 0, end = n - 1;

        while(start>=0 && end < n){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
               break;
            }
            else if(sum <target){
                start++;
            }
            else {
                end--;
            }
        }
        return new int[]{start+1, end+1};
    }
}
```
