import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    int third;
    public Pair(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class distanceOfNearestCell {


    public int[][] nearest(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.offer(new Pair(i, j, 0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }

        int[] dr = {-1,0,+1,0};
        int[] dc = {0,+1,0,-1};

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int dist = q.peek().third;

            q.poll();

            dis[row][col] = dist;

            for(int i=0;i<4;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr< n && nr>=0 && nc>=0 && nc<m && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.offer(new Pair(nr, nc, dist+1));
                } 
            }
        }
        return dis;
    }
}
