package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSALG {
    private int V;
    private LinkedList<Integer> adj[];

    public BFSALG(int v) {
        V = v;
        for(int i = 0; i<v; i++){
            adj = new LinkedList[v];
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.println(v + " ");
        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()){
            int n = it.next();
            if(!visited[n]){
                    DFSUtil(n,visited);
            }
        }
    }

    public void DFS(int v){
        boolean visited[] = new boolean[v];

        DFSUtil(v, visited);
    }

}
