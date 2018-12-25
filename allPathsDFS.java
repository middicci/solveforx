import java.util.*;
import java.io.*;

public class Graph {
    int V;
    LinkedList<Integer> adj[];
    Graph(int v){
        V = v;
        adj = new LinkedList[V];
        
        for(int i=0; i<V; i++){ 
            adj[i] = new LinkedList();
        }
    }
    
    void addEdge(int u, int v){
        adj[u].add(v);
    }
    
    void printAllPathUtil(int s, int d, boolean visited[], List<Integer> pathList){
        
        visited[s] = true;
        
        if(s == d){
            System.out.println(pathList);
            visited[s] = false;
            return;
        }
        Iterator<Integer> i = adj[s].listIterator();
        
        while(i.hasNext()){
            Integer n = new Integer(i.next());
            if(!visited[n]){
                
                pathList.add(n);
                printAllPathUtil(n, d, visited, pathList);
                pathList.remove(n);
            }
            
        }
        
        visited[s] = false;
    }
    
    void printAllPaths(int s, int d){
        boolean visited[] = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(s);
        printAllPathUtil(s, d, visited, pathList);
    }
    
    public static void main(String args[]) {
       Graph g = new Graph(4);
        g.addEdge(0,1); 
        g.addEdge(0,2); 
        g.addEdge(0,3); 
        g.addEdge(2,0); 
        g.addEdge(2,1); 
        g.addEdge(1,3);

        g.printAllPaths(2, 3);
    }
}
