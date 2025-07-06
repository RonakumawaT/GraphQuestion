import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class cycleInDirectedGraph {

    private static boolean dfs(int node,int[] vis,int[] pathVis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        pathVis[node]=1;

        for(Integer nextNode : adj.get(node)){
            if(vis[nextNode]==0){
                if(dfs(nextNode, vis, pathVis, adj)==true) return true;
            }else if(pathVis[nextNode]==1){
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }

    boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){

        int[] vis = new int[V];
        Arrays.fill(vis,0);
        int[] pathVis = new int[V];
        Arrays.fill(pathVis,0);

        for(int i=1;i<=V;i++){
            if(vis[i]==0){
                if(dfs(i,vis,pathVis,adj)==true) return true;
            }
        }
        return false;
    }
    
}
