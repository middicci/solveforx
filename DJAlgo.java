import java.util.*;
import java.io.*;

public class ShotestPath {
    int V;
    
    ShotestPath(int v){
        V=v;
    }
    
    int minDist(int dist[], boolean spt[]){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = 0; i<V; i++){
            if(!spt[i] &&  dist[i] <= min){
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }
    
    
    
    int[] dj(int mat[][], int s){
        int dist[] = new int[V];
        boolean spt[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            dist[i] = Integer.MAX_VALUE;
            spt[i] = false;
        }
        dist[s] = 0;
        for(int i=0; i<V-1; i++){
            
            int u = minDist(dist, spt);
            spt[u] = true;
            
            for(int v=0; v < V; v++){
                if(!spt[v] && dist[u] != Integer.MAX_VALUE && mat[u][v] !=0  && dist[v] > dist[u] + mat[u][v]){
                    dist[v] = dist[u] + mat[u][v];
                    
                }
            }
        }
        
        return dist;
    }
    
    void printSol(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.println(i + " " +arr[i]);
        }
    }
    public static void main(String args[]) {
       ShotestPath sp = new ShotestPath(9);
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                                 }; 

       sp.printSol(sp.dj(graph, 0));
    }
}
