import java.io.*;
import java.util.*;

public class Graph {
    int V;
    LinkedList<Integer> adj[];
    
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<V; i++ ){
            adj[i] = new LinkedList();
        }
    }
        
    void addEdge(int u, int v){
        adj[u].add(v);
    }
    
    boolean isCyclicUtil(int u, boolean visited[], int parent){
        visited[u] = true;
        int n;
        Iterator<Integer> i = adj[u].iterator();
        while(i.hasNext()){
            n = i.next();
            if(!visited[n]){
                if(isCyclicUtil(n, visited, u))
                    return true;
            }
            else if(n != parent)
                return true;
                
        }
        return false;
    }
    
    boolean isCyclic(){
        boolean visited[] = new boolean[V];
       
        for(int u=0; u<V; u++){
            if(!visited[u]){
                if(isCyclicUtil(u, visited, -1))
                    return true;
            }
        }
        return false;
    }
    
 
    
        
    
        
    
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        
        if(g.isCyclic())
            System.out.println("Graph is cyclic");
        else
            System.out.println("Graph is not cyclic");
        
        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        
        if(g2.isCyclic())
            System.out.println("Graph is cyclic");
        else
            System.out.println("Graph is not cyclic");
        
    }
}
