# Problem

이진 트리에서 노드끼리 연결해서 만들 수 있는 경로의 모든 노드의 합 중 최댓값 구하기. (단 만들어지는 경로는 루트 노드를 넘어가지 않음)

# My Solution

서브 트리에서 만들 수 있는 최대 값으로 Recursive만 풀면 안된다.(서브 트리에서 만든 경로가 루트노드를 포함하지 않을 수 있음) 서브 트리에서 루트 노드를 포함하는 경우는 재귀적으로 합하고, 포함하지 않는 경우는 합하지 않고 최대를 판단해서 풀었음.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPath = -1000;
    public int maxPathSumRecursive(TreeNode root){
        if (root == null){
            return 0;
        }

        int maxPath = -1000;
        int left = maxPathSumRecursive(root.left), right = maxPathSumRecursive(root.right);

        this.maxPath = Math.max(this.maxPath, left + right + root.val);
        this.maxPath = Math.max(this.maxPath, left + root.val);
        this.maxPath = Math.max(this.maxPath, right + root.val);
        this.maxPath = Math.max(this.maxPath, root.val);

        maxPath = Math.max(maxPath, left + root.val);
        maxPath = Math.max(maxPath, right + root.val);
        maxPath = Math.max(maxPath, root.val);

        return maxPath;
    }

    public int maxPathSum(TreeNode root) {
        int maxPathWithRoot = maxPathSumRecursive(root);
        return Math.max(maxPathWithRoot, this.maxPath);
    }
}
```
