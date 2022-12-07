# Problem

일별 온도 배열이 주어졌을 때 각 온도보다 높은 온도가 나타나는 날짜까지 걸리는 시간 구하기. (배열 순서가 곧 날짜)

# My Solution

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[temperatures.length];
        for (int index=0;index<temperatures.length;index++){
            int t = temperatures[index];

            while (!stack.empty() && temperatures[stack.peek()] < t){
                var poppedIndex = stack.pop();
                result[poppedIndex] = index - poppedIndex;
            }
            stack.push(index);

        }
        return result;
    }
}
```
