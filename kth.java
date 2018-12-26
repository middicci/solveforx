import java.io.*;
import java.util.*;

public class KTH {
    
    int getKthlLargest(int arr[], int n, int k){
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for(int i=0; i<n; i++){
            if(q.size() < k ){
                q.offer(arr[i]);
            } else {
            
                Integer p = q.peek();
                if(arr[i] > p.intValue()){
                    q.poll();
                    q.offer(arr[i]);
                }
                
            }
        }
        return q.peek();
    }
    
    int getKthSmallest(int arr[], int n, int k){
        
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int i=0; i<n; i++){
            if(q.size()<k){
                q.offer(arr[i]);
            } else {
                Integer p = q.peek();
                if(arr[i] < p.intValue()){
                    q.poll();
                    q.offer(arr[i]);
                }
            }
        }
        return q.peek();
    }
    
    public static void main(String args[]) {
       KTH k = new KTH();
       int arr[] = {6,8,10,12,100,111,113};
       int l = k.getKthlLargest(arr, arr.length, 3);
       int s = k.getKthSmallest(arr, arr.length, 3);
       System.out.println("Kth largest " + l);
       System.out.println("Kth smallest " + s);
    }
}
