import java.util.ArrayList;
import java.util.Arrays;

public class bipartite{

    private static boolean dfs(int row,int col,int[] color,ArrayList<ArrayList<Integer>> adj){
        color[row] = col;

        for(Integer it : adj.get(row)){
            if(color[it]==-1){
                if(dfs(it,1-col,color,adj)==false) return false;
            }else if(color[it] == col){
                return false;
            }
        }
        return true;
    }

    public boolean isB(int V , ArrayList<ArrayList<Integer>> adj){

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,adj)==false) return false;
            }
        }
        return true;
    }

}

//this for the fearture 1 git commit
//this for the feature 2 git commit