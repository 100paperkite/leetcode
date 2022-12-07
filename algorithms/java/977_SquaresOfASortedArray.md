# Problem

감소하지 않는 숫자 배열이 주어졌을 때, 각 숫자의 제곱을 감소하지 않는 순서대로 정렬할 것.

# My Solution

O(N)

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int left = -1;
        int right = 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] >= 0){
                break;
            }
            left++;right++;
        }

        int resultIndex = 0;
        while (left >= 0 && right < nums.length){
            if (-nums[left] < nums[right]){
                result[resultIndex++] = nums[left]*nums[left];
                left--;
            }
            else {
                result[resultIndex++] = nums[right]*nums[right];
                right++;
            }
        }

        while (left >= 0){
            result[resultIndex++] = nums[left]*nums[left];
            left--;
        }

        while (right < nums.length) {
            result[resultIndex++] = nums[right]*nums[right];
            right++;
        }

        return result;
    }
}
```

# Top Rated Solution

O(N)

```java
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
```

# 📍 What I Learned

- 이미 정렬되어 있고, 제곱 값으로 정렬하는 것이므로 양 끝점끼리(Min, Max) 검사하면 된다.
