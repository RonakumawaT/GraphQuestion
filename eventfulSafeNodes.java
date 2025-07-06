import java.util.*;

public class eventfulSafeNodes {

    private static boolean dfs(int node,int[] vis,int[] pathVis,List<List<Integer>> adj,int[] check){
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;

        for(int nextNode : adj.get(node)){
            if(vis[nextNode]==0){
                check[node]=0;
                if(dfs(nextNode, vis, pathVis, adj, check)==true)return true;
            }else if(pathVis[nextNode]==1){
                check[node]=0;
                return true;
            }
        }
        check[node]=1;
        pathVis[node]=0;
        return false;
    }

    List<Integer> event(int V ,List<List<Integer>> adj){
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,pathVis,adj,check);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
}
