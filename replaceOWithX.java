public class replaceOWithX {

    private static void dfs(int row,int col,int[][] vis,char[][] mat,int n ,int m){
        vis[row][col]=1;

        int dr[]={-1,0,+1,0};
        int dc[]={0,+1,0,-1};

        for(int i=0;i<4;i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr<n && nr>=0 && nc<m && nc>= 0 && vis[nr][nc]==0 && mat[nr][nc]=='0'){
                vis[nr][nc]=1;
                dfs(nr,nc,vis,mat,n,m);
            }

        }
    }


    static char[][] fill(int n,int m , char[][] mat){

        int[][] vis = new int[n][m];

        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && mat[0][j]=='0'){
                dfs(0,j,vis,mat,n,m);
            }
            if(vis[n-1][j]==0 && mat[n-1][j]=='0'){
                dfs(n-1,j,vis,mat,n,m);
            }
        }

        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && mat[i][0]=='0'){
                dfs(i,0,vis,mat,n,m);
            }
            if(vis[i][m-1]==0 && mat[i][m-1]=='0'){
                dfs(i,m-1,vis,mat,n,m);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=0 && mat[i][j]=='0'){
                    mat[i][j]='X';
                }
            }
        }

        return mat;

    }
    
}
