# Problem

`m x n`이차원 배열에서 `1`이 섬이라고 할 때, 해당 배열에서 섬의 개수 찾기

# My Solution

전형적인 dfs/bfs 문제.

```java
class Solution {
    public int AreaOfIsland(int[][] grid, int sy, int sx){
        int height = grid.length, width = grid[0].length;
        if (sy >= height || sy <0 || sx >= width || sx <0){
            return 0;
        }
        if (grid[sy][sx] != 1){
            return 0;
        }

        int area = 1;
        grid[sy][sx] = -1; // visited;
        area += AreaOfIsland(grid, sy+1, sx);
        area += AreaOfIsland(grid, sy, sx+1);
        area += AreaOfIsland(grid, sy-1, sx);
        area += AreaOfIsland(grid, sy, sx-1);

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i<grid.length;i++){
            for (int j =0;j<grid[0].length;j++){
                if (grid[i][j] == 1){
                    int area = AreaOfIsland(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
```
