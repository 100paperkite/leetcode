# Problem

두 이진 트리가 주어졌을 때, 각 트리의 리프 노드들의 순서가 같은지를 검사.

# My Solution

직접 순회해서 검사.

```java
class Solution {

    public void allLeafs(TreeNode root, ArrayList<Integer> leafs){
        if (root.left == null && root.right == null){
            leafs.add(root.val);
            return;
        }

        if (root.left != null){
            allLeafs(root.left, leafs);
        }
        if (root.right != null){
            allLeafs(root.right, leafs);
        }

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        var leafNodes1 = new ArrayList<Integer>();
        var leafNodes2 = new ArrayList<Integer>();

        allLeafs(root1, leafNodes1);
        allLeafs(root2, leafNodes2);

        return leafNodes1.equals(leafNodes2);
    }
}
```
