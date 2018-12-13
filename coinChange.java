
import java.util.Arrays;

public class CoinChange {
    
    public static long coinChangeWays(int S[], int m, int n){
        long table[] = new long[n+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for(int i=0; i< m; i++){
            for(int j=S[i]; j<=n; j++){
                table[j] += table[j-S[i]];
            }
        }
        return table[n];
    }
    
    public static void main(String args[]) {
        int arr[] = {1,2,3};
        int m = arr.length;
        CoinChange cc = new CoinChange();
        System.out.println("count coin change Ways : " + cc.coinChangeWays(arr, m , 10));
    }
}
