import java.util.*;
import java.io.*;

public class Graph {
    int V;
    LinkedList<Integer> adj[];
    Graph(int v){
        V = v;
        adj = new LinkedList[V];
        for(int i=0; i<V; i++)
            adj[i] = new LinkedList();
    }
    
    void addEdge(int u, int v){
        adj[u].add(v);
    }
    void dfs(int s){
        boolean visited[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        st.push(s);
        while(!st.empty()){
            int n = st.pop();
            if(!visited[n]){
                visited[n] = true;
                System.out.println(" " + n);
            }
            Iterator<Integer> i = adj[n].listIterator();
            while(i.hasNext()){
                int v = i.next();
                st.push(v);
            }
        }
    }
    public static void main(String args[]) {
        Graph g = new Graph(5);
        
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(1, 4);

        System.out.println("Following is DFS for the graph::");
        g.dfs(0);
    }
}