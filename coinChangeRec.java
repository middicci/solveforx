public class Change {
    
    public static int coinChange(int S[], int m, int n){
        if(n == 0){
            return 1;
        }
        
        if(n < 0){
            return 0;
        }
        
        if(m <= 0 && n >= 1 ){
            return 0;
            
        }
        
        return coinChange(S, m - 1, n) + coinChange(S, m, n - S[m-1]);
    }
    
    public static void main(String args[]) {
       Change c = new Change();
       
       int arr[] = {1, 2, 3};
       
       int m = arr.length;
       
        System.out.println("No ways to change " + coinChange(arr, m, 10));
    }
}
