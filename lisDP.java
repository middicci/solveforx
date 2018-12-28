public class LIS {
    
    int lis(int arr[], int n){
        if(n==1)
            return 1;
        
        int l[] = new int[n+1];
        int max = 0;
        
        for(int i=0; i<n; i++){
            l[i] = 1;
        }
        
        for(int i = 1; i<n; i++)
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && l[i] < l[j] + 1)
                    l[i] = l[j] + 1;
            }
        
        for(int i=0; i<n; i++){
            if(max < l[i])
                max = l[i];
        }
        
        return max;        
    }
    
    public static void main(String args[]) {
        int arr[] = {10, 20, 30, 40, 8, 9, 11, 70, 80};
        LIS ls = new LIS();
        int l = ls.lis(arr, arr.length);

        System.out.println("LIS = " + l );
    }
}
