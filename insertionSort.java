import java.util.*;

public class InSort {
    
    void insertionsort(int arr[]){
        
        int n = arr.length;
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        
    }
    public static void main(String args[]) {
        InSort is = new InSort();
        int arr[] = {10, 2, 3, 29, 21, 6, 7};
        is.insertionsort(arr);
        for(int i=0; i<arr.length; i++)
            System.out.println(" "+arr[i]);
    }
}
