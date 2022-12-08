# Problem

숫자 배열의 `0`을 전부 오른쪽으로 옮기기. (단 `0`이 아닌 숫자들의 순서는 바뀌면 안된다)

# My Solution

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int lastNonZeroIndex = 0;
        for (int i=0;i<n;i++){
            if (nums[i]!=0){
                // swap
                int temp = nums[i];
                nums[i] = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex] = temp;
                lastNonZeroIndex++;
            }
        }
    }
}
```
