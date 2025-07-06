import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class distinctIslands {

    int count(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        HashSet<ArrayList<String>> st = new HashSet<>();
        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0){
                    ArrayList<String> arr = new ArrayList<>();
                    dfs(i,j,grid,vis,arr,i,j,n,m);
                    st.add(arr);
                }
            }
        }
        return st.size();
    }

    private void dfs(int i, int j, int[][] grid, int[][] vis, ArrayList<String> arr, int i2, int j2, int n, int m) {
        vis[i][j] = 1;
        arr.add(toString(i-i2,j-j2));
        int[] dr = {-1,0,+1,0};
        int[] dc = {0,+1,0,-1};

        for(int ii=0;ii<4;ii++){
            int nr = i + dr[ii];
            int nc = j + dc[ii];

            if(nr<n && nr>=0 && nc<m && nc>=0 && grid[nr][nc]==1 && vis[nr][nc]==0){
                dfs(nr,nc,grid,vis,arr,i2,j2,n,m);
            }

        }

    }

    private String toString(int r,int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    
}
