# Problem

`n`개의 계단을 `1`, `2` 스텝만 사용해서 오른다고 할 때, 계단을 오를 수 있는 가능한 모든 경우의 수는?

# My Solution

전형적인 dp문제.
f(n) = f(n-1) + f(n-2) 이고, f(n)을 여러번 계산하게 되므로 계산한 결과를 메모이제이션 해둔다.

```java
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
```
